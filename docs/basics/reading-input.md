---
description: java.util.Scanner
icon: keyboard
---

# Reading Input

## Reading Input with Scanner

<pre class="language-java"><code class="lang-java">Scanner scanner = new Scanner(<a data-footnote-ref href="#user-content-fn-1">System.in</a>);
</code></pre>

**`scanner.next()`** -> reads **one token**; a word; till encountering a white space

**`scanner.nextLine()`** -> reads till next new line (`\n`) character; read all the spaces till new line character too

`scanner.close()` -> close the scanner to free up resources

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-basics/src/com/shadhini/tryouts/java/basics/ReadingInput.java" %}



## Reading Floating-point Numbers from the Terminal

```java
Scanner scanner = new Scanner(System.in);

float f = scanner.nextFloat();
double d = scanner.nextDouble();

scanner.close()
```

Use `scanner.nextDouble()` to avoid many problems as it captures a greater precision.

#### The decimal separator

Depending on locale settings of your compute, sometimes, the Scanner cannot read floating-point numbers with the dot character (`3.1415`), instead it reads numbers written with the comma separator (`3,1415`).

If you want to use the **dot character** without modifying your local settings, try using the following code to create a scanner:

```java
Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
```





[^1]: field in `System` class; to read from terminal
