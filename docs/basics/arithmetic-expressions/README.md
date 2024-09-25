---
icon: calculator-simple
---

# Arithmetic Expressions

**Expression**: a piece of code that produces a value

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/51490c23f8c0bd70d937de8d6ab577db5276e77c/basics/src/com/shadhini/java/tryouts/basics/ArithmeticExpressions.java" %}

## Division

`dividend/divisor`

### Integer Division

> **integer / integer  ➜  integer**

In Java, division of 2 whole numbers is a whole number.

\-> Here, the fractional part (the **`remainder`**) is `thrown away`.

### Floating-point Division

> **(`float` or `double`) / (`float` or `double`)  ➜   decimal result**

If you want to get a floating point numbers through division, then you have to change **one of the operands** in division to a `float` or `double`.

\-> This will give a `decimal result`

### Division by Zero

> **integer / 0    ➜     java.lang.ArithmeticException**
>
> **(float or double) / 0    ➜     Infinity**

***

## Modulus

> **a % b    ➜    remainder of integer division**

***

## Increment/ Decrement

Postfix

```java
int x = 1;
x++;
System.out.println(x); // 2
```

Prefix

```java
int x = 1;
++x;
System.out.println(x); // 2
```

Postfix with Assignment

<pre class="language-java"><code class="lang-java">int x = 1;
<a data-footnote-ref href="#user-content-fn-1">int y = x++;</a>
System.out.println(x); // 2
System.out.println(y); // 1
</code></pre>

@ `*`&#x20;

1. value of `x` get copied to `y` → x=1, y=1
2. then `x` is incremented by 1 → x=2, y=1

Prefix with Assignment

<pre class="language-java"><code class="lang-java">int x = 1;
<a data-footnote-ref href="#user-content-fn-2">int y = ++x;</a>
System.out.println(x); // 2
System.out.println(y); // 2
</code></pre>

@ `*`&#x20;

1. `x` is incremented by 1 → x=2
2. then, value of `x` get copied to `y` → x=2, y=2



## Compound / Augmented Assignment Operators

```
x += 2 → x = x + 2
x -= 2 → x = x - 2
x *= 2 → x = x * 2
x /= 2 → x = x / 2
x %= 2 → x = x % 2
```



{% content-ref url="order-of-operations.md" %}
[order-of-operations.md](order-of-operations.md)
{% endcontent-ref %}



[^1]: \*

[^2]: \*
