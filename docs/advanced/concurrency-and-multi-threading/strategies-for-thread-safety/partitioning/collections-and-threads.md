---
icon: album-collection
---

# Collections & Threads

## Problems caused by multiple threads accessing a shared collection

#### Example: Race Condition caused by multiple threads accessing a shared collection

```java
import java.util.Arrays;
import java.util.Collection;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);
        /* Output:
        [4, 5, 6]
         */
    }
}
```

Here, since the output is \[4, 5, 6] one of our instructions has lost. This is because we have a race condition.



## Synchronized Collections

> **Synchronized Collection**:
>
> — A wrapper around a regular Collection type in Java that makes the regular collection synchronized —&#x20;
>
> Achieves thread safety by using **`locks`**
>
> * When a thread gets access to a synchronized collection, the entire collection gets locked and other threads have to wait.
>
>
>
> **`java.util.Collections`** class factory methods for creating synchronized collections
>
> * `Collections.synchronizedCollection​(Collection)`
> * `Collections.synchronizedList​(List)`
> * `Collections.synchronizedMap​(Map)`
> * `Collections.synchronizedSet​(Set)`
> * ...

```java
Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<>());
```

When we declare a collection as a synchronized collection as above, internally objects are stored inside this `ArrayList`.

But when we call this `synchronizedCollection()` method, it wraps this `ArrayList` inside a **synchronized collection**.

In that synchronized collection, all the methods like `add()`, `remove()` and so on.. have synchronization code.

#### Synchronized collections achieves thread safety by using `locks`.

So, when a thread gets access to a synchronized collection, the entire collection gets locked and other threads have to wait.

This works well for most cases, but it can have a negative **impact on performance and scalability** as the number of threads and concurrent operations increase.&#x20;

#### Example

```java
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        Collection<Integer> collection = 
            Collections.synchronizedCollection(new ArrayList<>());

        var thread1 = new Thread(() -> {
            collection.addAll(Arrays.asList(1, 2, 3));
        });

        var thread2 = new Thread(() -> {
            collection.addAll(Arrays.asList(4, 5, 6));
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(collection);
        /* Output:
        [1, 2, 3, 4, 5, 6]
         */
    }
}
```



## Concurrent Collections

> **Concurrent Collection**:
>
> Use the **`partitioning technique`** to allow concurrency;&#x20;
>
> * so they divide their data into segments &#x20;
> * different threads can concurrently work with different segments
> * but only one thread at a time can access a given segment
>
> Concurrent collections are **faster** than Synchronized collections.
>
>
>
> **`java.util.concurrent`** package
>
> Concurrent Collections
>
> * ConcurrentHashMap
> * ConcurrentLinkedDeque: double ended queue implemented using LinkedList
> * ConcurrentMap
> * ....

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrencyAndMultiThreadingDemo {

    public static void main(String[] args) {
        // Regular HashMap is not thread-safe
        Map<Integer, String> map = new HashMap<>();
        // key: Integer, value: String
        map.put(1, "a");
        System.out.println(map.get(1));

        // Thread safe ConcurrentHashMap
        Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put(1, "a");
        System.out.println(concurrentMap.get(1));
    }
}
```

Here, `Map` is an interface, `HashMap` and `ConcurrentHashMap` are 2 different implementations of this `Map` interface.







