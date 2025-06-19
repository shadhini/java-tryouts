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

    // 3. Escape Sequences: --------------------------------------------------------------------------------------------
        System.out.println("3. Escape Sequences: --------------------------------------------------------------------");
        EscapeSequences.demo();

    // 4. Comments: ----------------------------------------------------------------------------------------------------
        System.out.println("4. Comments: ----------------------------------------------------------------------------");
        // Line comment

        /* Multiple Line Comment
        Line 2
        Line 3
         */

        /**
         * Document comment
         */

    // 5. Java Lang Package: -------------------------------------------------------------------------------------------
        System.out.println("5. Java Lang Package: -------------------------------------------------------------------");
        JavaLangPackageDemo.demo();

    // 6. Variables: ---------------------------------------------------------------------------------------------------
        System.out.println("6. Variables: ---------------------------------------------------------------------------");
        VariablesDemo.demo();

    // 7. Types: -------------------------------------------------------------------------------------------------------
        System.out.println("7. Types: -------------------------------------------------------------------------------");
        TypesDemo.demo();

    // 8. Arrays: ------------------------------------------------------------------------------------------------------
        System.out.println("8. Arrays: ------------------------------------------------------------------------------");
        ArraysType.demo();

    // 9. Multi Dimensional Arrays: ------------------------------------------------------------------------------------
        System.out.println("9. Multi Dimensional Arrays: ------------------------------------------------------------");
        MultiDimensionalArrays.demo();

    // 10. Constants: --------------------------------------------------------------------------------------------------
        System.out.println("10. Constants: --------------------------------------------------------------------------");

        final float PI = 3.14F;
        // PI = 1; // --> Compilation Error
        System.out.println(PI);

    // 11. Arithmetic Expressions: -------------------------------------------------------------------------------------
        System.out.println("11. Arithmetic Expressions: -------------------------------------------------------------");
        ArithmeticExpressions.demo();

    // 12. Casting and Type Conversion: --------------------------------------------------------------------------------
        System.out.println("12. Casting and Type Conversion: --------------------------------------------------------");
        CastingNTypeConversion.demo();

    // 13. java.lang.Math Class: ---------------------------------------------------------------------------------------
        System.out.println("13. java.lang.Math Class: ---------------------------------------------------------------");
        MathClass.demo();

    // 14. Formatting Numbers: -----------------------------------------------------------------------------------------
        System.out.println("14. Formatting Numbers: -----------------------------------------------------------------");
        FormattingNumbers.demo();

    // 15. Reading Input: ----------------------------------------------------------------------------------------------
        System.out.println("15. Reading Input: ----------------------------------------------------------------------");
        ReadingInput.demo();



    }


}