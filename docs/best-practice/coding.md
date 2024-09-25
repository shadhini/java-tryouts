---
icon: square-code
---

# Coding

* Programming is driven by the basic rule **`"Don't repeat yourself".`**
* Programming and problem solving is **`all about trade offs`**.

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



## Numbers

✅️ Use `_` to separate every 3 digits of large numbers.

✅️ Use `L` as a suffix to a number to denote it as a `long`.

✅️ Use `F` as a suffix to a number to denote it as a `float`.



## If Statements

{% content-ref url="../basics/control-flow/if-statements/simplifying-if-statements.md" %}
[simplifying-if-statements.md](../basics/control-flow/if-statements/simplifying-if-statements.md)
{% endcontent-ref %}

{% content-ref url="../basics/control-flow/ternary-operator.md" %}
[ternary-operator.md](../basics/control-flow/ternary-operator.md)
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



## Methods

✅️  You need to break down your code into small methods and improve code readability and reusability.

✅️  Ideally methods should be between 5-10 lines of code. Not more than 20 lines of code.

✅️  Extract repetitive patterns and highly related statements into methods and classes.



## Classes

✅️  Extract repetitive patterns and highly related statements into methods and classes.

✅ Logically related methods should be defined next to each other for better organisation of code.

✅ Define repeated constants on methods @ class level as final variables. Make them final static if variables belong to the class.



[^1]: magic number

[^2]: magic number

[^3]: magic number

[^4]: magic number moved to a constant

[^5]: magic number moved to a constant
