---
icon: square-root-variable
---

# Variable Capture

A lambda expression can access&#x20;

* variables in the enclosing method.
* static fields in the enclosing class.
* instance fields in the enclosing class.

```java
// A Functional Interface 
public interface Printer {
    void print(String message);
}

public class Main {
    private static String POSTFIX = "**";
    private String POSTFIX2 = "**2";
    
    public static void main(String[] args) {
        String prefix = "-";
        greet(message -> System.out.println(prefix + message + POSTFIX));
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
    
    public void show() {
        greet(message -> System.out.println(message + POSTFIX2));
    }
}
```



### `this` keyword&#x20;

`this` keyword in lambda expression references the enclosing object&#x20;

* whereas in anonymous inner classes `this` keyword reference the current instance of the anonymous inner class.
* i.e. in above example, from the main method we can access `show()` method and `POSTFIX2` non-static field with the this keyword.

{% content-ref url="anonymous-inner-classes-vs-lambda-expressions.md" %}
[anonymous-inner-classes-vs-lambda-expressions.md](anonymous-inner-classes-vs-lambda-expressions.md)
{% endcontent-ref %}



