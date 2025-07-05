package com.shadhini.tryouts.java.advanced.lambdas;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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


    public static void greet(Printer printer) {
        printer.print("Hello World!");
    }


    public static void printStaticMethod(String message) {
        // The signature of this method matches the signature of method declared in the `Printer` interface
    }

    public void printInstanceMethod(String message) {
        // The signature of this method matches the signature of method declared in the `Printer` interface
        System.out.println(message);
    }

    public static void main(String[] args) {
        // Concrete Implementation -------------------------------------------------------------------------------------
        // =============================================================================================================

        // Concrete Implementation: Usual method for implementing an interface -----------------------------------------
        System.out.println("Concrete Implementation: Usual method for implementing an interface ---------------------");
        greet(new ConsolePrinter());

        // Anonymous Inner Classes -------------------------------------------------------------------------------------
        // =============================================================================================================
        // Anonymous Inner Class: Implementing a functional interface with Anonymous Inner Class -----------------------
        System.out.println("Anonymous Inner Class: Implementing a functional interface with Anonymous Inner Class ---");
        greet(new Printer() { // Anonymous Inner Class
            @Override
            public void print(String message) {
                System.out.println(message);
            }
        });

        // Lambda Expressions ------------------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Lambda Expressions: ---------------------------------------------------------------------");

        // Lambda Expressions: Notation --------------------------------------------------------------------------------
        /*
        // Lambda Expression with no parameters and single line of code
        greet(() -> System.out.println(""));
         */

        /*
        // Lambda Expression with multiple parameters and multiple lines of code
        greet((a, b) -> {
            System.out.println(a);
            System.out.println(b);
        });
         */

        // Lambda Expression with one parameter and single line of code
        greet(message -> System.out.println(message));

        // Lambda Expression: Passing a lambda expression to the method as an argument ---------------------------------
        System.out.println("Lambda Expression: Passing a lambda expression to the method as an argument -------------");
        greet(message -> System.out.println(message));

        // Lambda Expression: Store lambda expression in a variable ----------------------------------------------------
        System.out.println("Lambda Expression: Store lambda expression in a variable --------------------------------");
        // EITHER
        // set variable to a concrete implementation
        Printer printer = new ConsolePrinter();
        // OR
        // set variable to a lambda expression
        Printer printer2 = message -> System.out.println(message);

        greet(printer2);

        // Lambda Expression: Variable Capture -------------------------------------------------------------------------
        System.out.println("Lambda Expression: Variable Capture -----------------------------------------------------");

        String prefix = "-";

        greet(message -> System.out.println(prefix + message + POSTFIX));

        new LambdasDemo().demoVariableCapture();

        // Lambda Expression: Method References ------------------------------------------------------------------------
        System.out.println("Lambda Expression: Method References ----------------------------------------------------");
        greet(System.out::println);

        // Reference a static method that matches the method signature of the abstract method in functional interface
        //      & pass the params to it
        greet(LambdasDemo::printStaticMethod);

        // Reference an instance method that matches the method signature of the abstract method in functional interface
        //      & pass the params to it
        greet(new LambdasDemo()::printInstanceMethod);

        var demo = new LambdasDemo();
        greet(demo::printInstanceMethod);

        // Reference a constructor
        greet(message -> new LambdasDemo(message));
        greet(LambdasDemo::new);

        // Built-in Functional Interfaces ------------------------------------------------------------------------------
        System.out.println("Built-in Functional Interfaces ----------------------------------------------------------");
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

        // Supplier Interface ------------------------------------------------------------------------------------------
        System.out.println("==============Supplier Interface=========================================================");

        Supplier<Double> getRandom = () -> Math.random();
        // This lambda expression represent a function;
        // Lazy evaluation:
        //      this function is not executed, until we explicitly call it;
        //      i.e. value is not generated until we explicitly ask for it.

        System.out.println(getRandom.get());

        // Function Interface ------------------------------------------------------------------------------------------
        System.out.println("==============Function Interface=========================================================");

        // set function to a lambda expression that takes a string and return an integer
        Function<String, Integer> map = str -> str.length();

        System.out.println(map.apply("Sky")); // Output: 3

        // Composing Functions------------------------------------------------------------------------------------------
        System.out.println("==============Composing Functions========================================================");

        // 2 transformations
        /*
        input: string (e.g: "key:value")
        1st transformation: replace colon with equal sign (e.g: "key=value")
        2nd transformation: add braces around the string (e.g: "key=value")
         */
        Function<String, String> replaceColonWithEqual = str -> str.replace(":", "=");
        Function<String, String> surroundWithCurlyBraces = str -> "{" + str + "}";

        // Declarative Programing
        var value = replaceColonWithEqual
                        .andThen(surroundWithCurlyBraces)
                        .apply("key:value");
        // Here, replaceColonWithEqual.andThen(surroundWithCurlyBraces) returns a Function
        // If needed we can store this Function in a variable and call apply() on it later
        System.out.println(value); // Output: {key=value}

        var value2 = surroundWithCurlyBraces
                        .compose(replaceColonWithEqual)
                        .apply("key:value");
        System.out.println(value2); // Output: {key=value}

        // Predicate Interface -----------------------------------------------------------------------------------------
        System.out.println("==============Predicate Interface========================================================");

        // Check whether a string has more than 5 characters
        Predicate<String> isLongerThan5 = str -> str.length() > 5;
        // Here, in the lambda expression we have a boolean expression to return a boolean value
        System.out.println(isLongerThan5.test("sky")); // Output: false

        // Combining Predicates-----------------------------------------------------------------------------------------
        System.out.println("=============Combining Predicates========================================================");

        Predicate<String> hasLeftBrace = str -> str.startsWith("{");
        Predicate<String> hasRightBrace = str -> str.endsWith("}");

        // negate -> NOT
        // and -> AND
        // or -> OR
        System.out.println(hasLeftBrace.and(hasRightBrace).test("key:value}")); // Output: false
        System.out.println(hasLeftBrace.or(hasRightBrace).test("key:value}")); // Output: true
        System.out.println(hasLeftBrace.negate().test("key:value}"));

        // BinaryOperator Interface-------------------------------------------------------------------------------------
        System.out.println("=============BinaryOperator Interface====================================================");

        // a, b -> a+b -> square (a+b)
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(2, 3)); // Output: 5

        Function<Integer, Integer> square = (a) -> a * a;

        var result = add.andThen(square).apply(2, 3);
        System.out.println(result); // Output: 25

        // UnaryOperator Interface--------------------------------------------------------------------------------------
        System.out.println("=============UnaryOperator Interface=====================================================");

        UnaryOperator<Integer> add5 = a -> a + 5;
        UnaryOperator<Integer> decrement = a -> a - 1;

        System.out.println(add5.andThen(decrement).apply(2)); // Output: 6

    }

    // Demonstration of variable capture in lambda expressions with a non-static field
    public void demoVariableCapture() {
        greet(message -> System.out.println(message + POSTFIX2));
    }


}
