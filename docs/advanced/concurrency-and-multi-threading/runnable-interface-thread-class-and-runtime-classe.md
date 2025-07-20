---
description: java.lang.Runnable interface, java.lang.Thread class & java.lang.Runtime class
icon: reel
---

# Runnable interface, Thread class & Runtime classe

## Runnable Object

> **Runnable Object**:&#x20;
>
> An object that implements the **`java.lang.Runnable`** interface.&#x20;

**`java.lang.Runnable`** interface represents a **task to be run on a thread**.

It has a single method called `run()` which has no parameters and returns void.

## Thread Class

> **java.lang.Thread** class
>
> _constructors for creating threads_
>
> * **`Thread(Runnable)`**: most commonly used constructor
>
> _static factory methods_
>
> * **`Thread.activeCount()`**: returns number of active threads in the current process; current thread's thread group and its subgroups
> * **`Thread.currentThread()`**: returns the current thread
> * **`Thread.currentThread().getName()`**: returns the name of the current thread
> * **`Thread.currentThread().isInterrupted()`**: checks whether the current thread has received an interrupt signal/request

Each Thread has a _name_ and _id_.

## Runtime Class

> **java.lang.Runtime** class
>
> * **`Runtime.getRuntime().availableProcessors()`**: returns total number of available threads



```java
public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        // returns number of active threads in the current process; current thread's thread group and its subgroups
        System.out.println(Thread.activeCount());
        // Output: 2
        // This program is using 2 threads:
        // 1. main thread: the one that runs the main method
        // 2. background thread: the one that runs the garbage collector which remove unused objects from the memory

        // returns total number of available threads
        System.out.println(Runtime.getRuntime().availableProcessors());
        // Output: 10
        // Machine has 10 available processors (cores)
        // each core has 1 thread
        // Thus, the machine has 10 threads available to run things in parallel

    }
}
```





