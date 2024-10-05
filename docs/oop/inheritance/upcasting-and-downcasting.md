---
icon: up-down
---

# Upcasting & Downcasting



> Java cannot cast more **generic** type to a more **specific** type.
>
> Prevent runtime **ClassCastException** -> check whether the passed object at runtime is a`n instance of the expected Class`.&#x20;

|                    Upcasting                   |                  Downcasting                 |
| :--------------------------------------------: | :------------------------------------------: |
| Casting an object to one of it's `super` types | Casting an object to one of it's `sub` types |



## Upcasting

```java
public class UIControl {
    private boolean isEnabled = true;
    // .....
}

public class TextBox extends UIControl {
    private String text;

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}


public class Main {
    public static void main(String[] args) {
        var textBox = new TextBox();
        show(textBox); // Upcasting
        // Output: null
    }
    
    public static void show(UIControl uiControl) {
        System.out.println(uiControl); // -- A
    }
}
```

Here, @runtime we are sending a `TextBox` object to the `show()` method. Thus, @runtime when line A is executed, the `toString()` method of `TexBox` class is executed.

***

## Downcasting

However inside `show()` method, @compile time we cannot access members of the `TextBox` class, since the parameter it accept is of `UIControl` type. Here, we need to explicitly cast `uiControl` to `TextBox`, to access members of the `TextBox` object as follows.

```java
public class Main {
    public static void main(String[] args) {
        var textBox = new TextBox();
        show(textBox); // Upcasting
    }
    
    public static void show(UIControl uiControl) {
        System.out.println(uiControl); // Output: null
        TextBox textBox = (TextBox) uiControl; // Downcasting
        textBox.setText("Happy Downcasting..."); 
        System.out.println(textBox); // Output: Happy Upcasting...
    }
}
```

***

## java.lang.ClassCastException while Downcasting

However, attempt to **downcast** original `UIControl` object to `TextBox` object in `show()` method gives **`java.lang.ClassCastException`** @ **runtime**.&#x20;

* Every `TextBox` object **is a** `UIControl`. But every `UIControl` is not necessarily a `TextBox` object. It could be a `DropDownList`.
* `Java cannot cast more generic type to a more specific type`.

This doesn't raise compile time error as `show()` method expects a `UIControl` object as parameter and as downcasting happens inside the method.

```java
public class Main {
    public static void main(String[] args) {
        var control = new UIControl();
        show(control); 
    }
    
    public static void show(UIControl uiControl) {
        System.out.println(uiControl); // Output: com.shadhini.java.tryouts.oop.inheritance.UIControl@35bbe5e8
        TextBox textBox = (TextBox) uiControl; // --> java.lang.ClassCastException
        textBox.setText("Happy Downcasting..."); 
        System.out.println(textBox); 
    }
}
```

***

## Prevent runtime ClassCastException

Use of **`instanceof`** to verify that the object passed at runtime is an instance of the class to which it will be downcasted to.

```java
public class Main {
    public static void main(String[] args) {
        var control = new UIControl();
        show(control); 
    }
    
    public static void show2(UIControl uiControl) {
        System.out.println(uiControl);
        if (uiControl instanceof TextBox) { // ClassCastException Prevention
            TextBox2 textBox = (TextBox2) uiControl;
            textBox.setText("Happy Downcasting...");
            System.out.println(textBox);
        }
    }
}
```

### **`instanceof` Operator**

> **tells us if an object is an instance of a class.**

We use it before casting an object to a different type to make sure we don’t get a casting exception.



