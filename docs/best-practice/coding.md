---
icon: square-code
---

# Coding

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







[^1]: magic number

[^2]: magic number

[^3]: magic number

[^4]: magic number moved to a constant

[^5]: magic number moved to a constant
