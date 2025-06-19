package com.shadhini.tryouts.java.basics;

import com.shadhini.tryouts.java.basics.types.TypesDemo;

public class Main {

    // `main` method of `Main` class: Entry point for a Java program ---------------------------------------------------
    // should be static
    public static void main(String[] args) {
        System.out.printf("Entry point of the Java program: %s%n", Main.class.getName());

    // 1. Anatomy of a Java Program: -----------------------------------------------------------------------------------
        System.out.println("1. Anatomy of a Java Program: -----------------------------------------------------------");
        // @the calling point -- arguments: 5, 10
        ExampleClass.printSum(5, 10);

        // @the calling point -- mucdltiple arguments: 1, 2, 3, 4, 5
        ExampleClass.printNumbers(1, 2, 3, 4, 5);

    // 2. Textual Data: ------------------------------------------------------------------------------------------------
        System.out.println("2. Textual Data: ------------------------------------------------------------------------");
        // string: sequence of characters
        String text = "Hello, World!";
        // char: single character
        char character = 'A';

    // 3. Comments: ----------------------------------------------------------------------------------------------------
        System.out.println("3. Comments: ----------------------------------------------------------------------------");
        // Line comment

        /* Multiple Line Comment
        Line 2
        Line 3
         */

        /**
         * Document comment
         */

    // 4. Java Lang Package: -------------------------------------------------------------------------------------------
        System.out.println("4. Java Lang Package: -------------------------------------------------------------------");
        JavaLangPackageDemo.demo();

    // 5. Variables: ---------------------------------------------------------------------------------------------------
        System.out.println("5. Variables: ---------------------------------------------------------------------------");
        VariablesDemo.demo();

    // 6. Types: -------------------------------------------------------------------------------------------------------
        System.out.println("6. Types: -------------------------------------------------------------------------------");
        TypesDemo.demo();

    }


}