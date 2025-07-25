---
icon: square-code
---

# Running Code upon Completion

## Running Code upon Completion

#### Use case

Quite often we need to execute some code when an asynchronous operation completes.

E.g: Want to display the result or store it in the database



#### Methods inherited from `CompletionStage` interface

`CompletionStage` interface provide a bunch of methods for modeling complex asynchronous operations.

A lot of these methods start with _`then`_ ; that means when this task is finished, then do something else.



{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

methods

* `.thenRun(Runnable)`: when this stage completes normally, executes the given action &#x20;
  * given action would be run on main thread
  * `.thenRun(Runnable)` is one of those methods that is provided by the `CompletionStage` interface.&#x20;
* `.thenRunAsync(Runnable)`: when this stage completes normally, executes the given action in an asynchronous fashion
  * given task would be submitted to underlying `Executor` & executed asynchronously in another thread
* `.thenAccept(Consumer)`: when you need to get the result of `CompletableFuture`&#x20;
* `.thenAcceptAsync(Consumer)`:
{% endhint %}



#### `.thenRun(Runnable)`

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed!");
        });
        /* Output:
            main
            Task completed!
        */
    }

]
```



#### `.thenRunAsync(Runnable)`

```javascript
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenRunAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed!");
        });
        /* Output:
            ForkJoinPool.commonPool-worker-19
            Task completed!
        */
    }
}
```



#### `.thenAccept(Consumer)`

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenAccept(result -> {;
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed with result: " + result);
        });
        /* Output:
            main
            Task completed with result: 1
        */
    }
}
```



#### `.thenAcceptAsync(Consumer)`

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> 1);
        future.thenAcceptAsync(result -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Task completed with result: " + result);
        });
        /* Output:
            ForkJoinPool.commonPool-worker-19
        */
    }
}
```

Here, we don't see the result. This happens because our main thread finished earlier than the other thread that executed the task.



