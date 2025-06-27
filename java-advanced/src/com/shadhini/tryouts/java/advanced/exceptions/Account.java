package com.shadhini.tryouts.java.advanced.exceptions;

import java.io.IOException;

public class Account {
    private float balance;

    // Throw runtime exception
    public void depositThrowRuntimeException(float amount) {
        // This amount has to be a positive value
        if (amount <= 0)
            throw new IllegalArgumentException();
    }

    // Throw checked exception
    public void depositTrowCheckedException(float amount) throws IOException {
        // This amount has to be a positive value
        if (amount <= 0)
            throw new IOException();
    }


    // Demo 7: Custom Exceptions -----------------------------------------------------------------------------------
    public void withdrawWithCustomException(float value) throws InsufficientFundsException {
        if ( value > balance) // This is a situation we should anticipate and handle
            throw new InsufficientFundsException();

    }

    // Demo 8: Chaining Exceptions -------------------------------------------------------------------------------------
    public void withdrawWithChainingException(float value) throws AccountException {
        if ( value > balance)
            throw new AccountException(new InsufficientFundsException());

    }
}
