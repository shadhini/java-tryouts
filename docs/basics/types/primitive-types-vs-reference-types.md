---
icon: not-equal
---

# Primitive Types vs Reference Types



|                                                                             Primitive Types                                                                            |                                               Reference Types                                              |
| :--------------------------------------------------------------------------------------------------------------------------------------------------------------------: | :--------------------------------------------------------------------------------------------------------: |
|                                                                 Memory allocation & deallocation by JRE                                                                | <p>Memory deacllocation by JRE.<br>But, memory allocation by developer with <code>new</code> operator.</p> |
|                                                                           Don't have members.                                                                          |                    Classes & objects have `members` we can access using `dot` operator.                    |
|                                                                       For storing simple values.                                                                       |                                        For storing complex objects.                                        |
| <p>Changing value of x, does not change the value of y.</p><pre class="language-java"><code class="lang-java">byte x = 1;
byte y = x;
x = 2;
// x=2, y=1
</code></pre> |                                                                                                            |
|                                                                                                                                                                        |                                                                                                            |

