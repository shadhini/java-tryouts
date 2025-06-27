package com.shadhini.tryouts.java.advanced.exceptions;

// Checked - Exception
// Unchecked (runtime) - RuntimeException

// This is a Custom Checked Exception .....................
// In this case we want this to be a checked exception,
//      as it is a scenario we should anticipate and recover from
public class InsufficientFundsException extends Exception {

    // Optional implementation

    public InsufficientFundsException() {
        super("Insufficient funds in your account.");
    }

}
