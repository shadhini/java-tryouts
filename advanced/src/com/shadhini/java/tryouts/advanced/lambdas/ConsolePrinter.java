package com.shadhini.java.tryouts.advanced.lambdas;

/**
 * Prints message on console/terminal.
 */
public class ConsolePrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
