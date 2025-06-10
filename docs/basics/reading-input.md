---
description: java.util.Scanner
icon: keyboard
---

# Reading Input

<pre class="language-java"><code class="lang-java">Scanner scanner = new Scanner(<a data-footnote-ref href="#user-content-fn-1">System.in</a>);
</code></pre>

**`scanner.next()`** -> reads **one token**; a word; till encountering a white space

**`scanner.nextLine()`** -> reads till next new line (`\n`) character; read all the spaces till new line character too



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/212756e20b892d86d44d8c3a567abd99d0300051/basics/src/com/shadhini/java/tryouts/basics/ReadingInput.java" %}





[^1]: field in `System` class; to read from terminal
