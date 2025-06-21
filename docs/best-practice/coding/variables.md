---
icon: v
---

# Variables

## Variable

### Variable Naming

❗Avoid `magic numbers` in code; Always use constants (i.e. `final variables`) to describe them.

<details>

<summary>❌ </summary>

<pre class="language-java"><code class="lang-java">public class MortgageCalculator {

    // Some Code ...

    public static double calculateMortgage(int principal, float annualInterestRate, byte period) {
        float monthlyInterestRate = annualInterestRate / <a data-footnote-ref href="#user-content-fn-1">100</a> / <a data-footnote-ref href="#user-content-fn-1">12</a>;
        short numOfPayments = (short) (period * <a data-footnote-ref href="#user-content-fn-1">12</a>);

        double intermediateCalc = Math.pow(1  + monthlyInterestRate, numOfPayments);
        return  (principal * monthlyInterestRate * intermediateCalc) / (intermediateCalc - 1);
    }
}
</code></pre>

</details>

<details>

<summary>✅️</summary>

<pre class="language-java"><code class="lang-java">public class MortgageCalculator {

    final static byte <a data-footnote-ref href="#user-content-fn-2">MONTHS_IN_YEAR</a> = 12;
    final static byte <a data-footnote-ref href="#user-content-fn-2">PERCENT</a> = 100;

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

[^1]: magic number

[^2]: magic number moved to a constant
