---
icon: lambda
---

# Lambda Expressions

## Lambda Expressions

> way to represent functions as **`objects`**, allowing you to write concise, functional-style code.&#x20;
>
> a functional interface can be represented / implemented using a lambda expression.

Lambda Expressions

* Implement functional interface in a `stand-alone function`; a function that exists on its own without belonging to a class.
* Anonymous function that we can pass around.

Introduced with `Java 8`.



## Passing a lambda expression as an argument to a method

Here, we are replacing an anonymous inner class with a lambda expression.

```java
// A Functional Interface 
public interface Printer {
    void print(String message);
}

public class Main {
    public static void main(String[] args) {
        // Here, we are passing a lambda expression as the method argument.
        greet(message -> System.out.println(message));
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
}
```



### Lambda Expression Syntax Variations

```java
greet((String message) -> { // Lambda Expression
    System.out.println(message);
});
```

Most of the time, we can remove type of parameters and let Java compiler infer them.&#x20;

```java
greet((message) -> { // Lambda Expression without parameter types
    System.out.println(message);
});
```

We can also remove parentheses wrapping parameters, if there's only one parameter.

```java
greet( message -> { // Lambda Expression without parenthesis
    System.out.println(message);
});
```

We use parentheses only, if there's no parameter or if there are multiple parameters.

```java
greet(() -> { // Lambda Expression with parenthesis 
// in case the abstract method of the functional interface has no parameters
    System.out.println("Hello!");
});
```

```java
greet((a, b) -> { // Lambda Expression with parenthesis 
// in case the abstract method of the functional interface has multiple parameters
    System.out.println(a+b);
});
```

If the function has only single line of code, then we don't need curly braces to wrap the code too.

```java
// Lambda Expression with single line of code 
greet(message -> System.out.println(message)); 
```



## Store lambda expression in a variable

```java
// A Functional Interface 
public interface Printer {
    void print(String message);
}

public class Main {
    public static void main(String[] args) {
        // EITHER
        // set variable to a concrete implementation
        Printer printer = new ConsolePrinter();
        // OR
        // set variable to a lambda expression
        Printer printer2 = message -> System.out.println(message);
        
        greet(printer2);

    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
}
```



