package com.shadhini.java.tryouts.advanced.lambdas;

public class LambdasDemo {

    private static String POSTFIX = "**";
    private String POSTFIX2 = "**2";

    public LambdasDemo() {
    }

    public LambdasDemo(String message) {
        // The signature of this constructor(except the name)
        //      matches the signature of `print` method declared in the `Printer` interface
    }

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

        // Lambda Expression: Method References ------------------------------------------------------------------------
        System.out.println("=========================================================================================");
        greet(System.out::println);

        // Reference a static method & pass the params to it
        // greet(LambdasDemo::print);

        // Reference an instance method & pass the params to it
        greet(new LambdasDemo()::print);

        var demo = new LambdasDemo();
        greet(demo::print);

        // Reference a constructor
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);

    }

    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }

    public void show2() {
        greet(message -> System.out.println(message + POSTFIX2));
    }

    /*
    public static void print(String message) {
        // The signature of this method matches the signature of method declared in the `Printer` interface
    }

     */

    public void print(String message) {
        // The signature of this method matches the signature of method declared in the `Printer` interface
    }

}
