package com.shadhini.java.tryouts.advanced.lambdas;

// A Functional Interface - has a single abstract method
public interface Printer {

    // An abstract method
    void print(String message);

    // Default method
    default void printTwice(String message) {
        System.out.println(message);
        System.out.println(message);
    }
}
