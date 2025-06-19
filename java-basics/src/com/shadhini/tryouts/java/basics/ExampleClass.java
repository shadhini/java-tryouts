package com.shadhini.tryouts.java.basics;

// Class Declaration
// =================================================================================================================
// <ACCESS_MODIFIER> class <CLASS_NAME> {}
public class ExampleClass {

    // Class Implementation

    // Method Declaration
    // =============================================================================================================
    // <ACCESS_MODIFIER> <STATIC> <RETURN_TYPE> <NAME>(<PARAMETERS>) {}
    public static void printSum(int num1, int num2) {
    // @method declaration -- parameters: num1, num2

        // Method Implementation
        System.out.printf("Sum: %d + %d = %d%n", num1, num2, num1 + num2);
    }

    // Var Args Declarations: array of params of same type
    // =============================================================================================================
    public static void printNumbers(int... numbers) {
        // @method declaration -- var args: numbers

        System.out.println("Numbers: ");
        for (int number : numbers) {
            System.out.printf("%d ", number);
        }
        System.out.println();
    }
}