---
description: java.util.concurrent.locks.Lock interface
icon: lock
---

# Locks

## Locks

> **`java.util.concurrent.locks.Lock`** interface
>
> methods
>
> * **`.lock()`**: acquires the lock
> * **`.unlock()`**: releases the lock
>
> implementations
>
> * **`java.util.concurrent.locks.ReentrantLock`**:&#x20;

When we put a `lock` on a block of our code, the Java Virtual Machine will ensure that only one thread at a time can execute that block of code, which is called the **`critical section`**.

In reality our code is going to get **executed sequentially**.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        lock.lock();
        totalBytes++;
        lock.unlock();
    }
}
```

Now, when a thread enters the `incrementTotalBytes()` method, it will lock the `lock` object. Thereafter, no other threads can enter this method until the lock is release.

#### ✅ Best Practice

Use `try-finally` block and **release the lock on finally block** to ensure the lock is released even if an exception occurs.&#x20;

Otherwise, if an exception occurs after locking the lock object, it will stay locked forever and no other threads can execute this code.&#x20;

╰┈➤ This will cause a **`deadlock`** and the application will crash.

```java
// when a thread enters this method, it will lock the lock object
// now other threads cannot enter this method until the lock is released
public void incrementTotalBytes() {
    lock.lock();
    try {
        // critical section
        // this is where we modify the shared resource
        totalBytes++;
    } finally {
        // this block will always execute, even if an exception occurs
        // it ensures that the lock is released
        lock.unlock();
    }
    // best practice is to use try-finally block
}
```

In this case, incrementing a number is not going to throw an exception. Thus, the `try-finally` block is not really necessary. But in a scenario where more complex logic is executed, it's important to use a `try-finally` block.

***

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {
    private int totalBytes;
    private Lock lock = new ReentrantLock();

    public int getTotalBytes() {
        return totalBytes;
    }

    // when a thread enters this method, it will lock the lock object
    // now other threads cannot enter this method until the lock is released
    public void incrementTotalBytes() {
        lock.lock();
        try {
            // critical section
            // this is where we modify the shared resource
            totalBytes++;
        } finally {
            // this block will always execute, even if an exception occurs
            // it ensures that the lock is released
            lock.unlock();
        }
        // best practice is to use try-finally block
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

}
```

```java
import java.util.ArrayList;
import java.util.List;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        // All download threads report to a single DownloadStatus object 
        //    with locks on incrementTotalBytes() method
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
        .......
        Total bytes downloaded: 100000
         */
    }
}
```





