---
icon: octagon-plus
---

# Creating a Completable Future Object

## Creating a Completable Future Object

{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

factory methods

* **`CompletableFuture.runAsync(Runnable) | CompletableFuture.runAsync(Runnable, Executor)`**
  * to run a task that doesn't return a value
  * this method basically says to run this code in the Runnable object in asynchronous or non blocking fashion, in a separate thread
  * if you don't pass an `Executor`, then this method is going to run our task on a common pool
* **`CompletableFuture.supplyAsync(Supplier) | CompletableFuture.supplyAsync(Supplier, Executor)`**
  * to run a task that returns a value
  * if you don't pass an `Executor`, then common pool will be used
{% endhint %}

### Common Pool

* `ForkJoinPool.commonPool()` method returns the pool that is used by the `CompletableFuture` class
* this pool is well aware of the number of available threads&#x20;
  * `Runtime.getRuntime().availableProcessors()`
* the common pool is based on the number of available threads



### Methods of `Future` object and `CompletableFuture` object

{% hint style="success" %}
Since **`CompletableFuture` is a `Future` object**, you can use all the methods you've used with `Future` object with the `CompletableFuture` object.
{% endhint %}

Methods like `.get()` method inherited from Future interface are blocking.

However, the CompletableFuture object has bunch of methods that allows us to build complex asynchronous operations.



### Example: Creating a `CompletableFuture` object

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        // execute a task that doesn't return a value in asynchronous fashion
        Runnable task = () -> System.out.println("a");
        var completableFuture = CompletableFuture.runAsync(task);


        // execute a task that returns a value in asynchronous fashion
        Supplier<Integer> taskWithValue = () -> 1;
        var completableFutureWithValue = CompletableFuture.supplyAsync(taskWithValue);
        

        try {
            // the .get() method inherited from the Future interface 
            //     is blocking the current/main thread
            var result = completableFutureWithValue.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } 
    }
}
```

Here,

The `completableFuture` object is of type `java.util.concurrent.CompletableFuture<Void>`, as we are not returning anything.

The type of the `completableFutureWithValue` object is `CompletableFuture` of `Integer`; i.e.  `java.util.concurrent.CompletableFuture<Integer>`.
