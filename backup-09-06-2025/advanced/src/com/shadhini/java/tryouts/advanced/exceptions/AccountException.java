package com.shadhini.java.tryouts.advanced.exceptions;

// More general purpose exception
public class AccountException extends Exception {

    public AccountException(Exception cause) {
        super(cause);
    }
}
