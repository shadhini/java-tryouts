---
icon: paintbrush-pencil
---

# Custom Exceptions

## Need for Custom Exceptions

Java provides a lot of general exception classes that we can use in our applications.&#x20;

But sometimes we need to create custom exceptions that are specific to our application domain.

This is particularly useful if you are implementing framework or library for others to use.

Custom exceptions help users and other developers to better understand the intent and actual problem.



## Declaring Custom Exceptions

We always use `Exception` suffix when naming a custom exception. This is the same convention used in Java in naming Exception classes.

When declaring custom Exception, we need to decide whether it's going to be a checked or unchecked exception.&#x20;

* If it is **`checked`** exception -> We should have it extend the **`Exception`** class
* If it is an **`unchecked (runtime)`** exception -> We should have it extend the **`RuntimeException`** class

```java
// Checked - Exception
// Unchecked (runtime) - RuntimeException

// In this case we want this to be a checked exception, as it is a scenario we should anticipate and recover from
public class InsufficientFundsException extends Exception {

    // Optional implementation

    public InsufficientFundsException() {
        super("Insufficient funds in your account.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class Account {
    private float balance;

    public void withdraw(float value) throws InsufficientFundsException {
        if ( value > balance) // This is a situation we should anticipate and handle
            throw new InsufficientFundsException();

    }
}

public class ExceptionsDemo {

    public static void show() { 
        var account = new Account();
        try {
            account.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage()); // Output: Insufficient funds in your account.
        }
    }
}

```



