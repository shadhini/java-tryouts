---
icon: bring-front
---

# Interfaces

## Interfaces

✅ Interfaces should be small and lightweight so that they are less likely to change.

✅ An interface should focus on single capability -- separation of concerns.

&#x20;   ╰┈➤ **`Interface Segregation Principle`**

✅ Use **dependency injection** to make classes loose coupled.

✅ Use interfaces to develop loosely-coupled, extensible, testable applications & when you want to swap implementations.

❗ Theirs no gain in introducing interfaces for classes which are data containers.

* Data container classes
  * has set of attributes and getters and setters for them
  * no other methods which has implementation or algorithm

❌ Do not include fields, methods (static, default, private ...) in interfaces.

❌ If you need to add some implementation details that needs to be inherited by all children, then use **`abstract classes,`** not methods in interfaces.&#x20;

* If you want to make sure only subclasses can inherit the method, then you can declare the static method as a **`protected`** method.
