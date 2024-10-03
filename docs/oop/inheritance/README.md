---
icon: family
---

# Inheritance

> **common behaviour -> Super class**
>
> sub classes inherit this common behavior by extending the super class.

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



## Example&#x20;

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/129de3806d2d5b830b4799e7f78f26e63aa5f3d2/oop/src/com/shadhini/java/tryouts/oop/inheritance/Main.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/b3377238e1fc8e0574b550f419c55a78369f4fad/oop/src/com/shadhini/java/tryouts/oop/inheritance/UIControl.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/b3377238e1fc8e0574b550f419c55a78369f4fad/oop/src/com/shadhini/java/tryouts/oop/inheritance/TextBox.java" %}

## More On ..

<table data-view="cards"><thead><tr><th></th><th data-hidden data-card-target data-type="content-ref"></th></tr></thead><tbody><tr><td><strong>Object Class</strong></td><td><a href="object-class.md">object-class.md</a></td></tr><tr><td><strong>Constructors &#x26; Inheritance</strong></td><td><a href="constructors.md">constructors.md</a></td></tr></tbody></table>

