---
description: Combining predicates to build complex predicates
icon: ampersand
---

# Combining Predicates

## Combining Predicates

> * negate() -> NOT&#x20;
> * and(Predicate ......) -> AND&#x20;
> * or(Predicate .....) -> OR

<pre class="language-java"><code class="lang-java">import java.util.function.Predicate;

<strong>public class LambdasDemo {
</strong>    public static void main(String[] args) {
        Predicate&#x3C;String> hasLeftBrace = str -> str.startsWith("{");
        Predicate&#x3C;String> hasRightBrace = str -> str.endsWith("}");

        // negate -> NOT
        // and -> AND
        // or -> OR
        
        System.out.println(hasLeftBrace.and(hasRightBrace).test("key:value}"));
        // Output: false
        
        System.out.println(hasLeftBrace.or(hasRightBrace).test("key:value}"));
        // Output: true
        
        System.out.println(hasLeftBrace.negate().test("key:value}"));
        // Output: true
    }
}
</code></pre>

Here, `hasLeftBrace.and(hasRightBrace)` returns a new `Predicate<String>`.

