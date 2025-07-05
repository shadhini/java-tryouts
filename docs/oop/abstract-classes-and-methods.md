---
icon: a
---

# Abstract Classes and Methods

> **`Abstract Classes:`** a partially-implemented (half-cooked) class
>
> * can only be extended
> * cannot be instantiated
>
> **`Abstract Methods`**
>
> * no method body
> * all subclasses should implement the method
> * declared in abstract classes

## Abstract Classes

Used in situations where we declare a class, but we **`don't wanna`** be able to **`instantiate`** it; i.e create new instances of that class.

```java
public abstract class UIControl { // Abstract Class

    public void render() {
        // Default implementation is empty
        // since how to render each type of UI control (e.g: TextBox, CheckBox) is different from each other.
    }
}
```

* cannot instantiate
* can be extended by other classes; can be use to share some common code across subclasses



## Abstract Methods

```java
public abstract class UIControl {

    public abstract void render(); // Abstract method; only method declaration is available
}
```

When method is declared as abstract, it forces any of the subclasses derived from that class to implement this method.

❗ An abstract class does not need abstract methods. But if we mark a method as abstract, we should mark the class as abstract as well.



## Example

Here UIControl is an **abstract** concept.&#x20;

* We can't add an implementation to the render method in UIControl since it's an abstract thing.&#x20;
* The whole purpose of the UIControl class is to provide some common behaviour for subclasses like TextBoxes CheckBoxes.
* In such scenarios we can declare the UIControl class as an **`abstract`** class and then we no longer will be able to instantiate it.

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/abstract_final_classes_n_methods/UIControl.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/abstract_final_classes_n_methods/TextBox.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/abstract_final_classes_n_methods/CheckBox.java" %}

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-oop/src/com/shadhini/tryouts/java/oop/abstract_final_classes_n_methods/AbstractFinalClassesAndMethods.java" %}



