---
icon: gears
---

# Transforming a Completable Future

## Transforming a Completable Future

Sometimes we need to transform the result of an asynchronous task.

E.g:&#x20;

* The remote weather service may return a temperature in a complex data structure. But we are only interested in the temperature as a numeric value. So we ant to map/ transform the result into a different type.
* Say, the weather service returns the temperature in Celsius, but we want to print it in Fahrenheit.&#x20;

{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

methods

* `.thenApply(Function)`: convert /map the result to a different type, once the Completable Future task is complete
  * returns a new CompletableFuture object
* `.thenApplyAsync(Function)`: run the conversion/mapping in a new thread; will submit a new task to the underlying Executor
{% endhint %}



#### `.thenApply(Function)`

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 20); // say, this returns temperature in Celsius
        future
            .thenApply(CompletableFuturesDemo:: toFahrenheit) // convert celsius to fahrenheit
            .thenAccept(System.out::println); // consume the result
        // Output: 68.0
    }
}
```

Here, we built a CompletableFuture, then we transformed it and finally we consumed the result.





