---
icon: square-v
---

# The volatile Keyword

## The `volatile` Keyword

Another way for writing thread safe code, without the overhead of synchronization.

Volatile means unstable.

> **`volatile`** keyword:
>
> **— gurantees that the changes to a field is visible across threads —**&#x20;
>
> With `volatile` keyword, we are telling the Java Virtual Machine that&#x20;
>
> * this field is **unstable** and it may change;&#x20;
> * so **don't rely on the value stored in the cache**;&#x20;
> * **always read it from the main memory**.

If another thread update the value of this field, the change will be immediately written to the main memory.&#x20;

**Solves the visibility problem, but not the race condition.**

* Ensures that if one thread changes some data, other threads can see the changes,
* Doesn't prevent 2 threads simultaneously modifying some data.



### Example

Here, one thread simulates downloading a file, and the other checks to see if the download is finished. When the download is finished, program report to the user.

```java
public class DownloadStatus {

    private volatile boolean isDone;
    private int totalBytes;
    private final Object totalBytesLock = new Object(); // lock for totalBytes

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) { // synchronized block
            totalBytes++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public boolean isDone() { // ---A
        return isDone;
    }

    public void done() { // ---B
        isDone = true;
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

        for (var i = 0; i < 1_000_000; i++) {
            if (Thread.currentThread().isInterrupted()) return; // exit the run method if the thread is interrupted
            status.incrementTotalBytes();
            System.out.println("Downloading byte " + i + " in thread: " + Thread.currentThread().getName());
        }

        status.done(); // mark the download as done

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

}
```

```java
public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        var status = new DownloadStatus();

        // thread for downloading a file
        var thread1 = new Thread(new DownloadFileTask(status));

        // thread for checking the download status
        var thread2 = new Thread(() -> { // lambda expression that represents a Runnable
            while (!status.isDone()) {
                // wait until the download is done
            }
            System.out.println("Download complete: Total Bytes " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();

    }
}
```



Here,

* `thread1`: runs the download, and after it's done, calls `status.done()`.
* `thread2`: keeps looping: `while (!status.isDone()) {}` until it sees the download is done

Thus, `isDone` field is accessed by both threads.



Without synchronization or `volatile`, **thread2 might never see the update** to `isDone` made by `thread1`.

* In Java, **each thread may cache variables** for performance. When `thread1` sets `isDone = true`, there's no guarantee that `thread2` will see this change unless you make sure updates are visible across threads.
* As a result, `thread2` can loop forever, **even after `thread1` sets `isDone = true`**, because it keeps seeing the cached value `false`.

╰┈➤ <kbd>**Visibility Problem**</kbd>

{% content-ref url="../../../java-caching/caching-values-by-threads.md" %}
[caching-values-by-threads.md](../../../java-caching/caching-values-by-threads.md)
{% endcontent-ref %}



#### With `synchronize` keyword

Even though the `synchronize` keyword at A and B on methods that update/read the `isDone` variable solves this issue, since the while loop of `thread2` constantly calls this `isDone()` method, it creates a lot of overhead. While `thread2` calls the `isDone()` method, no other threads can do anything else with the `DownloadStatus` object. They cannot call any other methods in this object.



#### With `volatile` keyword

Solves the visibility problem without the overhead of the synchronization.



