---
icon: toggle-on
---

# Switch Statements

> Using switch statement, we can execute code depending on **value of expression**.
>
> <pre class="language-java"><code class="lang-java">switch (&#x3C;<a data-footnote-ref href="#user-content-fn-1">VAR</a>>) { // can use strings, integers other than long (byte, short, int)
>     case &#x3C;VAR_VALUE_1>:
>         // statements for the VAR_VALUE_1 case
>         
>         break; // to jump out of this switch block
>         // If we didn't add break statement here,
>         //    Then java will execute all other cases down there 
>         //    until it meets a break or end of the switch block.
>
>     case &#x3C;VAR_VALUE_2>:
>         // statements for the VAR_VALUE_2 case
>         break;
>
>     default: // If none of the above cases applies, then code here will be executed.
>         // statements for the default case
>         
>         // Here, we don't need to add `break`; 
>         //    since we are alreay at the end of the switch block,
>         //    we'll automatically jump out of the block.
> }
> </code></pre>



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-basics/src/com/shadhini/tryouts/java/basics/control_flow/SwitchStatement.java" %}





[^1]: can use strings and integers other than long (byte, short, int)
