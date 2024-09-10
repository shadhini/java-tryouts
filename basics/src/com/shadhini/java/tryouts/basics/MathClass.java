package com.shadhini.java.tryouts.basics;

/**
 * About functionalities of [java.lang.Math] class
 */
public class MathClass {

    public static void main(String[] args) {

        // Round
        // ===========================================================================================================

        int roundResult1 = Math.round(1.4f);
        System.out.println(roundResult1); // Output: 1

        int roundResult2 = Math.round(1.6f);
        System.out.println(roundResult2); // Output: 2

        int roundResult3 = Math.round(1.5f);
        System.out.println(roundResult3); // Output: 2

        // Ceil
        // ===========================================================================================================
        double ceilResult1 = Math.ceil(1.5);
        System.out.println(ceilResult1); // Output: 2.0

        double ceilResult2 = Math.ceil(1.1);
        System.out.println(ceilResult2); // Output: 2.0

        // Floor
        // ===========================================================================================================
        double floorResult1 = Math.floor(1.5);
        System.out.println(floorResult1); // Output: 1.0

        double floorResult2 = Math.floor(1.91);
        System.out.println(floorResult2); // Output: 1.0

        // Max
        // ===========================================================================================================
        int max = Math.max(-234, 98);
        System.out.println(max); // Output: 98

        // Min
        // ===========================================================================================================
        int min = Math.min(234, 98);
        System.out.println(min); // Output: 98

        // Random
        // ===========================================================================================================
        double random = Math.random();
        // number between 0 and 1
        System.out.println(random); // Sample Output: 0.5800665117987516 [changes every time]

        // random whole number between 0 and 100
        System.out.println(Math.round(Math.random()*100)); // Sample Output: 41 [changes every time]

        int random2 = (int) Math.random() * 100;
        System.out.println(random2); // Output: 0 [always]

        int random3 = (int) (Math.random() * 100);
        System.out.println(random3); // Sample Output: 56 [changes every time]


    }
}
