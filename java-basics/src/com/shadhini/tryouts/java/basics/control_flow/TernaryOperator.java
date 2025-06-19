package com.shadhini.tryouts.java.basics.control_flow;

/**
 * Ternary operator.
 */
public class TernaryOperator {

    public static void demo() {

        int income = 120_000;
        String className = (income > 100_000) ? "First" : "Economy";
        System.out.println(className);

    }
}
