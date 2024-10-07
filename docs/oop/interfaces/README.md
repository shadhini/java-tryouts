---
icon: browsers
---

# Interfaces

> Similar to classes, but it **`only includes method declarations`** (without implementation - no code - no fields).
>
> ╰┈➤ **`Only defines the capabilities that a class should have.`**
>
> * When we need the `flexibility to swap` how something is done -> We can use interfaces
> * Used to implement **`loosely-coupled`,** **`extensible`,** **`testable`** applications.
> * Cannot instantiate methods.
>
>
>
> Interface: `~`**`A public contract ~`**
>
> Class: `~`**`A concrete implementation ~`**
>
> &#x20;
>
> **A class can `extend` one class and `implement` one or more interfaces.**
>
> **Unlike classes, interface can have `multiple parents`.**

We use interfaces to build&#x20;

1. **`loosely-coupled`**; replace parts with minimal or 0 impact to application
2. **`extensible`**; extend easily with minimal or 0 impact to application
3. **`testable`**; test parts of the program independently -> unit testing

applications.

<pre class="language-java"><code class="lang-java">// Interface
public interface <a data-footnote-ref href="#user-content-fn-1">Draggable</a> {
    void drag(); // method declaration
    // No need to add public access modifier in method declarations
    // Bcz subclasses must access and implement this method, 
    // Thus, anyway these must be public methods
}

public class A extends B implements Draggable, Serializable {
    @Override
    void drag() {
        // implementation
    }
}
</code></pre>

<div align="left">

<figure><img src="../../.gitbook/assets/java-interfaces-decouple (1).png" alt="" width="375"><figcaption></figcaption></figure>

</div>

|                               Interface                               |   Classes (that implement the Interface)  |
| :-------------------------------------------------------------------: | :---------------------------------------: |
|              Gives the idea **`What`**` ``should be done`             | Determine **`How`**` ``it should be done` |
| <p>E.g:<br>Data Compression<br>Encryption<br>Sorting<br>Searching</p> |                                           |



### Coupling

We need to keep relationships between classes as loose as possible and reduce cascading breaking changes.

### Options to Reduce Coupling

* Abstraction: hide the implementation details
* Interfaces: By introducing an interface between classes, we can completely decouple 2 classes to the level where they don't even know about each others existence. With this, a class won't be affected by the changes of the other class.

### Analogy - Loose Coupling with Interfaces

Say there's a restaurant and a chef. You don't care who the chef is as long as they have certain capabilities.

If something happens to the chef; if he/she doesn't come to work, you can replace them with someone else who has same capabilities.



### Programming Against Interfaces

> We code our classes to work with interfaces, not concrete implementations.

Here, we don't want  class A to be directly dependent; coupled to class B. Because with this, if we change B, A might be affected.&#x20;

To `minimize the impact of changes` we can put interface in between these 2 classes and decouple them.

<figure><img src="../../.gitbook/assets/java-interfaces-decouple.png" alt="" width="563"><figcaption></figcaption></figure>

* Now if you change code in B, A won't be affected as A knows nothing about B.
* Tomorrow, we can easily replace B with a class (C) that implements this interface.
* As long as both our classes B and C follows our `contract/interface` everything will continue to work.

➜ This makes our code loosely coupled and extensive.

### Analogy - Interfaces

Your phone has an input port for the charger. This input defines our interface. &#x20;

* We can use any charger that follows this input/contract. As long as size fits, you can use it to charge your phone.&#x20;
* If one charger is slow or faulty, you can replace it with another charger.

### Use of Interfaces in Applications&#x20;

#### Searching Data

Today you will be using one algorithm for searching, and tomorrow you might want to use different algorithm which is faster and more accurate.

* Define an interface that says you should be able to search data.
* Then we create different classes that implement that interface / contract.
  * Each class will use a different algorithm for searching data&#x20;

#### Calculating Taxes

Each year tax rules might change. But every year you need to be able to calculate the tax

* Interface: specifies what should be done; which is calculating tax
* Different classes: provide different ways of calculating the tax
* Each year we can swap one implementation with another.



### Naming Convention

In C# we prefixes interfaces with capital `I` to indicate that it is an interface. But this convention is not popular in Java.&#x20;

In Java,

* we sometimes use `Can` prefix.
  * e.g: CanCalculateTax
* use `able` postfix
  * e.g: Draggable, Resizable



### Interfaces and Multiple Inheritance&#x20;

> Unlike classes, interface can have **`multiple parents`.**

* This won't bring problems with multiple inheritance as in classes.
  * Because if multiple parents have declared the same method with same method signature, the child class will inherit only one of them since there are no implmentations to choose between.

### Best Practice

✅ Add `@Override` annotation for methods inherited from the implemented interface/s.



{% content-ref url="dependency-injection/" %}
[dependency-injection](dependency-injection/)
{% endcontent-ref %}

{% content-ref url="interface-segregation-principle.md" %}
[interface-segregation-principle.md](interface-segregation-principle.md)
{% endcontent-ref %}

{% content-ref url="fields-in-interfaces.md" %}
[fields-in-interfaces.md](fields-in-interfaces.md)
{% endcontent-ref %}

{% content-ref url="new-features-introduced-to-interfaces.md" %}
[new-features-introduced-to-interfaces.md](new-features-introduced-to-interfaces.md)
{% endcontent-ref %}

{% content-ref url="when-to-use-interfaces.md" %}
[when-to-use-interfaces.md](when-to-use-interfaces.md)
{% endcontent-ref %}





[^1]: Interface Name: PascalCase
