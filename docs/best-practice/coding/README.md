---
icon: square-code
---

# Coding

* Programming is driven by the basic rule **`"Don't repeat yourself".`**
* Programming and problem solving is **`all about trade offs`**.
* **`Don't overuse method overloading`**.&#x20;
  * Should not use it, if the gain of method overloading is tiny.
  * But it's necessary if the method parameters are of different types.



## Access Modifiers

✅  Only use **`public`** & **`private`** access modifiers.



## Downcasting

✅  Use **`instanceof`** to check whether the object passed in the runtime is actually an instance of the class to which it will be downcasted, to avoid `java.lang.ClassCastException` at runtime.



## Overriding Methods

✅  Whenever we override `equals()` method of `Object` class we should also override the `hashCode()` method of `Object` class.

✅ Add `@Override` annotation for methods inherited from the implemented interface/s.



## Inheritance

❗ Inheritance is good up to **`1, and 2 levels.`** Not more than 3 levels.





## Method Overloading

❌  Overloading a method too many times is ugly.&#x20;

❗ If the gain of method overloading is tiny, then better to not go for it.

╰┈➤  `Don't over use method overloading.`&#x20;

✅  Overloading is necessary if you are dealing with completely different types of parameters.





***

{% content-ref url="classes.md" %}
[classes.md](classes.md)
{% endcontent-ref %}

{% content-ref url="methods.md" %}
[methods.md](methods.md)
{% endcontent-ref %}

{% content-ref url="interfaces.md" %}
[interfaces.md](interfaces.md)
{% endcontent-ref %}

{% content-ref url="variables.md" %}
[variables.md](variables.md)
{% endcontent-ref %}

{% content-ref url="data-validation.md" %}
[data-validation.md](data-validation.md)
{% endcontent-ref %}

{% content-ref url="numbers.md" %}
[numbers.md](numbers.md)
{% endcontent-ref %}

{% content-ref url="if-statements.md" %}
[if-statements.md](if-statements.md)
{% endcontent-ref %}

{% content-ref url="loops.md" %}
[loops.md](loops.md)
{% endcontent-ref %}

{% content-ref url="exception-handling.md" %}
[exception-handling.md](exception-handling.md)
{% endcontent-ref %}

{% content-ref url="os-resources.md" %}
[os-resources.md](os-resources.md)
{% endcontent-ref %}

{% content-ref url="functional-interfaces.md" %}
[functional-interfaces.md](functional-interfaces.md)
{% endcontent-ref %}





