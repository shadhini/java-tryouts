package com.shadhini.java.tryouts.basics;

/**
 * About arithmetic expressions in Java.
 */
public class ArithmeticExpressions {

    public static void main(String[] args) {
        int additionResult = 10 + 3;
        System.out.println("10 + 3 = " + additionResult);
        int subtractionResult = 10 - 3;
        System.out.println("10 - 3 = " + subtractionResult);
        int multiplicationResult = 10 * 3;
        System.out.println("10 * 3 = " + multiplicationResult);
        /* Output:
        10 + 3 = 13
        10 - 3 = 7
        10 * 3 = 30
         */

        // Integer Division: Division of 2 whole numbers (integers) is a whole number, remainder is discarded
        // ============================================================================================================
        int integerDivisionResult = 16 / 3;
        System.out.println("----------------Integer Division---------------");
        System.out.println("16 / 3 = " + integerDivisionResult);
        /* Output:
        ----------------Integer Division---------------
        16 / 3 = 5
         */

        // int integerDivisionByZero = 16 / 0;
        // System.out.println("16 / 0 = " + integerDivisionByZero);
        /* Output:
        ==> java.lang.ArithmeticException
         */

        // Floating-point Division: If one of the operands is a float/double, then output is decimal
        // ============================================================================================================
        float floatingPointDivisionResult = 16.0f / 3;
        float floatingPointDivisionByZero = 16.0f / 0;
        double doubleDivisionResult = 16.0 / 3;
        double doubleDivisionResult2 = (double) 16 / 3;
        double doubleDivisionResult3 = (double) 16 / (double) 3;
        System.out.println("----------------Floating-Point Division---------------");
        System.out.println("16.0f / 3 = [float] " + floatingPointDivisionResult);
        System.out.println("16.0f / 0 = [float] " + floatingPointDivisionByZero);
        System.out.println("16.0 / 3 = [double] " + doubleDivisionResult);
        System.out.println("(double) 16 / 3 = [double] " + doubleDivisionResult2);
        System.out.println("(double) 16 / (double) 3 = [double] " + doubleDivisionResult3);
        /* Output:
        ----------------Floating-Point Division---------------
        16.0f / 3 = [float] 5.3333335
        16.0f / 0 = [float] Infinity
        16.0 / 3 = [double] 5.333333333333333
        (double) 16 / 3 = [double] 5.333333333333333
        (double) 16 / (double) 3 = [double] 5.333333333333333
         */

        // Modulus: Remainder of integer division
        // ============================================================================================================
        int modulusResult = 16 % 3;
        System.out.println("----------------Modulus---------------");
        System.out.println("16 % 3 = " + modulusResult);
        /* Output:
        ----------------Modulus---------------
        16 % 3 = 1
         */


        // Increment
        // ============================================================================================================
        System.out.println("----------------Increment---------------");

        int a = 1;
        a++;
        System.out.println(a);
        // Output: 2

        int b = 1;
        ++b;
        System.out.println(b);
        // Output: 2

        int x = 1;
        int y = x++; // y=x=1 --> x=2
        System.out.println(x + ", " + y);
        // Output: 2, 1

        int r = 1;
        int s = ++r; // r=2 --> s=r=2
        System.out.println(r + ", " + s);
        // Output: 2, 2

        // Decrement
        // ============================================================================================================

        // Augmented/Compound Assignment Operator
        // ============================================================================================================
        int c = 1;
        c = c +2; // c=3
        c += 2; // c=5
        System.out.println(c);
        // Output: 5


    }
}
