---
icon: people-arrows
---

# Casting & Type Conversion

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-basics/src/com/shadhini/tryouts/java/basics/CastingNTypeConversion.java" %}



## Implicit Casting

> **automatic casting/ conversion**
>
> **happens whenever we are not going to loose data**
>
> **byte** → **short** → **int** → **long** → **float** → **double**

Whenever we have a value that can be converted to a data type that is bigger,

&#x20;   ➜ casting / conversion happens **`implicitly/ automatically`**.



***

Integer has 4 bytes & short has 2 bytes.

* Thus, any value we store in a `short` variable can also be stored in an `integer` variable

<pre class="language-java"><code class="lang-java">short x = 1;
int y = <a data-footnote-ref href="#user-content-fn-1">x</a> + <a data-footnote-ref href="#user-content-fn-2">2</a>;
System.out.println(y); // 3
</code></pre>

Here,

1. Java looks @ value of `x`
2. Java allocate an anonymous (no name) variable somewhere in memory which is an integer
3. Then, Java copy value of `x` to that memory space
4. And then, it adds these 2 numbers together

***

An `integer` is less precise than a `double` as we can have digits after the decimal points in doubles.

```java
double x = 1.1;
double y = x + 2;
System.out.println(y); // 3.1
```

* So here, Java automatically casts integer to a double that is 2.0.





## Explicit Casting

> **can happen only between compatible types**

All the following types are compatible, since they are numbers.

> **byte** → **short** → **int** → **long** → **float** → **double**

* But we cannot cast a `String` to a number.



***

Here, we are trying to store 8 bytes `double` in 4 bytes `int.`

* This leads to a compile time `CastException`.

```java
double x = 1.1;
int y = x + 2; // compile time CastException 
```

Thus, we should explicitly cast the result of left side expression, as this casting results in a `loss of precision`.

```java
double x = 1.1;
int y = (int) x + 2; 
System.out.println(y); // 3
```

***



Following leads to a compile time Error of `Inconvertible types`.

```java
String x = "1";
int y = (int) x + 2;
```



> For all Primitive types, we have **`wrapper classes`**.

Wrapper class for `int` primitive type -> java.lang.Integer[^3]

* `Integer.parseInt()` method can parse a string to integer

```java
String x = "1";
int y = Integer.parseInt(x) + 2;
System.out.println(y); // Output: 3
```

Some other wrapper classes for primitive types and their methods to parse strings:

* short -> Short.parseShort()
* float -> Float.parseFloat()
* double -> Double.parseDouble()



[^1]: short

[^2]: integer

[^3]: Reference type
