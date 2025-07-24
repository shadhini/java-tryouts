package com.shadhini.tryouts.java.basics;

public class FloatingPointTypesDemo {

    public static void demo() {
        // Floating-point Operations -----------------------------------------------------------------------------------
        double a = 8;
        double b = 5;
        double c = a / b + 1.1;
        System.out.println(c); // Output: 2.7

        // Floating-point types with a mantissa ------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Floating-point types with a mantissa ----------------------------------------------------");
        double eps = 5e-3; // means 5 * 10^(-3) = 0.005
        double n = 0.01e2; // means 0.01 * 10^2 = 1.0
        System.out.println(eps); // Output: 0.005
        System.out.println(n); // Output: 1.0


        // Errors during computations with floating-point types --------------------------------------------------------
        // =============================================================================================================
        System.out.println("Errors during computations with floating-point types ------------------------------------");

        System.out.println(3.3 / 3); // prints 1.0999999999999999

        double d = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1;
        System.out.println(d); // prints 0.9999999999999999



    }
}
