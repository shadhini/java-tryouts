package com.shadhini.java.tryouts.basics;

/**
 * About If statements:
 */
public class IfStatements {

    public static void main(String[] args) {
        int temperature = 32;
        if (temperature > 30) { // First clause
            System.out.println("It's a hot day!");
            System.out.println("Drink water.");
        } // took else if to next line to align keywords of all 3 clauses
        else if (temperature>20)  // Second clause: temperature>20 && temperature <= 30
            System.out.println("Beautiful Day!");
        else // // Third clause: temperature<=20
            System.out.println("Cold day!");

        int income = 120_000;
        boolean hasHighIncome = (income > 100_000);

//        if (income > 100_000) {
//            hasHighIncome = true;
//        }

    }
}
