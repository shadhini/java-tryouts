package com.shadhini.tryouts.java.advanced.exceptions;

// More general purpose exception
public class AccountException extends Exception {

    public AccountException(Exception cause) {
        super(cause);
    }
}
