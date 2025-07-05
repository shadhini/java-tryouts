---
icon: arrow-rotate-left
---

# For Loops

> <pre class="language-java"><code class="lang-java">for (<a data-footnote-ref href="#user-content-fn-1">int i=0</a>; <a data-footnote-ref href="#user-content-fn-2">i&#x3C;5</a>; <a data-footnote-ref href="#user-content-fn-3">i++</a>) {
>     // code here
> } // don't need curly braces for single line statement
> </code></pre>

➀ Initialisation

➁ Terminate Condition

➂ Step



1. Java executes ➀ first.
2. Then Java evaluates the condition ➁ .
3. If condition ➁  is `true`, then control moves to the block inside the loop.
4. At the end of this iteration, control moves to ➂ .
5. Then, again condition ➁ is evaluated and if it's `true`, then the body of the loop gets executed again.
6. Steps 4, 5 repeats till the condition ➁ is evaluated to `false`.
7. Then, the control moves outside the for loop.



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-basics/src/com/shadhini/tryouts/java/basics/control_flow/ForLoops.java" %}



[^1]: ➀ Initialisation

[^2]: ➁ Terminate Condition

[^3]: ➂ Step
