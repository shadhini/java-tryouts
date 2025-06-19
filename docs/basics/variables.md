---
icon: square-root-variable
---

# Variables

> **Variables:**
>
> * used to temporarily store data in computer's memory
> * have static type
> * use of `var` keyword is recommended

* We always have to initialise variables before reading them.
* We can copy value of a variable to another variable.
* We can only declare variables inside code blocks; i.e. curly braces ( `{ }` ).



## Variable Declaration and Initialisation

<pre class="language-java"><code class="lang-java"><a data-footnote-ref href="#user-content-fn-1">int</a> <a data-footnote-ref href="#user-content-fn-2">age</a> <a data-footnote-ref href="#user-content-fn-3">=</a> <a data-footnote-ref href="#user-content-fn-4">30</a>; // Initializing the variable
</code></pre>

* With this, we are storing number `30` somewhere in computer's memory and we are assigning label `age` to that memory location.



We can initialise multiple variables in the same line. \[`not recommended`]

```java
int ageMom = 59, ageDad = 68;
```



If we don't initialise a variable of `Reference Type`, they are set to **`null`**. i.e. it doesn't reference a real object in memory.

-> `Nulls` are dangerous, they can crash programs with **`java.lang.NullPointerException.`**

&#x20;

## `var` keyword

```java
var textBox1 = new TextBox();
```

When `var` is used, Java compiler will detect the type of this `textBox1` variable based on what we have on the right side of the assignment.

This `var` is different from what we have in languages like JavaScript.&#x20;

* In JavaScript, when we use `var`, we can declare a variable and give it different types of values.
* In Java, variables have a **`static type`**.
  * So, once we set the type of a variable, we cannot change it throughout the lifetime of the programme.

✅  \[available since Java 11] Use **`var`** keyword for cleaner code and let the compiler determine the type of the variable.&#x20;

📌 var can be used only when we are initialising a variable in the same line.

&#x20;



[^1]: variable type

[^2]: name, label, identifier

[^3]: assignment operator

[^4]: initial value that we are assigning to this variable
