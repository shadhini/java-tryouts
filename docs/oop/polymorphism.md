---
icon: people-roof
---

# Polymorphism

## Polymorphism

> **allows an object to take many forms and behave differently.**
>
> -> helps to build extensible applications

```
Poly    -    morph    -    ism 
many    -    form     ----------------> Many forms
```



Polymorphism allows us&#x20;

* to store different types of UI control objects (e.g., TextBox, CheckBox) in a single array and&#x20;
* render them without using if-else clauses for each control type.&#x20;
  * This is achieved by defining a **common render method in the superclass** and providing **specific implementations in the subclasses**, which are executed at runtime through method overriding.
  * Then every sub class will have their own render() method with that class specific implementation.
  * ╰┈➤ `This is Encapsulation`; binding the object and operations on it together as a single unit

You can assign an instance of a particular class or any of it's derivatives to a variable of that particular type.

```java
public class Instructor extends User {
    // ...
}

public class Main {
    public static void main(String[] args) {
        User user = new Instructor();
    }
}
```



## Example

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/polymorphism/UIControl.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/polymorphism/TextBox.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/polymorphism/CheckBox.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/polymorphism/Polymorphism.java" %}



