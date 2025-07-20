---
description: Start, Pause, Join & Interrupt Threads
icon: reel
---

# Threads: Start, Pause, Join, Interrupt

## Threads: Start, Pause, Join, Interrupt

> **java.lang.Thread** class
>
> instance methods
>
> * **`.start()`**: start running thread; i.e. executing the `run()` method of the `Runnable` implementation
> * **`.sleep​(milliseconds)`**: suspend/sleep/pause this thread for a given time period
> * **`.join()`**: make the current thread to wait for the completion of this thread; a blocking method
> * **`.interrupt()`**: sends an interrupt signal to the thread; doesn't actually force the thread to stop

## Thread Creation & Start

#### Download a file using a Runnable task

```java
public class DownloadFileTask implements Runnable {
    
    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());
    }
}

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread thread1 = new Thread(new DownloadFileTask());
        thread1.start(); // start thread

        /* Output:
        main
        Downloading file in thread: Thread-0
         */
    }
}
```

Here, we have 2 threads:

1. **main thread**: the one that runs the main method
2. **Thread-0**: the one that runs the DownloadFileTask

Each thread starts, executes a task and then dies.\
So, we don't have to explicitly kill the threads.



```java
public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        for (var i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }

        /* Output:
        main
        Downloading file in thread: Thread-0
        Downloading file in thread: Thread-1
        Downloading file in thread: Thread-4
        Downloading file in thread: Thread-10
        Downloading file in thread: Thread-3
        Downloading file in thread: Thread-5
        Downloading file in thread: Thread-2
        Downloading file in thread: Thread-8
        Downloading file in thread: Thread-9
        Downloading file in thread: Thread-6
        Downloading file in thread: Thread-7
         */
     }
 }
```

Here, we have the main thread and 10 extra thread for downloading files concurrently.&#x20;

Even though these messages are appearing sequentially on the terminal, these threads starts and run in parallel.



## Thread Sleeping / Pausing

#### Thread.sleep() to suspend current thread for a given time.

```java
public class DownloadFileTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(5000); // sleep for 5 seconds to simulate file download
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        for (var i = 0; i < 10; i++) {
            Thread thread = new Thread(new DownloadFileTask());
            thread.start();
        }
        /* Output:
            main
            Downloading file in thread: Thread-16
            Downloading file in thread: Thread-14
            Downloading file in thread: Thread-12
            Downloading file in thread: Thread-18
            Downloading file in thread: Thread-19
            Downloading file in thread: Thread-20
            Downloading file in thread: Thread-17
            Downloading file in thread: Thread-15
            Downloading file in thread: Thread-11
            Downloading file in thread: Thread-13
            Download complete: Thread-15
            Download complete: Thread-18
            Download complete: Thread-16
            Download complete: Thread-14
            Download complete: Thread-12
            Download complete: Thread-19
            Download complete: Thread-13
            Download complete: Thread-11
            Download complete: Thread-17
            Download complete: Thread-20
         */
    }
}
```

This `Thread.sleep(milliseconds)` method will suspend/pause the current thread for roughly 5000 milliseconds or 5 seconds.&#x20;

This is **not going to be exactly 5 seconds** as this is **dependent on the underlying operating system**.&#x20;

But we can assume that this thread will be sleeping for roughly 5 seconds and **during this time, other threads can get processor time**.

`java.lang.InterruptedException` gets thrown if you try to interrupt the thread that is sleeping.



Here, these 10 threads start at the same time and after 5 seconds, they all complete.

If we had a single threaded application, downloading these 10 files would take 50 seconds instead of 5 seconds as each download will start, once another download finished.



## Thread Scheduler

#### How to run 100-1000 file downloads concurrently in 4 cores 8 threaded machines

Say we want to download 100/1000 files concurrently and say the machine has 4 cores and 8 threads available.

Now, Java Virtual Machine (JVM) has a **`Thread Scheduler`**.&#x20;

The job of this scheduler is to decide what threads to run for how long.

So, if you have **more tasks than the available threads**, the scheduler **switches between these tasks giving each of them a slice of the CPU time**. This happens so fast that it gives us the illusion that these tasks are being executed in parallel. But that's parallelism at software level.



## Thread Joining

```java
public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread downloadThread = new Thread(new DownloadFileTask());
        downloadThread.start();


        // Here, we can use the join() method to wait for the download thread to finish before starting the scan thread
        try {
            downloadThread.join(); // Wait for the download thread to finish
            // This makes the current thread, which is the main thread, wait until the download thread finishes its execution
            // blocks the current thread until the download thread has finished
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("File is ready to be scanned for viruses....");

        // Now, we can start the scan thread
    }
}
```

Above program kick off another thread to scan the downloaded file for viruses, after file is downloaded.

With `.join()` method, we tell the **current thread** to **wait for the completion of this thread**.&#x20;

Here, **while the current thread is waiting, it cannot do other things**.

e.g:&#x20;

* In the case of a desktop or mobile app, this main thread is responsible for handling UI events like mouse clicks and keystrokes.&#x20;
  * So, if you make the main thread wait for another thread, it cannot respond to this UI event while it's waiting.
  * &#x20;Thus, UI will freeze, and the user will not be able to resize or move the application window.



## Interrupting a Thread

Quite often when dealing with long lived tasks, we want to give our users the ability to cancel running task in the middle.

The `.interrupt()` method **doesn't** actually **force the thread to stop**, it simply **sends an interrupt signal to the thread**. It's up to that thread to decide if it should stop what it's doing.&#x20;

For the thread to be able to stop what it's doing when interrupted, the runnable class should continuously check for an interrupt request. If it receives that interrupt request, it should and act accordingly.&#x20;

```java
public class DownloadFileTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Downloading file in thread: " + Thread.currentThread().getName());

        for (var i = 0; i < Integer.MAX_VALUE; i++) {
            // check for an interrupt signal/request
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Download interrupted in thread: " + Thread.currentThread().getName());
                return; // exit the run method if the thread is interrupted
            }
            System.out.println("Downloading byte " + i + " in thread: " + Thread.currentThread().getName());
        }

        System.out.println("Download complete: " + Thread.currentThread().getName());
    }
}

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new DownloadFileTask());
        thread.start();

        try {
            Thread.sleep(1000); // Sleep for 1 second to allow the thread to start downloading
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // cancel thread after 1 second
        thread.interrupt();
    }
}
```

Here, after 1 second the download thread gets interrupted and exits.

{% hint style="warning" %}
If the **thread is sleeping** **and** we send an **interrupt** request to it, it **throws an exception**.&#x20;

That is why we have to handle `java.lang.InterruptedException` when pausing a thread with _.sleep()_ method.
{% endhint %}



{% hint style="info" %}
In all these examples, the download threads have been isolate from each other.
{% endhint %}
