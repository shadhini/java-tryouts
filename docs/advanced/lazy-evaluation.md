---
icon: alarm-exclamation
---

# Lazy Evaluation

> Lazy Evaluation -> **Value is not generated until we explicitly ask for it**

e.g:

```java
import java.util.function.Supplier;

public class LambdasDemo {
    public static void main(String[] args) {
        Supplier<Double> getRandom = () -> Math.random();
        // This lambda expression represent a function;
        // Lazy evaluation:
        //      this function is not executed, until we explicitly call it;
        //      i.e. value is not generated until we explicitly ask for it.

        getRandom.get();
    }
}
```
