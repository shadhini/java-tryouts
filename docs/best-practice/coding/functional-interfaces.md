---
icon: integral
---

# Functional Interfaces

## Functional Interfaces

✅️  If you are working with primitive values, prefer to use **`primitive specialisations`** of  `Supplier, Consumer, Function, Predicate` interfaces.

* ╰┈➤ Because you don't pay the cost of **auto boxing** primitive value inside a reference type and then **unboxing** it later on.
