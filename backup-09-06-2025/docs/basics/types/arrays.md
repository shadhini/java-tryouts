---
icon: layer-group
---

# Arrays

> **A reference type used to store list of items.**

<pre class="language-java"><code class="lang-java">int[] numbers = new int[<a data-footnote-ref href="#user-content-fn-1">5</a>];
</code></pre>

The elements that haven't been explicitly set in an array are **`initialised to default values`**.

* If it's an `integer` array, values will be initialised to `0`.
* If it's a `boolean` array, values will be initialised to `false`.
* If it's a `String` array, values will be initialised to empty strings (`""`).

Java arrays have a **`fixed size, fixed length`**.

* Once created, we cannot add or remove additional items to or from the array.

If you want to add. remove items to, from an array, you have to use **`Collection`** classes.

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/51490c23f8c0bd70d937de8d6ab577db5276e77c/basics/src/com/shadhini/java/tryouts/basics/ArraysType.java" %}



`toString()` method is implemented multiple times for all primitive types as well as reference types.



[^1]: length of the array;

    number of items that can be added to the array
