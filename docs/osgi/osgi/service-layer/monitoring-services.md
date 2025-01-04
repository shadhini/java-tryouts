---
icon: monitor-waveform
---

# Monitoring Services

## Monitoring Services

### `Services are dynamic`.

* A bundle developer must not assume the availability of the service at any moment.&#x20;
* Bundle can decide to withdraw its service from the registry while other bundles are still using this service.&#x20;
* A Service may not be registered at the other bundles trying to use it
  * depends on the start order of bundles.&#x20;

{% hint style="success" %}
It is highly recommended **not do depend on the starting order of bundles**.
{% endhint %}

{% hint style="success" %}
Bundle developer should write code to handle this **dynamic behavior of services**.

╰**---**➤ Use **`Monitoring Services`**
{% endhint %}



### Monitoring Mechanisms

1. Service Listeners&#x20;
2. Service Trackers&#x20;
3. ✅ Declarative Service&#x20;
4. iPOJO&#x20;
5. Blueprint services



## Service Listeners

{% hint style="info" %}
Intriduced from R1 spec.
{% endhint %}



* When a `ServiceEvent` is **fired**, it is **synchronously delivered to** a `ServiceListener`.

```java
Public interface ServiceListener{
    public void serviceChanged(ServiceEvent event);
}
```



```java
public class HelloServiceListener implements ServiceListener{

    public void start(BundleContext context) throws Exception {
        context.addServiceListener(this);
    }
    
    public void stop(BundleContext context) throws Exception {
        context.removeServiceListener(this);
    }
    
    public void serviceChanged(ServiceEvent event) {
        switch(event.getType()){
            case ServiceEvent.UNREGISTERING:
                break;
            case ServiceEvent.REGISTERED:
                break;
            case ServiceEvent.MODIFIED:
                break;
            }
    }
}
```



{% hint style="danger" %}
If the **service is registered before adding the listener**,&#x20;

&#x20;       listener will not get the REGISTERED event.
{% endhint %}

* ✅ First try to get the service, then register the listener.

```java
public class HelloServiceListener implements ServiceListener{
    public void start(BundleContext context) throws Exception {
        ref = context.getServiceReference(HelloService.class.getName());
        if(ref != null){
            helloService = (HelloService)context.getService(ref);
        }
        context.addServiceListener(this);
    }
}
```

{% hint style="danger" %}
Service Listeners Problems:&#x20;

* **Race conditions**: Multiple threads may access and modify shared resources concurrently, leading to unpredictable behavior.
* **listener leaks**: Listeners that are not properly unregistered can lead to memory leaks and resource exhaustion.
{% endhint %}



## Service Trackers

{% hint style="info" %}
Introduced in R2 specification.
{% endhint %}



* Defines a **utility class**, `ServiceTracker` which significantly reduces the complexities of service listeners.&#x20;
* `ServiceTracker` **can be customized**&#x20;
  * by implementing the interface `ServiceTrackerCustomizer` or&#x20;
  * by sub-classing the `ServiceTracker` class.&#x20;

{% hint style="success" %}
Service Trackers:

* **Ideal solution** for **tracking one service**.&#x20;
* A better solution to **remove** the **start level dependency**.
{% endhint %}

```java
public class Activator implements BundleActivator {
    public void start(BundleContext bc) {
        tracker = new ServiceTracker(bundleContext,
                HelloService.class.getName(), null );
        tracker.open();
    
        HelloService service = (HelloService) tracker.getService();
    
        if (service!=null) {
            service.sayHello(“Service Tracker”);
            service = null;
        }
    }
    
    public void stop(BundleContext bc) {
        tracker.close()
    }
}
```



{% hint style="danger" %}
Service Trackers Problems:&#x20;

* must be closed otherwise listener leaks occur
* writing a customizer to handle more than one service is complicated
{% endhint %}



## ✅ Declarative Services

{% hint style="info" %}
Introduced in R4.
{% endhint %}



> **Declarative Services**:
>
> a way for a bundle to **declare the services it registers and acquires in an XML file**

* Allows developers to keep OSGi code away from domain logic.
* **`SCR`**: `Service Component Runtime` — runtime portion of the declarative service&#x20;

### Services Component | Component

> **`Component`: Services Component**:
>
> a normal Java class (**POJO**) and it is declared in an **XML document**.

* contains a description that is interpreted at run time to **create and dispose objects** depending on the&#x20;
  * availability of other services&#x20;
  * need for such an object&#x20;
  * available configuration data.&#x20;
* Can optionally provide as OSGi service.&#x20;



* **Component Description**:
  * Declaration of a service component within an XML document in a bundle.
* **Component Properties**:
  * Properties specified by&#x20;
    * the component description,&#x20;
    * `Configuration Admin` service, and&#x20;
    * component factory.
* **Component Configuration**:
  * Represents a component description parameterized by component properties.
  * Tracks dependencies and manages component instances.
  * Activated configuration has a `component context`.
* **Component Instance**:
  * Instance of the component implementation class.
  * Created when configuration is activated,&#x20;
    * discarded when deactivated.
  * Associated with one component configuration.



### Declaring a Service

A component requires the following **artifacts** in the **bundle**:

1.  An XML document that contains the component description.&#x20;

    `/OSGI­-INF/example.xml`
2.  The **Service-Component** **manifest header** which names the XML documents that contain the component descriptions.&#x20;

    `Service­-Component: OSGI-­INF/example.xml`
3. An implementation class that is specified in the component description



#### Example 1: Component that reference a service

Description of a component which reference a service.

```xml
<?xml version="1.0" encoding="UTF­8"?>
<component name="helloservice.listen">
    <implementation class="org.sample.HelloComponent”/>
    <reference name="HS"
        interface="org.helloworld.HelloService"
        bind="setHelloService"
        unbind="unsetHelloService” />
</component>
```

Component implementation class

```java
public class HelloComponent {
    HelloService hs;
    protected void setHelloService(HelloService s) { hs = s; }
    protected void unsetHelloService(HelloService s) { hs = null; }
    protected void activate(ComponentContext ctxt) {...}
    protected void deactivate(ComponentContext ctxt) {...}
}
```



#### Example 2: Componenet that publish a service

Description of a component which publish a service.

```xml
<?xml version="1.0" encoding="UTF­8"?>
<component name="example.handler">
    <implementation class="org.helloworld.HelloServiceImpl"/>
    <service>
        <provide interface="org.helloworld.HelloService"/>
    </service>
<component>
```



### Component Life Cycle

component life cycle us contained within the bundle life cycle

**`Enabled`**&#x20;

* Initial `enabled` state of a component is specified in the component description
  * using the `enabled` attribute. &#x20;
* A component is enabled if the **bundle** is **started** and the `enabled` **attribute** is set to `true`.&#x20;
  * The default value is `true`.&#x20;
* A component should become `enabled` before it can be used.

**`Satisfied`**&#x20;

*   A component can become `satisfied`, if the following conditions are met&#x20;

    * The component is `enabled`.&#x20;
    * Using the component properties of the component configuration, all the **component's references are satisfied**.&#x20;


* **Reference** is **satisfied**&#x20;
  * when the reference specifies optional cardinality or&#x20;
  * there is at least one target service for the reference





### **`SCR`**: Service Component Runtime

* manages the **components** and their **life cycle.**&#x20;
* responsible for **activating** and **deactivating** Component Configurations
* Listens for bundles that become active (`Active` state) and detects Component Descriptions&#x20;

#### Activation

* when&#x20;
  * the component is `enabled` and&#x20;
  * the component configuration is `satisfied` and&#x20;
  * a component configuration is **needed**
* During the life time of a component configuration, SCR can notify the component of changes in its bound references.&#x20;

#### Deactivation

deactivate a previously activated component configuration&#x20;

* when&#x20;
  * the component becomes `disabled`,&#x20;
  * the component configuration becomes `unsatisfied`, or&#x20;
  * the component configuration is **no longer needed**.



### Types of Components: Publishing Services

#### **`Delayed Component`**&#x20;

whose component configurations are **activated when their service is requested**.&#x20;

* specifies a service&#x20;
* is not specified to be a factory component&#x20;
* does not have the `immediate` attribute of the component element set to `true`.&#x20;
* If a delayed component **configuration is satisfied**,&#x20;
  * SCR must register the component configuration as a service in the service registry&#x20;
  * but the activation of the component configuration is delayed until the registered service is requested.&#x20;
  * This is achieved by using a `ServiceFactory`

Component description

```xml
<?xml version="1.0" encoding="UTF­8"?>
<component name="example.handler">
    <implementation class="org.helloworld.HelloServiceImpl"/>
    <service>
        <provide interface="org.helloworld.HelloService"/>
    </service>
<component>
```

Component implementation class

```java
public class HelloServiceImpl implements HelloService {
    public void sayHello() {...}
}
```



#### **`Immediate Component`**&#x20;

whose component configurations are **activated immediately upon becoming (dependencies) satisfied**.&#x20;

* not a factory component &#x20;
* either&#x20;
  1. does not specify a service or&#x20;
  2. specifies a service and the `immediate` attribute of the component element set to `true`.&#x20;
* If an immediate component has no dependencies, it is activated immediately.

Component description

<pre class="language-xml"><code class="lang-xml">&#x3C;?xml version="1.0" encoding="UTF­8"?>
&#x3C;component name="example.activator">
<strong>    &#x3C;implementation class="org.sample.HelloComponent"/>
</strong>&#x3C;/component>
</code></pre>

Component implementation class

```java
public class HelloComponent {
    protected void activate(ComponentContext ctxt) {...}
    protected void deactivate(ComponentContext ctxt) {...}
}
```



#### **`Factory Component`**&#x20;

whose component configurations are **created and activated through** the component's **component factory**.



### Accessing Services

#### Event Strategy

Component description.

```xml
<?xml version="1.0" encoding="UTF­8"?>
<component name="helloservice.listen">
    <implementation class="org.sample.HelloComponent”/>
    <reference name="HS"
        interface="org.helloworld.HelloService"
        bind="setHelloService"
        unbind="unsetHelloService” />
</component>
```

Component implementation class.

```java
public class HelloComponent {
    HelloService hs;
    protected void setHelloService(HelloService s) { hs = s; }
    protected void unsetHelloService(HelloService s) { hs = null; }
    protected void activate(ComponentContext ctxt) {...}
    protected void deactivate(ComponentContext ctxt) {...}
}
```

#### Lookup Strategy

Component description.

```xml
<?xml version="1.0" encoding="UTF­8"?>
<component name="helloservice.listen">
    <implementation class="org.sample.HelloComponent”/>
    <reference name="HS"
        interface="org.helloworld.HelloService"/>
</component>
```

Component implementation class.

```java
public class HelloComponent {
    HelloService hs;
    protected void activate(ComponentContext ctxt) {
        hs = (HelloService) cxtx.locateService(“HS”);
    }
    protected void deactivate(ComponentContext ctxt) {...}
}
```



#### References to Services

* cardinality for a referenced service&#x20;
  * 0..1 optional and unary,&#x20;
  * 1..1 mandatory and unary (Default)&#x20;
  * 0..n optional and multiple,
  * 1..n mandatory and multiple.&#x20;
* Reference policy&#x20;
  * static&#x20;
  * dynamic&#x20;
* selecting target services&#x20;
  * By specifying a filter in the `target` property, the set of services that should be part of the target services can be constrained



```xml
<?xml version="1.0" encoding="UTF­8"?>
<component name="helloservice.listen">
    <implementation class="org.sample.HelloComponent"/>
    <reference name="HS"
        interface="org.sample.HelloService"
        cardinality="0..n"
        policy="dynamic"
        target="(language=en)"
        bind="setHelloService"
        unbind="setHelloService" />
</component>
```

