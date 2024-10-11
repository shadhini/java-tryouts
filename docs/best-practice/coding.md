---
icon: square-code
---

# Coding

* Programming is driven by the basic rule **`"Don't repeat yourself".`**
* Programming and problem solving is **`all about trade offs`**.
* **`Don't overuse method overloading`**.&#x20;
  * Should not use it, if the gain of method overloading is tiny.
  * But it's necessary if the method parameters are of different types.



## Variable

### Variable Naming

❗Avoid `magic numbers` in code; Always use constants (i.e. `final variables`) to describe them.

<details>

<summary>❌ </summary>

<pre class="language-java"><code class="lang-java">public class MortgageCalculator {

    // Some Code ...

    public static double calculateMortgage(int principal, float annualInterestRate, byte period) {
        float monthlyInterestRate = annualInterestRate / <a data-footnote-ref href="#user-content-fn-1">100</a> / <a data-footnote-ref href="#user-content-fn-2">12</a>;
        short numOfPayments = (short) (period * <a data-footnote-ref href="#user-content-fn-3">12</a>);

        double intermediateCalc = Math.pow(1  + monthlyInterestRate, numOfPayments);
        return  (principal * monthlyInterestRate * intermediateCalc) / (intermediateCalc - 1);
    }
}
</code></pre>

</details>

<details>

<summary>✅️</summary>

<pre class="language-java"><code class="lang-java">public class MortgageCalculator {

    final static byte <a data-footnote-ref href="#user-content-fn-4">MONTHS_IN_YEAR</a> = 12;
    final static byte <a data-footnote-ref href="#user-content-fn-5">PERCENT</a> = 100;

    // Some Code ...

    public static double calculateMortgage(int principal, float annualInterestRate, byte period) {
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        short numOfPayments = (short) (period * MONTHS_IN_YEAR);

        double intermediateCalc = Math.pow(1  + monthlyInterestRate, numOfPayments);
        return  (principal * monthlyInterestRate * intermediateCalc) / (intermediateCalc - 1);
    }
}
</code></pre>

</details>



### Variable Declaration

❌ Initialising multiple variables in the same line can make your program hard to read. Thus, it is not recommended.

<details>

<summary>❌ </summary>

```java
int temperature = 30, precipitation = 20;
```

</details>

<details>

<summary>✅️</summary>

```java
int temperature = 30;
int precipitation = 20;
```

</details>



✅  \[available since Java 11] Use **`var`** keyword for cleaner code and let the compiler determine the type of the variable.&#x20;

<details>

<summary>❌ </summary>

```java
TextBox textBox1 = new TextBox();
```

</details>

<details>

<summary>✅  </summary>

```java
var textBox1 = new TextBox();
```

</details>



### Variable Initialisation

✅️ Make sure variables are initialised.&#x20;

* If we don't initialise a variable of `Reference Type`, they are set to **`null`**. i.e. it doesn't reference a real object in memory.
* ❗ `Nulls` are dangerous, they can crash programs with **`java.lang.NullPointerException.`**

✅️  Variables should be initialised before accessing them.



## Numbers

✅️ Use `_` to separate every 3 digits of large numbers.

✅️ Use `L` as a suffix to a number to denote it as a `long`.

✅️ Use `F` as a suffix to a number to denote it as a `float`.



## If Statements

{% content-ref url="https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/basics/control-flow/if-statements/simplifying-if-statements" %}
[Simplifying If Statements](https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/basics/control-flow/if-statements/simplifying-if-statements)
{% endcontent-ref %}

{% content-ref url="https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/basics/control-flow/ternary-operator" %}
[Ternary Operator](https://app.gitbook.com/s/iwMVoASPXjxvpeNiNKj4/basics/control-flow/ternary-operator)
{% endcontent-ref %}



***

✅️  When there are multiple conditions, we should have most specific conditions on top, and most generic ones at the bottom.

e.g: FizzBuzz readable version

```java
if (number % 5 == 0 && number % 3 == 0) // the most specific conditions comes to top
    System.out.println("FizzBuzz");
else if (number % 5 == 0)
    System.out.println("Fizz");
else if (number % 3 == 0)
    System.out.println("Buzz");
else
    System.out.println(number); // the most generic conditions goes to bottom
```



❗The more you `nest the if else statements`, the more **`complicated`** and confusing your code is going to be to other people.



## Loops

✅️  In situations where you know in ahead of time that how many times you have to execute set of statements&#x20;

**``╰┈➤ use `for` loop``**

✅️  In situations where you don't know exactly how many times you want to repeat something

**``╰┈➤ use `while` loop``**

* e.g: run a program till user enter `quit`.

✅️  In situations where you don't know exactly how many times you want to repeat something, but you want the loop body to execute at least once

**``╰┈➤ use `do... while` loop``**

✅️  In situations where you simply want to iterate over array of items and don't need the access to idex of each item&#x20;

**``╰┈➤ use `for each` loop``**

***



❌ Don't create unnecessary objects inside loops.

* Unless that object need to be created in every iteration, declare and create it outside the loop and reuse it inside the loop.

❗**`while (true)`** loops must have a `break` statement

* They are dangerous in terms of memory consumption, if break condition is not met. => infinite loop





## Classes

✅  ✨ A class should have only a single responsibility.

✅️  Extract repetitive patterns and highly related statements into methods and classes.

✅ Keep everything that's not needed outside as private members.



✅  ✨

> **private fields**/data members&#x20;
>
> **public setter** methods with field **data validation** logic to set values for these fields&#x20;
>
> **public getters**; if it is necessary to access the data field values



### Organization of the Class Declaration

1. Fields
2. Constructors
3. Public Methods
4. Getters and Setters

### Methods

✅ Logically related methods should be defined next to each other for better organisation of code.

✅  ✨ Less methods in class & Private methods -> Hide implementation -> Reduce Coupling -> Reduce impact of changes

❗ Frequently changing values should be method parameters instead of class's fields.

✅ Move all the getters and setters to the bottom of the class.



✅ Add `@Override` annotation for methods inherited from the implemented interface/s.

#### Parameters

❗ Frequently changing values should be method parameters instead of class's fields.



### Fields & Constructors

❗In Java we should **not** declare fields as **public**. They should be **private**.

✅ Define repeated constants on methods @ class level as final variables. Make them final static if variables belong to the class.

✅ Interface of a class should be as simple as possible. You should reduce the **`guess work`**.

✅️ Make sure fields of a class are initialised in the **`constructors`**.

* ❌ We don't initialise values in a class as it is only a blueprint.&#x20;
* ✅️  Instead, when later objects are created, field values should be set for each object.
* ✅ Setters can be called inside the constructor to put an object created on a valid state from the beginning.
* ❌ An object shouldn't go to an `invalid state` after creation.
* If we don't initialise a variable of `Reference Type`, they are set to **`null`**. i.e. it doesn't reference a real object in memory.
* ❗ `Nulls` are dangerous, they can crash programs with **`java.lang.NullPointerException.`**

❗ Frequently changing values should be method parameters instead of class's fields.



## Methods



✅️  You need to break down your code into small methods and improve code readability and reusability.

✅️  Ideally methods should be between 5-10 lines of code. Not more than 20 lines of code.

✅️  Extract repetitive patterns and highly related statements into methods and classes.



### Utility Methods

✅️  Utility methods should be declared as static methods, so that they can be called without instantiation.

```java
public class Utils {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
```



## Downcasting

✅  Use **`instanceof`** to check whether the object passed in the runtime is actually an instance of the class to which it will be downcasted, to avoid `java.lang.ClassCastException` at runtime.



## Overriding Methods

✅  Whenever we override `equals()` method of `Object` class we should also override the `hashCode()` method of `Object` class.

✅ Add `@Override` annotation for methods inherited from the implemented interface/s.



## Inheritance

❗ Inheritance is good up to **`1, and 2 levels.`** Not more than 3 levels.



## Interfaces

✅ Interfaces should be small and lightweight so that they are less likely to change.

✅ An interface should focus on single capability -- separation of concerns.

❗ Theirs no gain in introducing interfaces for classes which are data containers.

* Data container classes
  * has set of attributes and getters and setters for them
  * no other methods which has implementation or algorithm

❌ Do not include fields, methods (static, default, private ...) in interfaces.

❌ If you need to add some implementation details that needs to be inherited by all children, then use **`abstract classes,`** not methods in interfaces.&#x20;

* If you want to make sure only subclasses can inherit the method, then you can declare the static method as a **`protected`** method.



## Exception Handling

✅ You should either prevent exceptions or should anticipate and handle exceptions.

✅️ Anticipate and handle edge cases.

✅️ It's best to log exceptions somewhere (e.g. file or database)&#x20;

✅️ If you are not printing an error message for the user to see when you catch an exception, then it's best  to re-throw them, so that somewhere else in the application a generic exception handler that catches all kinds of exceptions can get it and display a generic error message.&#x20;



## OS Resources

Resources like file handles, database connections, network connections.. are operating system resources.&#x20;

✅️  Whenever we acquire, occupy  external resources, we should always release them.&#x20;

* Otherwise other processes may not be able to access these resources.&#x20;

✅️  If the classes we use to acquire, occupy external resources implements `AutoCloseable` interface, then use try with resources statement.



## Data Validation

✅️  Use defensive programming if you are developing a framework for others to use or when data is received from external systems or user.

* If you are developing an application, you should have level of trust in your code. Your methods should trust each other. Don't pollute every method with data validation logic.&#x20;
* Perform this kind of data validation only when you receive input from the user or external systems. That is at the boundary of your application. Not within the application itself.



[^1]: magic number

[^2]: magic number

[^3]: magic number

[^4]: magic number moved to a constant

[^5]: magic number moved to a constant
