---
description: java.util.Queue<E> Interface
icon: layer-group
---

# Queue Interface

## Queue Interface

> **Used in situations where we need to process jobs in the order we've received them.**
>
> e.g: how printer process jobs

Extends the `Collection` interface

* Thus, provides all capabilities of a `Collection` with  additional capabilities.

Mostly used implementations of `Queue` interface are&#x20;

* `ArrayDeque`: Deque is short for  Double Ended Queue; a special type of queue that has 2 ends, so items can enter from either end.
* `PriorityQueue`: a special type of queue where each item gets a priority, and this priority determines the position of the item in the queue; so items with higher priority move to the front of the queue
  * e.g: queue used by OS to manage processes; processes with high priority gets more CPU time



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/main/java-advanced/src/com/shadhini/tryouts/java/advanced/collections/QueueDemo.java" %}



In an `ArrayDeque`, there's no difference between `queue.add()` and `queue.offer()`.&#x20;

However, in other types of queues, it depends on the implementation.&#x20;

* For instance, if the queue has a fixed size, when it becomes full, `queue.add()` will throw an exception, while `queue.offer()` will simply return `false`. This makes `queue.offer()` a less aggressive option.

