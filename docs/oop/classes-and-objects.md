---
icon: map
---

# Classes & Objects

## Classes & Objects

> **`Class`** define **template** or **blueprint** for creating new objects; new instances.
>
> **`Object`** is an **instance** of a class.

<figure><img src="../.gitbook/assets/java-class_n_objects2.png" alt="" width="271"><figcaption></figcaption></figure>



<figure><img src="../.gitbook/assets/java-car.png" alt=""><figcaption></figcaption></figure>

**Methods change the state of an object.**

&#x20;   e.g:

* if `changeGear()` method is called, the value of the `currentGear` field changes.
* So, methods change the values of the fields.

Using this `Car` **template (i.e. class), we can create car objects;** `car1`, `car2`, `car3`.

* All these car objects will have the same fields and methods.
* But they are **independent of each other**.
* Each car object will be in separate space in memory, and it can be in a separate state; i.e. data in each car object can be different.



These classes/objects have members we can access using dot operator.

<figure><img src="../.gitbook/assets/java-uml-classes.png" alt=""><figcaption></figcaption></figure>

## `this` keyword

In a situation where a name of a (method) parameter is same as the name of (class) field, we can use the **`this`** keyword for clarity.

╰┈➤ a reference to the current object.

**`this.`** &#x20;

* shows declared members of the current class&#x20;
* also it shows some other members that comes through inheritance

{% hint style="success" %}
Every class we declare in Java, automatically inherits some members from **`Object`** class.
{% endhint %}

<div align="left"><figure><img src="../.gitbook/assets/java-this-keyword.png" alt="" width="563"><figcaption></figcaption></figure></div>

## Fields / Attributes

> **Fields / Attributes:**&#x20;
>
> **— Variables declared directly in a class at class level —**&#x20;

{% hint style="info" %}
* **`Variables`** is a generic term that refers to **named storage location in memory** that holds a value.
* And variables can be declared inside methods, constructor, blocks or classes.
{% endhint %}

❗In Java we should **not** declare fields as **public**.

* How we store data in an object is considered an implementation detail.&#x20;
* We may change how we store the data internally.&#x20;
* Plus, we don’t want our objects to go into a bad state (hold bad data).&#x20;
* That’s why we should declare fields as private and provide getters and or setters only if required.&#x20;
* These setters can ensure our objects don’t go into a bad state by validating the values that are passed to them.

## Declaring & Instantiating Classes

**`Instantiating Class`** -> creating an instance of a class with `new` operator

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/classes_n_objects/ClassesNObjects.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/classes_n_objects/TextBox.java" %}



