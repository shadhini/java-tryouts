---
icon: text-size
---

# Strings \[java.lang.String]

Although `String` is a reference type, we don't have to use `new` operator to allocate memory.&#x20;

* It can be specified shortly as follows.

```java
String message = "Hello World!";
```



In Java, **`Strings are immutable`**.

* They cannot be changed.
* Methods defined in `String` class do not modify the original string. Instead they return new strings

{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/51490c23f8c0bd70d937de8d6ab577db5276e77c/basics/src/com/shadhini/java/tryouts/basics/StringType.java" %}



{% content-ref url="escape-sequence.md" %}
[escape-sequence.md](escape-sequence.md)
{% endcontent-ref %}



