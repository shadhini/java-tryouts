---
description: Ligtweight and simpler alternative to synchronization
icon: atom
---

# Atomic Objects

## Atomic Objects

> **— Use atomic classes in Java —**&#x20;
>
> * e.g: Atomic Integer



* These classes allow us to achieve **thread safety without using locks**.
* If we increment an Atomic Integer, the Java Virtual Machine will execute the increment operation as one single atomic operation.
  * It's not gonna break it down into 3 smaller operations.
