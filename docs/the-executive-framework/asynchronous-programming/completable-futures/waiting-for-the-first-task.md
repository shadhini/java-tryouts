---
icon: hourglass-start
---

# Waiting for the First Task

## Waiting for the First Task

Say there are 2 ways to get the current weather in a given city, perhaps we have 2 different remote services, but sometimes one of these services response a little bit slower.&#x20;

So, we want to call these services concurrently and as soon as we get a response, we're going to display it to the user.

{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

methods

* `.anyOf(CompletableFuture<T>...)`:&#x20;
  * this returns a new `CompletableFuture` that will complete as soon as one of these Completable Futures we have passed to the method completes
{% endhint %}



```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var firstTask = CompletableFuture.supplyAsync(() -> { // the slow service call
            LongTask.simulate();
            return 20;
        });
        var secondTask = CompletableFuture.supplyAsync(() -> 30); // the fast service call
        
        var fastest = CompletableFuture.anyOf(firstTask, secondTask);
        fastest.thenAccept(temp -> System.out.println(temp));
        // Output: 30
    }
}
```

Here, the `fastest` variable is a `CompletableFuture` of `Object`; it is of type `CompletableFuture<Object>`.&#x20;

When we run this program, we receive _temperature 30_ from the fast service immediately. We don't have to wait 3 seconds till we get a result from the slow service.



