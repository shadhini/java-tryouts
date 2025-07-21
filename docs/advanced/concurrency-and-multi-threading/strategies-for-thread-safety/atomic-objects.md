---
description: java.util.concurrent.atomic package
icon: atom
---

# Atomic Objects

## Atomic Objects

> **— Use atomic classes in Java —**&#x20;
>
> **`java.util.concurrent.atomic`** package
>
> **Atomic Types**: better to implement  counters
>
> * **`AtomicInteger`**
>   * `.incrementAndGet()`: equivalent to ++a
>   * `.getAndIncrement()`: equivalent to a++
>   * `.get()`: returns the primitive integer
> * AtomicBoolean
> * AtomicLong
> * ...
>
> **Adder Classes**: faster; better to use if you have multiple threads updating a value frequently
>
> * **`LongAdder`**: for adding long values
>   * `.intValue()`: return the result as an integer
>   * .byteValue()
>   * .shortValue()
>   * .doubleValue()
>   * .increment()
>   * .decrement()
> * **`DoubleAdder`**: for adding double values



* These classes allow us to achieve **thread safety without using locks** as with these classes we can perform atomic operations.



## Atomic Types

#### Example: Incrementing a variable

* If we increment an Atomic Integer, the Java Virtual Machine will execute the increment operation as one single atomic operation.
  * It's not gonna break it down into 3 smaller operations.

#### Counters

{% hint style="success" %}
Atomic Objects are great for implementing counters.
{% endhint %}

✅ So, if you are **dealing with counter variables**, **prefer `atomic types`** to synchronization, because they are faster and easier to use.

#### Using Atomic Types to Prevent Race Conditions

```java
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadStatus {
    private AtomicInteger totalBytes = new AtomicInteger();

    public int getTotalBytes() {
        return totalBytes.get();
    }

    public void incrementTotalBytes() {
        totalBytes.incrementAndGet();
    }
}

public class DownloadFileTask implements Runnable {

    private final DownloadStatus status;

    public DownloadFileTask() {
        this.status = new DownloadStatus();
    }

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        for (var i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return; // exit the run method if the thread is interrupted
            status.incrementTotalBytes();
            System.out.println("Downloading byte " + i + " in thread: " + Thread.currentThread().getName());
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        // All download threads report to a single DownloadStatus1 object
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes downloaded: " + status.getTotalBytes());
        /* Output:
        ......
        Download complete: Thread-4
        Total bytes downloaded: 100000
         */
    }
}
```



### Compare & Swap Technique

The **`compare & swap technique`** is supported by most CPUs.

So, most CPUs can execute increment operation as a **single uninterruptible operation**.



When we call `incrementAndGet()` method of `AtomicInteger` class in Java,

* This atomic type is going to **compare** the current value with the expected value.&#x20;
* If they're not equal, it's going to **swap** them.

This entire operation is **natively supported** by most CPUs **as an atomic operation**.



## Adders

✅ If you have multiple threads updating a value frequently, it's better to use one of the **`Adder classes`** in Java.&#x20;

They are faster than atomic types.



### `LongAdder` class and  `.intValue()` method of the `LongAdder` class

The `LongAdder` object internally keeps an **array of counters** that can grow on demand.

So, we **don't have a single place in memory** where our value is stored.

Instead, we have a **bunch of array cells, each holding a counter value**.

╰┈➤ <kbd>So different threads can modify these counter variables concurrently.</kbd>

This is **why Adder classes are faster than Atomic Type**s, because they allow **more throughput**.



The `.intValue()` method of the `LongAdder` class, internally calls the method called `sum()` which returns the sum of all counter values added to this `LongAdder`, and then it converts the result into an integer.



### Using Adder Classes to Prevent Race Conditions

```java
import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
    private LongAdder totalBytes = new LongAdder();

    public int getTotalBytes() {
        return totalBytes.intValue();
        // internally this method called sum() which returns the sum of all counter values added to this LongAdder,
        //      and then it converts the result into an integer
    }

    public void incrementTotalBytes() {
        totalBytes.increment();
    }
}

public class DownloadFileTask implements Runnable {

    private final DownloadStatus status;

    public DownloadFileTask(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        for (var i = 0; i < 10_000; i++) {
            if (Thread.currentThread().isInterrupted()) return; // exit the run method if the thread is interrupted
            status.incrementTotalBytes();
            System.out.println("Downloading byte " + i + " in thread: " + Thread.currentThread().getName());
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

    public DownloadStatus getStatus() {
        return status;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        // All download threads report to a single DownloadStatus object
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            threads.add(thread);
        }

        // wait for all threads to finish
        for (var thread : threads) {
            try {
                thread.join(); // Wait for each thread to finish
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Total bytes downloaded: " + status.getTotalBytes());
        /* Output:
        ......
        Download complete: Thread-9
        Total bytes downloaded: 100000
         */
    }
}
```







