---
icon: asterisk
---

# Method References

> **enables writing compact, easy to read lambda expressions**
>
> <**CLASS\_OR\_OBJECT\_NAME**>`::`<**METHOD\_NAME**>
>
> * CLASS\_OR\_OBJECT\_NAME: Name of the Class or Object that contains this method&#x20;
> * METHOD\_NAME: Name of the method without parentheses
>
> `With method references, we can reference`` `**`static`**` ``or`` `**`instance`**` ``methods in the class as well as`` `**`constructors`**`.`

Sometimes all we do in a lambda expression is passing parameter/s to an existing method.&#x20;

```java
public interface Printer {
    void print(String message);
}

public class Main {
    public static void main(String[] args) {
        // Here, we are simply passing `message` 
        // to `println` method of this `System.out` object
        greet(message -> System.out.println(message));
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
}
```

Here, we are simply passing `message`  to `println` method of this `System.out` object.

In such cases, it's easier to reference this method directly as follows.

```java
// Syntax
<CLASS_OR_OBJECT_NAME>::<METHOD_NAME>
// CLASS_OR_OBJECT_NAME: Name of the Class or Object that contains this method
// METHOD_NAME: Name of the method without parantheses; 
//     no parantheses since we don't want to call this method, 
//     we just want to add reference to it.
```

```java
public interface Printer {
    void print(String message);
}

public class Main {
    public static void main(String[] args) {
        // Method reference
        greet(System.out::println);
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
}
```

❗With Lambda Expressions, we can pass

* either an anonymous implementation of a functional interface&#x20;
* or instance/static method that matches the method signature of the abstract method in functional interface&#x20;
* or a constructor that has matching parameter arrangement to the abstract method in functional interface

***



## Reference Static Methods

```java
public interface Printer {
    void print(String message);
}

public class LambdasDemo {
    public static void main(String[] args) {
        // Static method reference
        greet(LambdasDemo::print);
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
    
    public static void print(String message) {
        // The signature of this method matches 
        // the signature of method declared in the `Printer` interface
    }
}
```



## Reference Instance Methods

```java
public interface Printer {
    void print(String message);
}

public class LambdasDemo {
    public static void main(String[] args) {
        // Instance method reference
        greet(new LambdasDemo()::print);
        
        var demo = new LambdasDemo();
        greet(demo::print);
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
    
    public void print(String message) {
        // The signature of this method matches 
        // the signature of method declared in the `Printer` interface
    }
}
```



## Reference a Constructor

```java
public interface Printer {
    void print(String message);
}

public class LambdasDemo {
    public LambdasDemo(String message) {
        // The signature of this constructor(except the name) 
        //      matches the signature of `print` method 
        //      declared in the `Printer` interface
    }
    
    public static void main(String[] args) {
        // Constructor reference
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);
        // Above 2 lines are identical
    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }
    
}
```

