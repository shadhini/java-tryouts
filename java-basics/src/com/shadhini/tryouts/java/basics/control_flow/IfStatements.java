package com.shadhini.tryouts.java.basics.control_flow;

/**
 * If statements.
 */
public class IfStatements {

    public static void demo() {
        int temperature = 32;
        if (temperature > 30) { // First clause
            System.out.println("It's a hot day!");
            System.out.println("Drink water.");
        } // took else if to next line to align keywords of all 3 clauses
        else if (temperature>20)  // Second clause: temperature>20 && temperature <= 30
            System.out.println("Beautiful Day!");
        else // // Third clause: temperature<=20
            System.out.println("Cold day!");

        // Is income greater than 100,000? High income or not?
        // =============================================================================================================
        int income = 120_000;
        boolean hasHighIncome = (income > 100_000); // Simplified condition

        // Original condition
//        if (income > 100_000) {
//            hasHighIncome = true;
//        }

    }
}
