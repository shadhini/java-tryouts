---
icon: square-s
---

# The synchronized Keyword, Blocks & Methods

## The `synchronized` Keyword

With `synchronized` keyword we can achieve the same result as locks, but without explicitly creating a lock object and locking and unlocking it.

### Synchronized Blocks

**`synchronized(`**`<MONITOR_OBJECT>`**`)`**

Here, between parentheses we should pass an object; which is called as **`monitor object`**.

**Every object in Java has a built in lock**. So here, Java is going to get the built in lock from this object passed between parentheses and use it under the hood.

```java
public void incrementTotalBytes() {
    synchronized (this) { // using this as the reference to the current object
        totalBytes++;
    }
}
```

❌ Passing `this` as the reference to the current object as above is considered a **bad practice**.



#### ❌ Bad Practice: Passing `this` (current object) as the monitor object for the `synchronized` block

```java
public class DownloadStatus {
    private int totalBytes;
    private int totalFiles; // keep track of the number of files downloaded so far

    public void incrementTotalBytes() {
        synchronized (this) { // using this object as a lock is bad practice
            totalBytes++;
        }
    }

    public void incrementTotalFiles() {
        synchronized (this) { // using this object as a lock is bad practice
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

With this implementation, if one thread is calling the `incrementTotalFiles()` method, another thread cannot call `incrementTotalBytes()` method as both these methods are **using the same monitor object**.

Only one thread at a time can call into a synchronous method of this object.

╰┈➤ ‼️ This causes lot of overhead.&#x20;

╰┈➤ 🔻 For updates on 2 fields, using the same monitor object reduces the throughput of the class.

╰┈➤ ✅ Thus, in large applications with more concurrency requirements, you should **use dedicated monitor objects**.



#### ✅  Good Practice: Passing dedicated monitor objects for the `synchronized` block

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

Here, technically you can use any type of object for the lock. It's more conventional to use the `Object` class as we're not looking for any specific behaviours.



### Synchronized Methods

When synchronized keyword is used on the method signature, it wraps the entire method inside a `synchronized(this)` block.&#x20;

```javascript
public synchronized void incrementCurrentBytes() {
    currentBytes++;
}
```

Thus above synchronized method is equivalent to the following synchronized block.

```java
public void incrementCurrentBytes() {
    synchronized (this) {
        currentBytes++;
    }
}
```

&#x20;

{% hint style="warning" %}
You should be **cautious about using synchronized methods** as this is gonna synchronize on the current object.
{% endhint %}

{% hint style="success" %}
It's better to **use synchronized block with a dedicate monitor object** rather that synchronized methods.
{% endhint %}

