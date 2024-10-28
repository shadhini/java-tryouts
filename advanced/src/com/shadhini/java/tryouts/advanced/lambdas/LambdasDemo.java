package com.shadhini.java.tryouts.advanced.lambdas;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasDemo {

    private static String POSTFIX = "**";
    private String POSTFIX2 = "**2";

    public LambdasDemo() {
    }

    public LambdasDemo(String message) {
        // The signature of this constructor(except the name)
        //      matches the signature of `print` method declared in the `Printer` interface
        System.out.println(message);
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
        System.out.println("===================Variable Capture======================================================");

        String prefix = "-";

        greet(message -> System.out.println(prefix + message + POSTFIX));

        new LambdasDemo().show2();

        // Lambda Expression: Method References ------------------------------------------------------------------------
        System.out.println("====================Method References====================================================");
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

        // Consumer Interface ------------------------------------------------------------------------------------------
        System.out.println("==============Consumer Interface=========================================================");

        List<Integer> list = List.of(1, 2, 3);

        // Imperative Programming: a programming paradigm where we implement logic using instructions
        // (e.g: for, if/else, switch/case -> Imperative Style)
        for (var item : list)
            System.out.print(item);

        System.out.println();

        // Declarative Programming
        // Instead of using instructions to specify how something should be done, this specifies what needs to be done
        // Here we don't have a for statement; we are simply saying for each item in this list, print it
        list.forEach(item -> System.out.print(item));

        System.out.println();

        list.forEach(System.out::print);

        System.out.println();

        // Chaining Consumers ------------------------------------------------------------------------------------------
        System.out.println("==============Chaining Consumers=========================================================");

        List<String> list2 = List.of("a", "b", "c");

        // Assign lambda expression that matches the abstract method of the consumer interface to a Consumer
        Consumer<String> print = item -> System.out.print(item);
        // Here we are declaring an operation called `print` that takes an item and print it on the terminal

        // Declare an operation that prints a string in UPPERCASE
        Consumer<String> printUppercase = item -> System.out.print(item.toUpperCase());

        // Iterate over list and in each iteration for each item call
        //      both operations mentioned above (print & printUppercase)
        //      in the order of print -> printUppercase -> print
        list2.forEach(print.andThen(printUppercase).andThen(print)); // Output: aAabBbcCc

        System.out.println();

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
        System.out.println(message);
    }

}
