---
icon: face-hand-peeking
---

# Abstraction

> **Reduce complexity by hiding unnecessary details**
>
> * Hide implementation details of a class and treat it like a black box.
> * Expose a simple interface (bunch of methods) to work with to the outside.



### Metaphor: Car and Engine

* Car has an engine.&#x20;
* Implementation of engine is complex, but we don't really need to know about it.
* All we need to know is how to start and stop the car.
* So we can **hide implementation** details of the engine.

### In abstraction,

* We hide implementation details of the lass and treat it like a black box.
* We don't care what's inside, we just have simple interface to work with,
* Just like car key/buttons to turn it on, lock, unlock.

### Benefit

* We might change complex implementation details of a class as time goes by.
* But we don't want to update all other classes using the modified class.
* So we need to hide these implementation details and expose a bunch of methods for others to use.

