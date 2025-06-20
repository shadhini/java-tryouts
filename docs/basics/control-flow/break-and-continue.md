---
icon: arrow-left-from-bracket
---

# Break & Continue

> **`break`** -> terminate the loop
>
> **`continue`** -> moves control to the beginning of the loop



When Java sees the **`break`** statement, it will ignore everything else afterwards and it will terminate the loop.&#x20;

* If you use `break` somewhere to check a condition and quit the loop, then you don't have to check the loop condition at the beginning of the loop.

The **`continue`** statement moves the control to the beginning of the loop.



```java
while (true) { // runs till the break condition is met
    // .....
    if (<CONDITION_1>) // condition to pass the current iteration
        continue; // move control to the beginning of the loop 
                    // and execute the block inside the loop once again
    // .....
    if (<CONDITION_2>) // loop terminate condition
        break; // terminate the entire loop; 
                // without this you'd end up with an infinite loop that never terminates
                // This is dangerous in terms of memory consumption
    // .....
}
```



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-basics/src/com/shadhini/tryouts/java/basics/control_flow/BreakAndContinueStatements.java" %}

