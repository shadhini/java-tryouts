---
icon: ampersand
---

# Logical Operators

> used to combine multiple boolean expressions
>
> **`&&  ->  AND`**;   true only if both expressions are true
>
> **`||  ->  OR`**;   true if at least one expression is true
>
> **`!   ->  NOT`**;   reverse the value of the boolean expression

❗**Java evaluates expressions from left to right.**

## AND

<pre class="language-java"><code class="lang-java">int temperature = 12;
boolean isWarm = <a data-footnote-ref href="#user-content-fn-1">temperature > 20</a> &#x26;&#x26; <a data-footnote-ref href="#user-content-fn-2">temperature &#x3C; 30</a>;
</code></pre>

Here,

* If expression **➀** is `false`, then it doesn't matter what we have after the `AND` operand.
* Java will ignore other expressions as `AND` operator will return true only if both conditions are true.



## OR

<pre class="language-java"><code class="lang-java">boolean hasHighIncome = true;
boolean hasGoodCredit = true;
boolean isEligible = <a data-footnote-ref href="#user-content-fn-1">hasHighIncome</a> || <a data-footnote-ref href="#user-content-fn-2">hasGoodCredit</a>;
</code></pre>

Here,

* Since expression **➀** is `true`, it doesn't matter what we have afterwards.
* Thus, Java will not evaluate the rest of the expression.
* However if expression **➀** was `false`, then Java will continue evaluating the expressions, hoing that the next boolean expression is `true`.



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-basics/src/com/shadhini/tryouts/java/basics/control_flow/LogicalOperators.java" %}





[^1]: Expression **➀**

[^2]: Expression **➁**
