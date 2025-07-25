---
icon: hourglass-half
---

# Waiting for Many Tasks to Complete

## Waiting for Many Tasks to Complete

Sometimes we need to wait for the completion of many tasks before doing something else.

{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

methods

* `.allOf(CompletableFuture<T>...)`:&#x20;
  * we can pass any number of Completable Futures to this method and wait until all of them complete
  * this will return a new `CompletableFuture` that will complete when all of these Completable Futures complete
{% endhint %}



```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var firstTask = CompletableFuture.supplyAsync(() -> 1);
        var secondTask = CompletableFuture.supplyAsync(() -> 2);
        var thirdTask = CompletableFuture.supplyAsync(() -> 3);

        var all = CompletableFuture.allOf(firstTask, secondTask, thirdTask);
        all.thenRun(() -> {
            try {
                var firstResult = firstTask.get(); // --------A
                System.out.println(firstResult);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
            System.out.println("All tasks completed successfully!");
        });
        /* Output:
            1
            All tasks completed successfully!
         */
    }
}
```

Here, the `all` variable is a `CompletableFuture` of `void`; the type **`CompletableFuture<Void>`**. It's because each `CompletableFuture` passed to method `.allOf()` may return a different data type. So, there's no way oof use to know what is the final result.&#x20;

Here, `all` is like **a task that complete when many other tasks complete**.&#x20;

Also, in this case, @ line A **`firstTask.get()`** **method is not going to block the current thread**, because this all task going to get executed asynchronously (in a separate thread) when all other tasks are complete.&#x20;

Thus, at this point (@ line A), when we call the `.get()` method of any of the prior tasks, we will **get the result immediately** as the **result is ready**.



