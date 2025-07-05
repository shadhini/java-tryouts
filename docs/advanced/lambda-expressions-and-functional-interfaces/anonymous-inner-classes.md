---
icon: user-ninja
---

# Anonymous Inner Classes

## Anonymous Inner Classes

> Sometimes we don't wanna explicitly create a class to implement an interface.&#x20;
>
> * Perhaps you want to implement an interface only once and use it for a single purpose and you may not want to reuse that class.
>
> ╰┈➤ Then we use **`Anonymous Inner Classes`**&#x20;



These classes doesn't have a name -> Anonymous

* It's just an implementation

We are using these inside a method -> Inner Class



With Anonymous Inner Classes, we can achieve the same result by writing less code.

```java
// A Functional Interface 
public interface Printer {
    void print(String message);
}

public class Main {
    public static void main(String[] args) {
        greet(new Printer() { // Anonymous Inner Class
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
}
```



### **`this` keyword**

In anonymous inner classes `this` keyword reference the current instance of the anonymous inner class.



### Better Approach

Java 8 introduced a better more concise way to achieve the same result

╰┈➤ That's called **`Lambda Expressions`**





