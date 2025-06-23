---
icon: clock
---

# When to use Interfaces

## When to use Interfaces

> **When you want to `decouple` a class from it's dependencies**

If you extract an interface from every single class, you’ll end up with an explosion of interfaces that don’t necessarily add any values.&#x20;

You should use interfaces in situations where you want to decouple a class from its dependencies so you can&#x20;

* swap these dependencies
* allow building applications that are extensible and testable.

## Benefits of Interfaces&#x20;

1.  **Swap Implementation**

    * e.g:&#x20;
      * There are multiple ways to encode a video.  Later you might want to swap the current implementation with another faster and more accurate implementation.
      * When using third party services, you might want to change the service provider later.&#x20;
    * When classes are decoupled with interfaces you can plug a new implementation later with minimal or zero impact to the application.


2.  **Extend your Applications with minimal impact**

    * Particularly useful if you are designing framework for others to use; you can add extensibility points with interfaces.
    * e.g:
      * If you are implementing a framework for building web applications, your framework should have a templating engine; you should be able to parse some HTML templates, put some data there and return a response to the client. You can have a default templating engine, but others might want to use their own implementation of templating engines.
    * Instead of programming against concrete implementations, you are **`programming against interfaces`**.


3. **Test your classes in Isolation**
   * If your implementation uses an Email Service or Storage Engine, you can decouple these dependencies from the class and test that class in isolation.
   * **`Unit Testing`**

