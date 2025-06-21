---
icon: check
---

# If Statements

## If Statements

{% content-ref url="../../basics/control-flow/if-statements/simplifying-if-statements.md" %}
[simplifying-if-statements.md](../../basics/control-flow/if-statements/simplifying-if-statements.md)
{% endcontent-ref %}

{% content-ref url="../../basics/control-flow/ternary-operator.md" %}
[ternary-operator.md](../../basics/control-flow/ternary-operator.md)
{% endcontent-ref %}



***

✅️  When there are multiple conditions, we should have most specific conditions on top, and most generic ones at the bottom.

e.g: FizzBuzz readable version

```java
if (number % 5 == 0 && number % 3 == 0) // the most specific conditions comes to top
    System.out.println("FizzBuzz");
else if (number % 5 == 0)
    System.out.println("Fizz");
else if (number % 3 == 0)
    System.out.println("Buzz");
else
    System.out.println(number); // the most generic conditions goes to bottom
```



❗The more you `nest the if else statements`, the more **`complicated`** and confusing your code is going to be to other people.
