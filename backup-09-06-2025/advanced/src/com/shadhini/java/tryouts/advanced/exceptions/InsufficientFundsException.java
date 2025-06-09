package com.shadhini.java.tryouts.advanced.exceptions;

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
