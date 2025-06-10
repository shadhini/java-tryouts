---
icon: syringe
---

# Dependency Injection

> **passing or injecting dependencies of a class**
>
> * Our Classes should not instantiate their dependencies.
> * That responsibility should be delegated to another class.

Dependency Injection says that

* One class should not worry about creating an object of another class. It should only use it.
* Creating an object from another class and using it are 2 different concerns and we need to separate them. ➜ **`Separation of Concerns`**
* Thus, the responsibility of creating an object should be delegated to another class. That class should provide this class with the object it requires.
* So, that class will pass or inject a dependency to this class. ➜ **`Dependancy Injection`**

```java
public class TaxReport {

    private TaxCalculator calculator; 

    public TaxReport() {
        calculator =  new TaxCalculator(100_000); // Dependency Injection required ...
    }

    public void show() {
        var tax = calculator.calculateTax(); 
        System.out.println(tax);
    }
}
```



### Analogy&#x20;

In a restaurant each person has a separate role.&#x20;

* We don't want chef to come and take orders.
* We want these concerns to be separated and everyone to focus on what they are responsible for.

## Ways of Dependency Injection

Even with dependency injection, there will be coupling. A class will depend on an interface.&#x20;

* But that's far less coupling than being dependent on a class as an interface has no implementation.
* Even if a concrete implementation of the interface/contract changes the class that uses would not be affected.
* However if we modify the contract/interface, then the classes that depend on this contract will be broken.
* So we should be careful when creating interfaces.

✅ Interfaces should be small and lightweight so that they are less likely to change.

{% content-ref url="constructor-injection.md" %}
[constructor-injection.md](constructor-injection.md)
{% endcontent-ref %}

{% content-ref url="setter-injection.md" %}
[setter-injection.md](setter-injection.md)
{% endcontent-ref %}

{% content-ref url="method-injection.md" %}
[method-injection.md](method-injection.md)
{% endcontent-ref %}



## Poor Man's Dependency Injection

* Creating instances in a one class (say Main class) and passing them to necessary constructors, setters and methods is called Poor Man's Dependency Injection.
* This is not maintainable in large applications as we can't keep creating instances in a Main class. for 1000 of classes with dependencies.

╰┈➤ We can use **`dependency injection framework`**

&#x20;            e.g: `Spring`&#x20;
