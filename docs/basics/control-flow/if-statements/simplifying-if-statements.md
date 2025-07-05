---
icon: right
---

# Simplifying If Statements

```java
int income = 120_000;
boolean hasHighIncome;
if (income > 100_000)
    hasHighIncome = true;
else
    hasHighIncome = false;
```

⬇&#x20;

```java
int income = 120_000;
boolean hasHighIncome = false;
if (income > 100_000)
    hasHighIncome = true;
```

⬇&#x20;

<kbd>**\[most professional version]**</kbd>

<pre class="language-java"><code class="lang-java">int income = 120_000;
boolean hasHighIncome = <a data-footnote-ref href="#user-content-fn-1">(income > 100_000)</a>;
</code></pre>





[^1]: boolean expression that evaluates to a value
