---
description: Thread Signalling with wait() and notify()
icon: traffic-light-go
---

# Thread Signalling

## Thread Signalling

> **java.lang.Object** class
>
> instance methods
>
> * **`.wait()`**: makes this thread to go to sleep until another thread notifies it that the state of this object has changed
> * **`.notify()`**: notify the thread that is waiting for change on this object that the state of this object has changed
> * **`.notifyAll()`**: useful if there are multiple threads waiting for change on this object, to nofigy them all

#### Problem with While loop with a condition about thread status and an empty body&#x20;

```java
public class DownloadStatus {

    private volatile boolean isDone;
    private int totalBytes;
    private final Object totalBytesLock = new Object(); // lock for totalBytes

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) { 
            totalBytes++;
        }
    }

    public int getTotalBytes() {
        return totalBytes;
    }

    public boolean isDone() { 
        return isDone;
    }

    public void done() { 
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
            while (!status.isDone()) { // ---------C
                // wait until the download is done
            }
            System.out.println("Download complete: Total Bytes " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();

    }
}
```

Here, @ C, the `thread2` has to wait until the `isDone` filed becomes `true`. And it is implemented using a while loop.&#x20;

The problem with this implementation is, it **wastes CPU cycles**. Because this while loop is continuously running until the `isDone` field becomes `true`. It runs millions or trillions of times. Thus, it wastes CPU cycles.



#### Fix waste of CPU cycles caused by while loop with empty body using wait() & notify() methods

Every object in java has `wait()` and `notify()` methods. Since they are inherited from the `Object` class.

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

        status.done(); // mark the download as done
        synchronized (status) {
            status.notifyAll(); // notify any waiting threads that the state of the status object has changed
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }

}


public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        var status = new DownloadStatus();

        // thread for downloading a file
        var thread1 = new Thread(new DownloadFileTask(status));

        // thread for checking the download status
        var thread2 = new Thread(() -> { // lambda expression that represents a Runnable
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                        // this makes this thread to go to sleep
                        //      until another thread notifies it that the state of this status object has changed
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            System.out.println("Download complete: Total Bytes " + status.getTotalBytes());
        });

        thread1.start();
        thread2.start();

        /* Output:
            .....
            Download complete: Thread-0
            Download complete: Total Bytes 10000
         */
    }
}
```



When the `wait()` method is used, while loop won't iterate millions times; on the first iteration this `wait()` method is going to put the 2nd thread into sleep until another thread wakes it up.

Java Virtual Machine expects us to call the `wait()` method **inside a `synchronized` block.**

The `notify()`/`notifyAll()` method also should be wrapped inside a `synchronized` block. Otherwise Java Virtual Machine going to throw a RuntimeException.

The moment the 1st thread finishes its job, it's gonna notify the 2nd thread and then the sleeping 2nd thread will wake up. Thereafter, 2nd thread will print total bytes.

╰┈➤ This is **more efficient implementation** than the while loop with an empty body.



{% hint style="danger" %}
If **notify() and wait() methods** are not used properly on the code, they are gonna cause lot of problems.&#x20;

Thus, it is recommended to **not use them on new code**.&#x20;
{% endhint %}



