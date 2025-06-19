---
description: From java.lang package
icon: sigma
---

# \`Math\` Class

This class is automatically imported as it is from `java.lang` package. Thus, we don't have to explicitly import it.

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/com.shadhini.tryouts.java.basics/src/com/shadhini/tryouts/java/basics/MathClass.java" %}



## Ceil

> **The smallest integer that is greater than or equal to given number**



## Floor

> **The largest integer that is smaller than or equal to given number**



## Random

> **Floating point number between 0 and 1**&#x20;

<pre class="language-java"><code class="lang-java">int random = (int) <a data-footnote-ref href="#user-content-fn-1">Math.random()</a> * 100;
// random --> always 0
</code></pre>

```java
int random = (int) (Math.random() * 100);
// random --> random integer between 0 - 100
```





[^1]: casting is only applied to the result of this method which gives a number between 0 and 1
