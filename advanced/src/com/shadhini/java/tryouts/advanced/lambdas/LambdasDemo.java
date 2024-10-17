package com.shadhini.java.tryouts.advanced.lambdas;

public class LambdasDemo {

    private static String POSTFIX = "**";
    private String POSTFIX2 = "**2";

    public static void show() {
        // Concrete Implementation: Usual method for implementing an interface -----------------------------------------
        greet(new ConsolePrinter());

        // Anonymous Inner Class: Implementing a functional interface with Anonymous Inner Class -----------------------
        greet(new Printer() { // Anonymous Inner Class
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // Lambda Expressions: Implementing a functional interface with Lambda Expression ------------------------------
        greet((String message) -> {
            System.out.println(message);
        });

        greet((message) -> {
            System.out.println(message);
        });

        greet(message -> {
            System.out.println(message);
        });

        // Here, we are passing a lambda expression to the method as an argument
        greet(message -> System.out.println(message));

        // Lambda Expression: Store lambda expression in a variable ----------------------------------------------------
        // EITHER
        // set variable to a concrete implementation
        Printer printer = new ConsolePrinter();
        // OR
        // set variable to a lambda expression
        Printer printer2 = message -> System.out.println(message);

        greet(printer2);

        // Lambda Expression: Variable Capture -------------------------------------------------------------------------
        System.out.println("=========================================================================================");

        String prefix = "-";

        greet(message -> System.out.println(prefix + message + POSTFIX));

    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    public void show2() {
        greet(message -> System.out.println(message + POSTFIX2));
    }
}
