---
icon: person-swimming
---

# Thread Pools

#### Executors

❌ Don't create new instance of **`ThreadPoolExecutor`**  or other Executors directly.&#x20;

* ✅ Use factory methods available on `Executors` class.

✅ We should run `executor.shutdown()` **inside a `try-finally` block**.
