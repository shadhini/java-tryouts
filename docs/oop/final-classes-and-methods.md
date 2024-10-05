---
icon: f
---

# Final Classes and Methods

> **`Final Classes`**
>
> * cannot extend
> * can create instances
>
> **`Final Methods`**
>
> * cannot override



## Final Classes

\[`used rarely`]

* cannot extend
* can create instances

Used in situations where we are 100% sure about the implementation of the class and we want to **prevent** other classes from **extending** that class.

Used when an implementation is so specific and we have made so **many assumptions** specially about changing the state of the class.

e.g:&#x20;

* `java.lang.String` class
  * Strings in Java are immutable; once we initialise a string, we cannot change its' content.
  * Implementers of the java.lang.String class have made sure that whenever we call a method in String class, it returns a new instance.
  * And they have made String class a final class as they don't want whoever extending String class to  break that assumption.

```java
public final class CheckBox extends UIControl { // Final class

    @Override
    public void render() {
        System.out.println("CheckBox rendered.");
    }
}
```

## Final Methods

* cannot override

Used in situations where we have made assumptions, changing the state of the class in a particular way. And we don't want subclasses to accidentally change this behaviour or break our assumptions.

```java
public class UIControl { 

    private boolean isEnabled = true;

    public final void enable() { // Final Method
        isEnabled = true;
    }
}
```



