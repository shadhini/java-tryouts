---
icon: arrows-spin
---

# Asynchronous Programming

## Asynchronous Programming

> **Asynchronous Programming:**
>
> — non-blocking code —&#x20;



#### Issue with Callable Tasks&#x20;

The `.get()` method of the `Future` interface is a blocking method. When we call it, the current thread has to wait until the result of callable task is ready.

Even though we are executing this task in a separate, we are making the current thread wait for the completion of that thread.

╰┈➤ We are **not using our threads properly; and wasting them**.



#### Importance of Non blocking Code

In a desktop app or mobile app,&#x20;

* The main thread would be responsible for handling the UI events such as mouse clicks or key strokes.&#x20;
* So, if we make the main thread wait for the completion of another thread, it's not going to be able to respond to the UI events.&#x20;
* The application window is going to freeze and the user is not going to be able to resize or move it.

{% hint style="success" %}
To **get the most out of** our **threads**, we should write code in a **non-blocking way**.

╰┈➤ <kbd>**Asynchronous Programming**</kbd>
{% endhint %}

#### Asynchronous Programming

<kbd>We need to orchestrate our tasks, such that when a task completes, another task can get executed asynchronously.</kbd>

#### Asynchronous Operation

In real world, quite often an **asynchronous operation involves many steps**.

* Example:&#x20;
  * Step 1: Call a remote API to get some data
  * Step 2: Transform that data into a different structure
  * Step 3: Write that data into a database

## Completable Futures







