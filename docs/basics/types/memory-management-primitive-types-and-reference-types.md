---
icon: database
---

# Memory Management: Primitive types & Reference types

> **Primitive Types**
>
> * Memory allocation & release -> by JRE
>
> **Reference Types**
>
> * Memory allocation -> by Developer
> * Memory release/ deallocation -> by JRE

When declaring **Primitive Types**, we don't need to allocate memory.

* Memory is `allocated` and `released` by `JRE` (Java Runtime Environment) .

But, when dealing with **Reference Types**, we should always `allocate` memory.

* But we don't have to `release` that memory. `JRE` will automatically take care of that.



{% @github-files/github-code-block url="https://github.com/shadhini/java-tryouts/blob/32cd54499f12ceff861f103d42cd48656f3700ed/basics/src/com/shadhini/java/tryouts/basics/PrimitiveVsReference.java" %}

## Primitive Types

```java
// Primitive Types
byte x = 1;
byte y = x;
```

These 2 variables are stored at different memory locations.

<div align="left">

<figure><img src="../../.gitbook/assets/java-primitives-memory-1.png" alt="" width="375"><figcaption></figcaption></figure>

</div>

If you change the value of x, y is ot affected.

```java
x = 2;
```

<div align="left">

<figure><img src="../../.gitbook/assets/java-primitives-memory-2.png" alt="" width="375"><figcaption></figcaption></figure>

</div>

