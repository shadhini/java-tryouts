---
icon: box-open
---

# \`java.lang\` package

* There's no need to import this package as this package is automatically imported. So, we can use any classes defined in this package directly.&#x20;

## Classes defined in java.lang package

### `System` class

<pre class="language-java"><code class="lang-java">package com.shadhini.java.tryouts.basics;

public class Main {
    public static void main(String[] args) {
        <a data-footnote-ref href="#user-content-fn-1">System</a>.out.<a data-footnote-ref href="#user-content-fn-2">println</a>("Hello World!"); 
        System.out.<a data-footnote-ref href="#user-content-fn-3">print</a>("Hello World2!");
    }
}
</code></pre>

Fields in `System` class

* **`System.out`** -> to print on terminal
* **`System.in`** -> to read from terminal



#### `System.out.println()` method

Calls the toString() method of any object.

Thus, no need to call toString() method inside the `System.out.println()` method.

```java
var textBox = new TextBox();
System.out.println(textBox.toString()); // -- A
System.out.println(textBox); // -- B
```

Here, both line `A` and line `B` will give the same output.



### `String` class

<pre class="language-java"><code class="lang-java">package com.shadhini.java.tryouts.basics;

public class Main {
    public static void main(String[] args) {
        <a data-footnote-ref href="#user-content-fn-4">String</a> message = <a data-footnote-ref href="#user-content-fn-5">"Hello World!"</a>;
    }
}
</code></pre>



### `Math` class

```java
package com.shadhini.java.tryouts.basics;

public class Main {
    public static void main(String[] args) {
        System.out.println(Math.round(1.5f)); 
    }
}
```



### `Object` class



#### More On ..

<table data-view="cards"><thead><tr><th></th><th data-hidden data-card-target data-type="content-ref"></th></tr></thead><tbody><tr><td><strong>Object Class</strong></td><td><a href="../oop/inheritance/object-class.md">object-class.md</a></td></tr></tbody></table>



[^1]: System class

[^2]: adds new line in the end

[^3]: doesn't add a new line in the end

[^4]: String class

[^5]: String literal; string value
