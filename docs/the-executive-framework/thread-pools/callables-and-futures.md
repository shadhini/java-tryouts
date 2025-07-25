---
icon: integral
---

# Callables & Futures

## Callables

> **`java.util.concurrent.Callable<V>`** interface:
>
> — represents a task that returns a value —&#x20;
>
> * Has a single abstract method called **`call()`** that returns **V**
>
> You can pass a callable object to the `Executor.submit()` method.



E.g: Usage of Callable interface

* Call the Twitter API to get the latest tweets for a given user



The `call()` method of the `Callable` interface is similar to the `run()` method of the `Runnable` interface, But instead of returning `void`, the `call()` method returns `V`; which is the generic type parameter of the `Callable` interface.



```java
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2);
        
        try {
            var future = executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + " is executing task B");
                return 1; // Callable task returns a value
            });
        }
        finally {
            executor.shutdown();
        }
        
    }
}
```

Here, the output of the callable task is captured in a `Future` object.



## Futures

> **Future**:
>
> An interface (**`java.util.concurrent.Future<V>`**) that represents the **future result of an operation**; an operation that will complete in the future.



The operation may complete in 500ms or 2 or 5 seconds, sometime in the future.

So, the result of this operation is not going to be calculated immediately using the CPU.

```java
public class LongTask {

    public static void simulate() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
```

```java
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2);
        
        try {
            var future = executor.submit(() -> {
                LongTask.simulate(); // Simulate a long-running task
                return 1; // Callable task returns a value
            });
            
            System.out.println("Do more work........");

            try {
                var result = future.get(); // get the result from Future object, when we really need it
                System.out.println("Result from Callable task: " + result);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        finally {
            executor.shutdown();
        }
        
    }
}

/* Output: 
    Do more work........
    Result from Callable task: 1
*/
```

Here, the submit() method going to return immediately.

* It's not going to wait for 3 seconds and it's going to **immediately return a `Future` object**.
* With this Future object, we can get the result of this operation.



We can call the `.get()` method of `Future` object, when we really need the results of this operation.

This `.get()` method is going to **block the current thread and having to wait until the result of this callable operation is ready**. Eventually, it's going to return a value.

In this case, the type of the `result` variable is an `Integer`.

When getting the result of this operation we have to handle couple of exceptions.

1. `java.lang.InterruptedException`: &#x20;
2. `java.util.concurrent.ExecutionException`: this happens if this callable task throws an exception



{% hint style="info" %}
**`java.util.concurrent.Future<V>`** interface:

methods

* `.get()`: get the value of the operation&#x20;
  * _— a blocking method —_&#x20;
* `.get(timeout, timeUnit)`: get the value of the operation with a timeout; if the operation is going to take so long, perhaps we don't want to wait forever, then we want the operation to timeout
  * _— a blocking method —_&#x20;
* `.cancel()`: for cancelling operation
* `.isCancelled():` check to see if this operation is cancelled
* `.isDone()`: tells whether this operation is complete or not
{% endhint %}



