---
description: java.util.concurrent.CompletableFuture<T> class
icon: comment-check
---

# Completable Futures

## Completable Futures

> **Completable Futures**:
>
> **— enable building complex asynchronous operations in a declarative way —**&#x20;



> **`java.util.concurrent.CompletableFuture<T>`** class
>
> With `CompletableFuture` class we can explicitly complete `Future` object, which is not something we can do with `Future` interface.&#x20;
>
>
>
> This class implements&#x20;
>
> * `java.util.concurrent.Future<V>` interface: represents the future result of an operation
> * `java.util.concurrent.CompletionStage<T>` interface: represents a step or a stage of a possibly asynchronous computation/operation and it gives us bunch of methods for combining and composing these steps in a declarative way
>   * like how we use Streams API to build a complex query in a declarative way



### Creating a Completable Future Object

{% content-ref url="creating-a-completable-future-object.md" %}
[creating-a-completable-future-object.md](creating-a-completable-future-object.md)
{% endcontent-ref %}



### Running Code on Completion

{% content-ref url="running-code-upon-completion.md" %}
[running-code-upon-completion.md](running-code-upon-completion.md)
{% endcontent-ref %}



### Handling Exceptions in Completable Futures

{% content-ref url="handling-exceptions.md" %}
[handling-exceptions.md](handling-exceptions.md)
{% endcontent-ref %}



### Transforming a Completable Future

{% content-ref url="transforming-a-completable-future.md" %}
[transforming-a-completable-future.md](transforming-a-completable-future.md)
{% endcontent-ref %}



### Composing Completable Futures for Task after Task

{% content-ref url="composing-completable-futures-for-task-after-task.md" %}
[composing-completable-futures-for-task-after-task.md](composing-completable-futures-for-task-after-task.md)
{% endcontent-ref %}



### Combining Completable Futures

{% content-ref url="combining-completable-futures.md" %}
[combining-completable-futures.md](combining-completable-futures.md)
{% endcontent-ref %}



### Waiting for Many Tasks to Complete

{% content-ref url="waiting-for-many-tasks-to-complete.md" %}
[waiting-for-many-tasks-to-complete.md](waiting-for-many-tasks-to-complete.md)
{% endcontent-ref %}



### Waiting for the First Task

{% content-ref url="waiting-for-the-first-task.md" %}
[waiting-for-the-first-task.md](waiting-for-the-first-task.md)
{% endcontent-ref %}



### Handling Timeouts

{% content-ref url="handling-timeouts.md" %}
[handling-timeouts.md](handling-timeouts.md)
{% endcontent-ref %}





