---
icon: lambda
---

# Lambda Expressions

> way to represent functions as objects, allowing you to write concise, functional-style code.&#x20;
>
> functional interface can be represented / implemented using a lambda expression.

Lambda Expressions

* Implement functional interface in a `stand-alone function`; a function that exists on its own without belonging to a class.
* Anonymous function that we can pass around.

Introduced with `Java 8`.



Here, we are replacing an anonymous inner class with the lambda expression.

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

Most of the time, we can remove type of parameters and let Java compiler infer them.&#x20;

We can also remove parentheses wrapping parameters, if there's only one parameter.

We use parantheses only, if there's no parameter.



