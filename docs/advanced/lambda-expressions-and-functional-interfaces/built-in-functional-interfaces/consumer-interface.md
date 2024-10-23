---
icon: arrow-down-to-square
---

# Consumer Interface

> **Represents an operation that takes a single argument and doesn't return a value**
>
> ╰┈➤ Consumes a value

e.g:

```java
public interface Printer {
    void print(String message);
    // This `print` method simply cosumes the `message`; 
    // takes a single argument and doesn't return a value
}
```

Lot of methods in Java expects an object that implements the `Consumer` interface.

***



`Consumer<T>` interface has one abstract method `accept`, and a default method.

<figure><img src="../../../.gitbook/assets/java-ad-lambdas-2-consumer-interface.png" alt=""><figcaption></figcaption></figure>

There are few variations of `Consumer<T>` interface.

1. [BiConsumer\<T, U>](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/function/BiConsumer.html)
   * The `accept` method takes 2 arguments.
2. [IntConsumer](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/util/function/IntConsumer.html)
   * A primitive specialisations of `Consumer<T>` interface.
   * The `accept` method, takes a primitive integer.
   * If you are dealing with lot of integers it is **more efficient** to use this interface as opposed to a regular `Consumer<T>` interface.&#x20;
     * Because with this interface, we **don't pay the cost of** **auto boxing**.
3. LongConsumer
4. DoubleConsumer





