---
icon: delete-left
---

# Overriding Methods

## Overriding Methods

> **Changing the implementation of an inherited method in a subclass.**

Used in situations where we inherit methods from super/parent class/es, but we are not happy with that implementation and we want to change the behaviour of inherited methods from super/parent classes at **`runtime`**.

We can override any method inherited from parent/grand parent ... classes.

`Method overloading` -> declaring a method multiple times with different method signatures/ different parameters

```java
public class UIControl {
    private boolean isEnabled = true;
    // .....
}

public class TextBox extends UIControl {
    private String text;

    public void setText(String text) {
        this.text = text;
    }
}

public class TextBox2 extends UIControl {
    private String text;

    @Override // Annotation: With this we are telling the Java compiler that
    // we are overriding toString() method declared in the Object class.
    // With this annotation Java Compiler will make sure that this method has the exact same signature as the inherited method.
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
        textBox.setText("----Text of TextBox class.----");
        // Method inherited from Object class
        System.out.println(textBox.toString()); // Output: com.shadhini.tryouts.java.oop.inheritance.TextBox@7d417077
        System.out.println(textBox); // Output: com.shadhini.tryouts.java.oop.inheritance.TextBox@7d417077
        
        var textBox2 = new TextBox2();
        textBox2.setText("----Text of TextBox2 class.----");
        // Method inherited from Object class is overridden by method declaration at TextBox2 class
        System.out.println(textBox2.toString()); // Output: ----Text of TextBox2 class.----
        System.out.println(textBox2); // Output: ----Text of TextBox2 class.----
    }
}
```

With **`@Override`** annotation `Java Compiler` will make sure that this method has the exact same signature as the inherited method.

* Also, if we remove this method from the base class, the compiler will let us know and we can remove the method in the subclass as well.

➡ These annotations help Java Compiler to double check our code for correctness.



