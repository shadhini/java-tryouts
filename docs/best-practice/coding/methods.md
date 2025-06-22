---
icon: function
---

# Methods

## Methods

✅️  You need to break down your code into small methods and improve code readability and reusability.

✅️  Ideally methods should be between 5-10 lines of code. Not more than 20 lines of code.

✅️  Extract repetitive patterns and highly related statements into methods and classes.



❗ An abstract class does not need abstract methods. But if we mark a method as abstract, we should mark the class as abstract as well.

### Utility Methods

✅️  Utility methods should be declared as static methods, so that they can be called without instantiation.

```java
public class Utils {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }
}
```

