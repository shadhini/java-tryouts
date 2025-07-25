---
icon: arrow-progress
---

# Executors

## Executor Framework

> **`Executor Framework`**:
>
> * ✅ simplifies **thread manipulation**
> * ❗does not prevent **concurrency problems**
>
> In Java, the concept of a thread pool is represented using the **`java.util.concurrent.ExecutorService`** interface and its implementations.

{% hint style="info" %}
**`java.util.concurrent.ExecutorService`** interface implementations

* **`java.util.concurrent.ThreadPoolExecutor`**:&#x20;
  * a typical thread pool implementation
  * The one that we use most of the time
* **`java.util.concurrent.ScheduledThreadPoolExecutor`**:
  * With this we can schedule tasks to run after a delay or periodically
  * E.g: we can schedule a task to run 5 hours from now, or every 2 hours
* **`java.util.concurrent.ForkJoinPool`**:
  * This is a special type of pool that is designed to recursively split a task into smaller tasks and then combine the result of each sub task to produce the overall result.
  * It's like a `divide & conquer` algorithm.
{% endhint %}

{% hint style="info" %}
**`ExecutorService`** methods

* `.submit(Runnable)`: submit a task to the thread pool
* `.submit(Callable)`:
  * **callable** is a task that returns a result
* `.shutdown()`: doesn't stop current tasks, this will wait for the completion of those tasks, but it's not going to accept any new tasks
* `.shutdownNow()`: this will force the existing tasks to stop
{% endhint %}

{% hint style="info" %}
**`java.util.concurrent.Executors`** class: a utility class that has bunch of static factory methods for creating an `ExecutorService`

* with these methods we can create an instances of these implementations
* **`Executors.newSingleThreadExecutor()`**: this returns an `Executor` with a single thread
  * we use this often
* **`Executors.newFixedThreadPool(numThreads):`** create a thread pool with a given number of worker threads; this would be an instance of `ThreadPoolExecutor` class
* **`Executors.newScheduledThreadPool(corePoolSize)`**: return an instance of `ScheduledThreadPoolExecutor` class
{% endhint %}



#### Create an Executor

```java
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        // thread pool with 2 worker threads
        var executor = Executors.newFixedThreadPool(2); 
        
    }
}
```

Why shouldn't we create a new instance of **`ThreadPoolExecutor`**  directly.&#x20;

* It's little bit difficult. Constructors of the `ThreadPoolExecutor` has bunch of parameters.
* That's why we use factory methods on `Executors` class.



```java
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2); 
        
        System.out.println(executor.getClass().getName());
        // Output: java.util.concurrent.ThreadPoolExecutor
    }
}
```

Here, the executor is of type `java.util.concurrent.ExecutorService` interface.\
At runtime, it will be an instance of `java.util.concurrent.ThreadPoolExecutor` class.



#### Submit Tasks to an Executor

```java
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2); 
        
        // Submit tasks to the executor; to the thread pool
        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " is executing task A")
        });
        
        // Output: pool-1-thread-1 is executing task A
    }
}
```

Here, we didn't have to explicitly create a thread.

Even **after the execution** of task, all above **program** **keeps running**.

* This happens because when we created an `Executor` and submit tasks to it. The Executor thinks that there might be more tasks coming in the future. So, it's not going to terminate. It's going to stay in the memory waiting for new tasks.
* So, **we have to explicitly shut down an `Executor` to terminate our program**.



#### Submit multiple tasks to Executor, Best practices & Shutting down the Executor&#x20;

```java
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2); 
        
        // We have only 2 threads available, and we are submitting 10 tasks below
        for (var i = 1; i < 11; i++) {
            final int taskId = i;
            executor.submit(() -> System.out.println(Thread.currentThread().getName() + " is executing task " + taskId));
        }
        
        // --------------A
        /* Output:
        pool-1-thread-2 is executing task 1
        pool-1-thread-1 is executing task 2
        pool-1-thread-2 is executing task 3
        pool-1-thread-1 is executing task 4
        pool-1-thread-2 is executing task 5
        pool-1-thread-1 is executing task 6
        pool-1-thread-2 is executing task 7
        pool-1-thread-1 is executing task 8
        pool-1-thread-2 is executing task 9
        pool-1-thread-1 is executing task 10
         */
         
        executor.shutdown(); // shutdown the executor; no new tasks will be accepted

    }
}
```

Internally, this executor maintains a queue to hold the tasks.



If you have some code @A and if it throws an exception, We are not going to be able to shut down the Executor properly.

{% hint style="success" %}
✅ Best Practice: We should run `executor.shutdown()` **inside a `try-finally` block**.
{% endhint %}

```java
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {
        var executor = Executors.newFixedThreadPool(2); 

        try {
            for (var i = 1; i < 11; i++) {
                final int taskId = i;
                executor.submit(() -> System.out.println(Thread.currentThread().getName() + " is executing task " + taskId));
            }
        } 
        finally {
            executor.shutdown(); // shutdown the executor
        }

    }
}
```

By calling the `shutdown()` method inside `try-finally` block we can make sure that no matter whate, we always shut down the `Executor` and **release it from the memory**.

