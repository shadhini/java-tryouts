---
description: Handling Exceptions in Completable Futures
icon: bug
---

# Handling Exceptions

## Handling Exceptions in Completable Futures

#### Example Use-case

We call an remote API to get the current weather in a given city. This remote call may fail for various reasons.&#x20;

#### Catch/Get Exception thrown from CompletableFuture

```java
import java.util.concurrent.CompletableFuture;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather...");
            throw new IllegalStateException("Weather service is down");
        });
        
        /* Output:
            Getting the current weather...
        */
    }
}
```

The above program doesn't throw an Exception. It is because, this Exception was thrown on a different thread. To get this Exception, we have to call the `.get()` method of the `Future` interface.

The `.get()` method of the `Future` interface returns a value of type V and it can throw exception of type `InterruptedException` or `ExecutionException`.&#x20;

* `InterruptedException`: happens if the thread is sleeping, but we try to interrupt it
* `ExecutionException`: happens if something goes wrong during the execution of an asynchronous task

If an Exception is thrown on the thread that is executing our task, the **`.get()` method is able to propagate that Exception and bring it into our main thread**.&#x20;

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesDemo {

    public static void main(String[] args) {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather...");
            throw new IllegalStateException("Weather service is down");
        });
        
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.getCause(); // return the actual cause of this exception
            e.printStackTrace();
        }
        
        /* Output:
            Getting the current weather...
            java.util.concurrent.ExecutionException: java.lang.IllegalStateException: Weather service is down
                at java.base/java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:395)
                at java.base/java.util.concurrent.CompletableFuture.get(CompletableFuture.java:1999)
                at com.shadhini.tryouts.java.advanced.executive_framework.asynchronous_programming.CompletableFuturesDemo.main(CompletableFuturesDemo.java:45)
            Caused by: java.lang.IllegalStateException: Weather service is down
        */
    }
}
```

Now, we get an `ExecutionException` which is caused by `IllegalStateException`. So the Exception we threw in our lambda expression is wrapped inside an `ExecutionException`.&#x20;



#### Return a default value if an Exception is thrown

Say, we don't want our program to crash even if the weather service is down.

In that case, before we call `.get()` method of the `Future` interface we call `.exceptionally(Function<Throwable,?>)` method which maps a `Throwable` to a different type.

```java
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesDemo {

    public static void main(String[] args) {  
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Getting the current weather...");
            throw new IllegalStateException("Weather service is down");
        });

        try {
            var result = future.exceptionally(ex -> 1).get();
            // say, the value `1` is the last temperature we read successfully
            System.out.println("The current temperature is: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.getCause();
            e.printStackTrace();
        }
    }
}
```

Now, when we call the `.get()` method, we get the result that is the last temperature, if an exception is thrown.

The `.exceptionally(Function<Throwable,?>)` method returns a new `CompletableFuture` object which is different from the one we originally created.

With this method, we are programming this `CompletableFuture` to **return a default value if an exception is thrown**.

{% hint style="info" %}
A lot of methods in the `CompletableFuture` class **return a new `CompletableFuture`**.
{% endhint %}

