---
icon: not-equal
---

# Comparison Operators

> **used to compare primitive values**
>
> \==    !=    >    >=    <    <=   &#x20;

<pre class="language-java"><code class="lang-java"><a data-footnote-ref href="#user-content-fn-1">x == y</a>
</code></pre>

* This produces a boolean value. Thus, it is a **`boolean expression`**.



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/f8e74ea5d514f52f462bc6fb63b0610b5b0116b3/basics/src/com/shadhini/java/tryouts/basics/ComparisonOperators.java" %}



❗Comparison operators cannot be used with Reference types.

* Reference types carry the address of the actual object, not their values or object itself.

In Strings,

* We can use string equlity function.

<pre class="language-java"><code class="lang-java">String userInput = "";
Sytem.out.println(userInput.<a data-footnote-ref href="#user-content-fn-2">equals</a>("quit"));
</code></pre>



[^1]: boolean expression

[^2]: string equality function
