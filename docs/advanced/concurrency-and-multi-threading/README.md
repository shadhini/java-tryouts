---
icon: arrows-to-circle
---

# Concurrency & Multi-threading

## Concurrency & Multi-threading

{% hint style="success" %}
Most computers these days have multi core processors, which can execute mny tasks in parallel.
{% endhint %}

### Process

> **Process**:
>
> An instance of a program or an application.

When you launch an application like your code editor or music player, your operating system loads that application inside a process.

Thus, **process contains**&#x20;

* an image of applications code,
* some memory and&#x20;
* bunch of other resources

#### Concurrency at the process level

Operating system can execute many processes at the same time.

* e.g: it can run an antivirus while playing music

#### Concurrency within the process&#x20;

We can have concurrency within the process or within the application using **`threads`**.



### Thread

> **Thread**:
>
> A sequence of instructions.
>
> — That thing that executes your code. —&#x20;

Each process has at least one thread called **`the main thread`**.&#x20;



### Multi Threading

> **Multi Threaded Applications**:
>
> Applications that use multiple threads.
>
> * makes program responsive and efficient.

Apart from the main thread of each process, we can create **additional threads** to **run many tasks concurrently**.

* e.g:&#x20;
  * a web server that can serve many clients at the same time, which will serve each client using a separate thread
  * an application that downloads multiple images concurrently, by starting multiple threads and have each thread download a separate image



