---
icon: message-plus
---

# New Features introduced to Interfaces

> **Java 8 (2014)**: Default and static methods were introduced
>
> **Java 9 (2017)**: Private methods were introduced

## Static Methods

> \[**`not recommended to use`**]
>
> Avoid static methods in interfaces.

```java
public interface TaxCalculator {
    // // An abstract method
    double calculateTax();
    
    // Static method [not recommended to use]
    static double getTaxableIncome(double income, double expenses) {
        return income - expenses;
    }
}
```

### Implication

When static methods are added to an interface,  implementation details are added to it.&#x20;

* Interfaces are **`about what's not how's`**.
* how's don't belong to interfaces, they belong to classes.

╰┈➤ If you need to add some implementation details that needs to be inherited by all children, then use **`abstract classes`**. If you want to make sure only subclasses can inherit the method, then you can declare the static method as a **`protected`** method.



### Better Implementation

```java
// Better Implementation
public interface TaxCalculator {
    double calculateTax();
}

public abstract class AbstractTaxCalculator implements TaxCalculator{

    protected static double getTaxableIncome(double income, double expenses) {
        return income - expenses;
    }
}

public class TaxCalculator2024 extends AbstractTaxCalculator {
    // We have inherited some behavior from parents, but they are not exposed to outside
    // And we have kept our contract/interface clean

    private double taxableIncome;

    public TaxCalculator2024(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    @Override
    public double calculateTax() {
        return getTaxableIncome(100_000, 50_000) * 0.3;
    }
}
```



## Private Methods

> \[**`not recommended to use`**]
>
> Avoid  both static and private methods in interfaces.

Has been added to Java to enable better code reuse between default and static methods.



## Default Methods

> \[**`not recommended to use`**]
>
> Avoid  all static, private and default methods in interfaces.

```java
public interface Printer {

    // An abstract method
    void print(String message);

    // Default method [not recommended to use]
    default void printTwice(String message) {
        System.out.println(message);
        System.out.println(message);
    }
}

```
