---
icon: arrows-to-circle
---

# Concurrency

## Threads

{% hint style="danger" %}
Do not use **wait() & notify() methods** in new code.
{% endhint %}

## Synchronization

{% hint style="danger" %}
**Synchronization is bad**.

* You should avoid it as much as possible.
* Don't use in new code.
{% endhint %}

{% hint style="success" %}
**Use** **`volatile`** **keyword** **to solve visibility problem** instead of `synchronized` keyword.

But it won't solve race conditions.
{% endhint %}

### Locks

✅ Locks should be released in a try-finally block.

```java
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
} 
```





### `synchronized`  blocks

❌ Do not use this keyword as reference to the current object for synchronized block's monitor object.

✅ Dedicated monitor objects should be passed for the synchronized block.

```java
public class DownloadStatus {
    private int totalBytes;
    private int totalFiles; // keep track of the number of files downloaded so far
    private final Object totalBytesLock = new Object(); // lock for totalBytes
    private final Object totalFilesLock = new Object(); // lock for totalFiles

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    public void incrementTotalFiles() {
        synchronized (totalFilesLock) {
            totalFiles++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public int getTotalFiles() {
        return totalFiles;
    }
}
```



✅ It's better to **use synchronized block with a dedicate monitor object** rather that synchronized methods. As synchronized method is equivalent to a synchronized block that wraps entire method body and uses the current object as the monitor object.

