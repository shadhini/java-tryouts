package com.shadhini.tryouts.java.basics;

/**
 * Java casting and type conversion.
 */
public class CastingNTypeConversion {

    public static void demo() {

        // Implicit Casting
        // =============================================================================================================
        // byte -> short -> int -> long -> float -> double
        short x = 1;
        int y = x + 2;
        System.out.println(y); // Output: 3

        double r = 1.1;
        double s = r + 2;
        System.out.println(s); // Output: 3.1


        // Explicit Casting
        // =============================================================================================================
        int t = (int) r + 2; // Without explicit casting, you get a CastException here
        System.out.println(t); // Output: 3

        String a = "1";
        int b = Integer.parseInt(a) + 2;
        System.out.println(b); // Output: 3

        String c = "1.1";
        // int d = Integer.parseInt(c) + 2; // Output: java.lang.NumberFormatException
        // System.out.println(d);
        double e = Double.parseDouble(c) + 2;
        System.out.println(e); // Output: 3.1

    }
}
