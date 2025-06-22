---
icon: up-down
---

# Upcasting & Downcasting

## Upcasting & Downcasting

> Java cannot cast more **generic** type to a more **specific** type.
>
> Prevent runtime **ClassCastException** -> check whether the passed object at runtime is `an instance of the expected Class`.&#x20;

|                    Upcasting                   |                  Downcasting                 |
| :--------------------------------------------: | :------------------------------------------: |
| Casting an object to one of it's `super` types | Casting an object to one of it's `sub` types |

```java
public class UIControl {
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
```

### **Upcasting**

Here, @runtime we are sending a `TextBox` object to the `show()` method. Thus, @runtime when line A is executed, the `toString()` method of `TextBox` class is executed.

<pre class="language-java"><code class="lang-java"><strong>public class CastingDemo {
</strong>
    public static void main(String[] args) {
        var textBox = new TextBox();
        textBox.setText("Initial Text");

        // Upcasting
        // =============================================================================================================
        show(textBox); // Upcasting happens here
        /* Output:
        Initial Text
         */
    }

    public static void show(UIControl uiControl) {
        System.out.println(uiControl); // --- A 
        // Output: Initial Text
    }
    
}
</code></pre>

#### **Downcasting**

However, inside `show2()` method, @compile time we cannot access members of the `TextBox` class, since the parameter it accept is of `UIControl` type. Here, we need to explicitly cast `uiControl` to `TextBox`, to access members of the `TextBox` object as follows.

<pre class="language-java"><code class="lang-java"><strong>public class CastingDemo {
</strong>
    public static void main(String[] args) {
        var textBox = new TextBox();
        textBox.setText("Initial Text");

        // Downcasting
        // =============================================================================================================
        show2(textBox);
        /* Output:
        Initial Text
        Happy Downcasting...
         */
    }

    public static void show2(UIControl uiControl) {
        System.out.println(uiControl);
        // @compile time we cannot access members of the TextBox class, without downcasting.
        TextBox textBox = (TextBox) uiControl; // Downcasting happens here
        textBox.setText("Happy Downcasting...");
        System.out.println(textBox);
    }
    
}
</code></pre>

#### java.lang.ClassCastException while Downcasting

However, attempt to **downcast** original `UIControl` object to `TextBox` object in `show2()` method gives **`java.lang.ClassCastException`** @ **runtime**.&#x20;

* Every `TextBox` object **is a** `UIControl`. But every `UIControl` is not necessarily a `TextBox` object. It could be a `DropDownList`.
* `Java cannot cast more generic type to a more specific type`.

This doesn't raise compile time error as `show2()` method expects a `UIControl` object as parameter and as downcasting happens inside the method.

<pre class="language-java"><code class="lang-java"><strong>public class CastingDemo {
</strong>
    public static void main(String[] args) {
        var uiControl = new UIControl();

        // java.lang.ClassCastException while Downcasting
        // =============================================================================================================
        show2(uiControl);
        /* Output:
        com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting.UIControl@75bd9
        --> java.lang.ClassCastException
         */

    }

    public static void show2(UIControl uiControl) {
        System.out.println(uiControl); // Output: com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting.UIControl@75bd9
        TextBox textBox = (TextBox) uiControl; // --> java.lang.ClassCastException
        
        textBox.setText("Happy Downcasting...");
        System.out.println(textBox);
    }
    
}
</code></pre>

#### Prevent runtime ClassCastException

Use of **`instanceof`** to verify that the object passed at runtime is an instance of the class to which it will be downcasted to.

<pre class="language-java"><code class="lang-java"><strong>public class CastingDemo {
</strong>
    public static void main(String[] args) {
        var uiControl = new UIControl();

        // Prevent runtime ClassCastException
        // =============================================================================================================
        show3(uiControl);
        /* Output:
        com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting.UIControl@75bd9247
         */

    }

    public static void show3(UIControl uiControl) {
        System.out.println(uiControl); // Output: com.shadhini.tryouts.java.oop.inheritance.upcasting_n_downcasting.UIControl@75bd9247
        if (uiControl instanceof TextBox) { // ClassCastException Prevention
            TextBox textBox = (TextBox) uiControl;
            textBox.setText("Happy Downcasting...");
            System.out.println(textBox);
        }
    }
    
}
</code></pre>



### **`instanceof` Operator**

> **tells us if an object is an instance of a class.**

We use it before casting an object to a different type to make sure we don’t get a casting exception.



