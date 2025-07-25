---
icon: person-swimming
---

# Thread Pools

## Problems of working directly with Threads



1. **Availability**
   * We have a limited number of threads available to us.
   * If you are not careful, you may end up creating too many threads and get `OutOfMemory Exception`.&#x20;
   * So application will crash.
2. **Cost**
   * Creating and destroying threads is expensive.
   * e.g: If you have 1000 tasks to execute (e.g: download 1000 images) and if only 10 threads are available,&#x20;
     * you have to download 10 images using these threads&#x20;
     * once these threads are complete, you have to create another set of 10 threads
     * and we have to repeat this several times to execute all the tasks



Java 5 solution for these problems&#x20;

╰┈➤ <kbd>**Thread Pool**</kbd>



## Thread Pool

> **Thread Pool**:
>
> A pool of threads called **`worker threads`**;
>
> * These threads can be reused to execute several tasks.

* When a **worker thread finishes it returns back to the pool**, so it can be reused to execute another tasks.
* So, these threads are **not destroyed and recreated**, they're always available and are reused to execute many tasks.
* **Thread pool has a fixed number of threads**.&#x20;
  * So, we don't have to worry about creating too many threads and running out of memory.
* In this model, we **submit our tasks to a thread pool** and **let the thread pool take care of thread manipulation**.



#### Example

We can create a thread pool of 10 threads and submit 1000 tasks to it.

* The **thread pool**, will take care of **assigning** our **tasks** to these threads.
* If **all threads are busy**, then new **tasks** will **wait in a queue**.&#x20;
* As soon as a thread becomes available, it would pick up a task from the queue and execute it.&#x20;



## Executors

{% content-ref url="executors.md" %}
[executors.md](executors.md)
{% endcontent-ref %}



## Callables & Futures

{% content-ref url="callables-and-futures.md" %}
[callables-and-futures.md](callables-and-futures.md)
{% endcontent-ref %}



