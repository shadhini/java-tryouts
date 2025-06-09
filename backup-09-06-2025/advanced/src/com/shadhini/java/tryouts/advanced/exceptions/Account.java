package com.shadhini.java.tryouts.advanced.exceptions;

import java.io.IOException;

public class Account {
    private float balance;

    // Throw runtime exception
    public void depositRuntime(float amount) {
        // This amount has to be a positive value
        if (amount <= 0)
            throw new IllegalArgumentException();
    }

    // Throw checked exception
    public void depositChecked(float amount) throws IOException {
        // This amount has to be a positive value
        if (amount <= 0)
            throw new IOException();
    }


    // Demo 6: Custom Exceptions -----------------------------------------------------------------------------------
    /*
    public void withdraw(float value) throws InsufficientFundsException {
        if ( value > balance) // This is a situation we should anticipate and handle
            throw new InsufficientFundsException();

    }

     */

    // Demo 7: Chaining Exceptions -------------------------------------------------------------------------------------
    public void withdraw(float value) throws AccountException {
        if ( value > balance)
            throw new AccountException(new InsufficientFundsException());

    }
}
