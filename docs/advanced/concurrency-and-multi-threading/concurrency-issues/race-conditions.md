---
description: 'Race Conditions: Example Scenario'
icon: person-running-fast
---

# Race Conditions

## Race Conditions: Example Scenario

```java
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

// All download threads report to a single DownloadStatus object
public class DownloadStatus {
    private int totalBytes;

    public int getTotalBytes() {
        return totalBytes;
    }

    public void incrementTotalBytes() {
        totalBytes++;
    }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        var status = new DownloadStatus();

        List<Thread> threads = new ArrayList<>();

        for (var i = 0; i < 10; i++) {
            var thread = new Thread(new DownloadFileTask(status));
            thread.start();
            // -- A
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
        Downloading byte 9998 in thread: Thread-31
        Downloading byte 9999 in thread: Thread-31
        Download complete: Thread-31
        Total bytes downloaded: 99998
         */
    }
}
```

Here, we are starting 10 download threads, each downloading 10,000 bytes (assumed) and sharing a single status object across these threads. And, once all these threads are complete, program should print the total number of bytes we have downloaded.

To wait for all the threads to complete, we cannot use `.join()` method @A. Because it will make the main thread to wait for each download to finish before starting another download since `.join()` method is a blocking method.

Here, we should start all these threads simultaneously and join with all of them.

When we run the program, we expect it to print 100, 000 bytes (10 threads each downloading 10,000 bytes) as the `totalBytes`. But that's not happening. The value of `totalBytes` keep changing in each run and it's less than 100, 000 bytes.

This is a **race condition in action**. Because multiple threads are racing and competing to update the total number of bytes



#### What happens under the hood:

```java
public void incrementTotalBytes() {
    totalBytes++;
}
```

* Even though `incrementTotalBytes()` method have only one line of code, there will be 3 steps happening under the hood.
  1. value of the `totalBytes` variable has to be read from the main memory and stored into CPU
  2. CPU increments the value of `totalBytes`&#x20;
  3. updated value of  `totalBytes` is going to be stored in the memory
* Therefore, the `totalBytes++` operation is a **non atomic operation** as it involves **multiple steps**.

{% hint style="success" %}
**Atomic Operation**:

We cannot break an atomic operation into many steps.
{% endhint %}



<kbd>n</kbd> = `0` → `1` (T1, T2)

| Thread 1 (T1) | Thread 2 (T2) |
| ------------- | ------------- |
| Read 0        | Read 0        |
| Increment     | Increment     |
| Write 1       | Write 1       |

Here, both T1 & T2 read the value of `n`(when n=0), the shared resource at the same time. Then both threads increment the read value of `n` at the same time. Then both threads write the new value of `n` (n=1) at the same time.

╰┈➤ This is how we lose an update&#x20;



