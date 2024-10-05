---
icon: family
---

# Inheritance

> a mechanism for reusing code
>
> **common behaviour -> Super class**
>
> sub classes inherit this common behavior by extending the super class.
>
> Represents a **`IS-A`** relationship.
>
> With inheritance we can achieve **`polymorphic`** behaviour.

When implementing, we don't want to implement **common behaviours** in every single class.&#x20;

╰┈➤ This is where we use **`Inheritance`** to **reuse code.**

&#x20;       Example Use-case:&#x20;

* Framework for building GUI (Graphical User Interface)
  * Can create forms with various types of input fields like text boxes, check boxes, drop down list.
  * All these objects share some common behaviour.
    *   e.g:&#x20;

        * we can enable, disable them
        * can set size in terms of width and height and so on.



We define **common behaviour** in a **`super class`** and have other classes inherit this behaviour from the super class.

<figure><img src="../../.gitbook/assets/java-inheritance.png" alt="" width="326"><figcaption></figcaption></figure>

#### IS-A Relationship:

* Here, every `text box` object **`is a`** `UI control` object.

### `super` Keyword

> **a reference to the base or parent class.**

We can use it to access the members (fields and methods) or call the constructors of the base class.&#x20;



### `this` keyword&#x20;

> **returns a reference to the current object.**



## Example&#x20;

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/87f282efb117be75c54d8dae4798c5efe0725390/oop/src/com/shadhini/java/tryouts/oop/inheritance/Main.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/fb2a27a68469b8ae8fd2fe9fcbffd783a6897869/oop/src/com/shadhini/java/tryouts/oop/inheritance/UIControl.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/fb2a27a68469b8ae8fd2fe9fcbffd783a6897869/oop/src/com/shadhini/java/tryouts/oop/inheritance/TextBox.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/fb2a27a68469b8ae8fd2fe9fcbffd783a6897869/oop/src/com/shadhini/java/tryouts/oop/inheritance/TextBox2.java" %}



## More On ...

<table data-view="cards"><thead><tr><th></th><th data-hidden data-card-target data-type="content-ref"></th></tr></thead><tbody><tr><td><strong>Object Class</strong></td><td><a href="object-class.md">object-class.md</a></td></tr><tr><td><strong>Constructors &#x26; Inheritance</strong></td><td><a href="constructors.md">constructors.md</a></td></tr><tr><td><strong>Overriding Methods</strong></td><td><a href="overriding-methods.md">overriding-methods.md</a></td></tr><tr><td><strong>Upcasting &#x26; Downcasting</strong></td><td><a href="upcasting-and-downcasting.md">upcasting-and-downcasting.md</a></td></tr><tr><td><strong>Polymorphism</strong></td><td><a href="../polymorphism.md">polymorphism.md</a></td></tr><tr><td><strong>Deep Inheritance</strong></td><td><a href="deep-inheritance.md">deep-inheritance.md</a></td></tr><tr><td><strong>Multiple Inheritance</strong></td><td><a href="multiple-inheritance.md">multiple-inheritance.md</a></td></tr></tbody></table>

