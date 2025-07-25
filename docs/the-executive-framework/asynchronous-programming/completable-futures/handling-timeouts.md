---
icon: alarm-clock
---

# Handling Timeouts

## Handling Timeouts

When calling a remote service, we want to have a **limit in terms of how long we are willing to wait** to get a response.

{% hint style="info" %}
**`java.util.concurrent.CompletableFuture<T>`** class

methods

* `.orTimeout(timeout, timeUnit)`:&#x20;
  * with this method we can enforce a limit for the time we are waiting for the result
  * this returns a new CompletableFuture that we timeout after given time
  * If the result of the task is not available within the given time out this throws a `java.util.concurrent.TimeoutException` wrapped inside an `java.util.concurrent.ExecutionException`.
* `.completeOnTimeout(defaultValue, timeout, timeUnit)`:
  * this will return the passed default value if this task timeouts
  * this returns a new CompletableFuture that will complete after given timeout time
{% endhint %}



#### Timeout Example

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate(); // runs for 3 seconds
            return 1;
        });

        try {
            var result = future
                    .orTimeout(1, TimeUnit.SECONDS) // wait for 1 second for the task to complete
                    .get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        /* Output:
            java.util.concurrent.ExecutionException: java.util.concurrent.TimeoutException
	        ....
            Caused by: java.util.concurrent.TimeoutException
	        ....
         */
        
    }
}
```

Here, the `result` variable is a new CompletableFuture object that we timeout after 1 second.&#x20;

Also, @ line A, when we call `.get()` method, we will get an Exception.

When, we run the program, **after 1 second, our program crashes** and we get an Exception of type `ExecutionException` which is caused by `TimeoutException`.



#### Better Approach with Default Value to recover after the Timeout

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> {
            LongTask.simulate(); // runs for 3 seconds
            return 1;
        });

        try {
            var result = future
                    .completeOnTimeout(100, 1, TimeUnit.SECONDS) // wait for 1 second for the task to complete
                    .get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // Output: 100
    }
}
```

Here, the `result` variable is a new CompletableFuture object that will complete after given timeout time.

When this program is run, if the task is not complete in given timeout period, then it's return the default value provided.

This provides **better experience for the end user**.

