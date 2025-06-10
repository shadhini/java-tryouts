---
icon: table-tree
---

# Anatomy of a Java Program

## Function

> **A block of code that performs a task**

e.g: functions for&#x20;

* sending emails to people&#x20;
* converting weight in pounds to kg
* validating user's input

Functions don't exist on their own. Every function should belong to a class.

### Syntax of a Function

<pre class="language-java"><code class="lang-java">&#x3C;ACCESS_MODIFIER> <a data-footnote-ref href="#user-content-fn-1">&#x3C;STATIC></a> &#x3C;<a data-footnote-ref href="#user-content-fn-2">RETURN_TYPE</a>> &#x3C;<a data-footnote-ref href="#user-content-fn-3">NAME</a>>(<a data-footnote-ref href="#user-content-fn-4">&#x3C;PARAMETERS></a>) {
    // actual java code
}
</code></pre>

e.g:

<pre class="language-java"><code class="lang-java">public static void sendEmail(String receiver, String subject, String content) {
    <a data-footnote-ref href="#user-content-fn-5">// Function Implementation</a>
}
</code></pre>

## Class

> **A container for related functions used to organise the code.**

### Syntax of a Class

<pre class="language-java"><code class="lang-java">&#x3C;ACCESS_MODIFIER> class &#x3C;<a data-footnote-ref href="#user-content-fn-6">CLASS_NAME</a>> {
    // implementation
}
</code></pre>

e.g:

```java
package com.shadhini.java.tryouts.oop;

/**
 * TextBox class.
 */
public class TextBox {
    // Implementation
}
```

## Method

> **A function that is part of a class**
>
> **A function that belongs to a class**

Functions defined inside a class belongs to that class. They are referred as `"methods"`.



Methods improves readability/ understandability and code reusability.

* Can reuse code with sending the method different arguments.

## Arguments vs Parameters

`@ the declaration` of the method, we have **`parameters`**.

<pre class="language-java"><code class="lang-java">public static void sendEmail(<a data-footnote-ref href="#user-content-fn-7">String receiver, String subject, String content</a>) {
    // Method Implementation
}
</code></pre>

`@ calling point of method`, we send actual values which are called as **`arguments`**.

<pre class="language-java"><code class="lang-java">sendEmail(<a data-footnote-ref href="#user-content-fn-8">"abc@gmail.com", "Quick Update Request", "Hi Abc, Could you please provide a quick update on Project Y?\nBest, Pqr"</a>)
</code></pre>

### Parameters & Var args

If a method has a parameter with the type `<PARAM_TYPE>...`, it allows you to pass multiple arguments of that type when calling the method.&#x20;

This is known as **`var args`** meaning variable number of arguments.

```java
public class Main {

    public static void main(String[] args) {
        // Call the method with multiple arguments
        printNumbers(1, 2, 3, 4);
    }

    public static void printNumbers(int... numbers) {
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
```

Here, `int... numbers` allows you to pass any number of integers (1, 2, 3, 4), and the method can handle them as an **array** internally.

## main() Method in Main class

> **Entry point for Java programs**

Every Java program should have at least one function. That is `main()` function.

Every Java  program should have at least one Java class that contains the `main()` function named `Main`.

* This is the `entry point` for Java programs
* Whenever a Java program is executed, `main()` method gets called and code inside the function gets executed.

<pre class="language-java"><code class="lang-java">package com.shadhini.java.tryouts.basics;

/**
 * `Main` class and `main` method.
 */
public class Main {
    <a data-footnote-ref href="#user-content-fn-9">public</a> static <a data-footnote-ref href="#user-content-fn-10">void</a> main(String[] args) {
        System.out.println("Hello World!");
    }
}
</code></pre>

* Main method in the program should always be `static`.

## Access Modifiers

All classes & methods should have an `access modifier`.

> A special keyword that determines if other classes and methods in this program can access these classes and methods.

Access Modifiers:

* public
* private
* protected

## Package

> **used to group related classes**
>
> **create namespace for classes**

Classes should be properly organized into packages.

<details>

<summary>❗We can have classes with same name in different packages; they don't conflict. Thus, packages create <code>namespace for classes</code>.</summary>

```
Date     from java.util package
Date     from java.sql package
```

</details>

* To use a class from a package other than the current package from the current class, we need to `import` that other  package first.

### **Base Package**

Base package of a Java project is the domain name of the company in reverse.

e.g:&#x20;

* `org.wso2.am`
* `org.wso2.iam`
* `com.shadhini.java.tryouts.basics`



## Module

> **multiple packages can be combined into a module**



## Annotation

> A **`label`** we attach to a class member; with this we give **extra information** to the `Java Compiler.`

These annotations help Java Compiler to double check our code for **correctness**.

## Structure of a Java Program

<pre class="language-java"><code class="lang-java"><strong>package com.shadhini.java.tryouts.basics;
</strong>
public class Main { // Main class
    public static void main(String[] args) { // main method
        System.out.println("Hello World!");
    }
}
</code></pre>



[^1]: * `static`; if a static method&#x20;
    * nothing otherwise

[^2]: return type; number, DateTime

    e.g:`void` (if don't return anything)

[^3]: use camelNamingConvention

    e.g: sendEmail

[^4]: parameters: used to pass values for the function

    * comma separated list in the format `ReturnType parameterName`

    - parameter names in camelCase

[^5]: commented line; don't get executed

[^6]: use PascalNamingConvention

[^7]: parameters

[^8]: arguments

[^9]: accessible from other parts of the program

[^10]: return type; this method won't return any value
