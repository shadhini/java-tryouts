---
icon: link-horizontal
---

# Chaining Exceptions

> **Wrapping an exception inside a more general exception**



<pre class="language-java"><code class="lang-java">public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds in your account.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}

// More general purpose exception
public class AccountException extends Exception {

}

public class Account {
    private float balance;

    public void withdraw(float value) throws InsufficientFundsException {
        // -- A
        if ( value > balance) {
            var fundsException = new InsufficientFundsException();
            var accountException = new AccountException();
            accountException.<a data-footnote-ref href="#user-content-fn-1">initCause</a>(fundsException);
            throw accountException;
        }

    }
}

public class ExceptionsDemo {

    public static void show() { 
        var account = new Account();
        try {
            account.withdraw(100);
        } catch (AccountException e) {
            System.out.println(e.getMessage()); // Output: Insufficient funds in your account.
        }
    }
}

</code></pre>

Withdrawing money could fail due to many different reasons. So at A we can throw different kinds of exceptions. We  can create another custom exception called `AccountException` and then we can wrap this exception inside `AccountException`.

╰┈➤ **`Chaining Exceptions`**

* A technique that used in building frameworks and libraries a quite a lot.
* So we get more general purpose exception and next we can figure out what caused that exception.
* In this case, `InsufficientFundsException`.

#### `initCause()` method or Exception class

The exception**`.initCause()`** method accepts **`Throwable`** and it initialises the _cause_ of this throwable to the specified value.&#x20;

#### `getCause()` method or Exception class

The exception**`.`**`getCause`**`()`** method returns the Exception that caused this exception.



## Better Implementation

```java
public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds in your account.");
    }

    public InsufficientFundsException(String message) {
        super(message);
    }
}

// More general purpose exception
public class AccountException extends Exception {
    public AccountException(Exception cause) {
        super(cause);
    }
}

public class Account {
    private float balance;

    public void withdraw(float value) throws InsufficientFundsException {
        // -- A
        if ( value > balance) 
            throw new AccountException(new InsufficientFundsException()); // -- B
    }
}

public class ExceptionsDemo {

    public static void show() { 
        var account = new Account();
        try {
            account.withdraw(100);
        } catch (AccountException e) {
            System.out.println(e.getMessage()); 
            e.printStackTrace();
        }
    }
}

/* Output:
com.shadhini.java.tryouts.advanced.exceptions.InsufficientFundsException: Insufficient funds in your account.
com.shadhini.java.tryouts.advanced.exceptions.AccountException: com.shadhini.java.tryouts.advanced.exceptions.InsufficientFundsException: Insufficient funds in your account.
	at com.shadhini.java.tryouts.advanced.exceptions.Account.withdraw(Account.java:34)
	at com.shadhini.java.tryouts.advanced.exceptions.ExceptionsDemo.show(ExceptionsDemo.java:102)
	at com.shadhini.java.tryouts.advanced.Main.main(Main.java:11)
Caused by: com.shadhini.java.tryouts.advanced.exceptions.InsufficientFundsException: Insufficient funds in your account.
	... 3 more
*/
```

Here, @ B, we are **`wrapping an exception inside more generic exception`**.

* This kind of stack traces can be commonly seen in most of the large enterprise applications.





[^1]: this method accepts any Throwable
