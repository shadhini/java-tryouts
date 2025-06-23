---
icon: input-text
---

# Fields in Interfaces

## Fields in Interfaces

> \[**`this feature is not recommended to use]`**
>
> Fields in interfaces are required to be **`public static final`** in all Java versions

* final -> constants
  * We should initialise them in the interface and we cannot change their value later.

```java
public interface TaxCalculator {
    float minimumTax =  100;
    
    double calculateTax();
}

public static void main(String[] args) {
    System.out.println(TaxCalculator.minimumTax);
}
```

### Intension of this feature

* To avoid magic number that pops up out of nowhere in the code.
  * This makes our code cleaner and easier to maintain.

### Implications&#x20;

1. **`Constants that are not same across all implementations`**
   * If value changes over time or depends on each implementation, then it should be defined in the implementation. Not at the interface.
     * e.g: `minimumTax`  may change from one year to another&#x20;
2. **`Constants that never change`**
   * If we are dealing with a value that never changes, using it as a constant in our implementation is an implementation detail.&#x20;
     * e.g: pi, number of months in year
   * This information shouldn’t be exposed through the interface. Other classes using the interface don’t need to know about the constant if it’s not relevant to them.&#x20;
   * Also, implementation details can change over time. We might no longer need the constant as the implementation evolves.&#x20;
     *   If we add a constant to the interface and later remove it, it could affect all classes depending on the interface and their dependencies.





