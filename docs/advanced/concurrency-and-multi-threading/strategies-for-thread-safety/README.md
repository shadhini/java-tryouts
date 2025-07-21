---
icon: shield-check
---

# Strategies for Thread Safety

## Thread-safe Code

> **Thread-safe Code**:
>
> code that can be safely executed across multiple threads in parallel

**In Java, some classes are thread safe**; which means they can be safely used across many parallel threads.



## Strategies for Thread Safety

### **`Confinement`**&#x20;

* not share data across threads in the first place
* confine or restrict each thread to have its own data

{% content-ref url="confinement.md" %}
[confinement.md](confinement.md)
{% endcontent-ref %}



### **`Immutability`**

* using immutable or unchangeable objects

{% content-ref url="immutability.md" %}
[immutability.md](immutability.md)
{% endcontent-ref %}



### **`Synchronization`**

* prevent multiple threads from accessing the same object at the same time
* Synchronization **forces the code to run sequentially**; which is against the idea of parallel execution.

{% content-ref url="synchronization/" %}
[synchronization](synchronization/)
{% endcontent-ref %}

{% content-ref url="synchronization/locks.md" %}
[locks.md](synchronization/locks.md)
{% endcontent-ref %}

{% content-ref url="synchronization/the-synchronized-keyword-blocks-and-methods.md" %}
[the-synchronized-keyword-blocks-and-methods.md](synchronization/the-synchronized-keyword-blocks-and-methods.md)
{% endcontent-ref %}

#### Alternative for `synchronized` keyword to solve visibility problem with less overhead

{% content-ref url="the-volatile-keyword.md" %}
[the-volatile-keyword.md](the-volatile-keyword.md)
{% endcontent-ref %}



### **`Atomic Objects`**

* Use atomic classes in Java
  * e.g: Atomic Integer

{% content-ref url="atomic-objects.md" %}
[atomic-objects.md](atomic-objects.md)
{% endcontent-ref %}



### **`Partitioning`**

* Partitioning data into segments that can be accessed concurrently.&#x20;

{% content-ref url="partitioning/" %}
[partitioning](partitioning/)
{% endcontent-ref %}

{% content-ref url="partitioning/collections-and-threads.md" %}
[collections-and-threads.md](partitioning/collections-and-threads.md)
{% endcontent-ref %}



