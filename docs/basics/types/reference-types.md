---
icon: asterisk
---

# Reference Types

> **for storing complex objects**&#x20;
>
> _**Non Primitive**_**;** all other types except 8 primitives

e.g: date, mail message



<pre class="language-java"><code class="lang-java">package com.shadhini.java.tryouts.basics;

<a data-footnote-ref href="#user-content-fn-1">import java.util.Date;</a>

public class ReferenceTypes {
    public static void main(String[] args) {
        Date <a data-footnote-ref href="#user-content-fn-2">now</a> = <a data-footnote-ref href="#user-content-fn-3">new</a> Date();
    }
}
</code></pre>

* `new` operator is used to allocate memory.
  * When declaring **Primitive Types**, we don't need to allocate memory. But, when dealing with **Reference Types**, we should always `allocate` memory.
* `now` variable is an instance of `Date` class.
* These classes/objects have `members` we can access using `dot` operator.







[^1]: To use a Date class from java.util package which is different from the current package of the current class, we need to `import` java.util  package first.

[^2]: instance of `Date` class

[^3]: used to allocate memory for the variable
