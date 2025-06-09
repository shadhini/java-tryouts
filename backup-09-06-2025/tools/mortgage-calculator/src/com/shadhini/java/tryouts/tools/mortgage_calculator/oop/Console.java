package com.shadhini.java.tryouts.tools.mortgage_calculator.oop;

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);
    // In console applications we have only one console.
    // So we keep all members as static as we don't need to create many objects.

    /**
     * Reads a number input from the terminal
     *
     * @param prompt prompt
     * @return user input as a double
     */
    public static double readNumber(String prompt) {
        return scanner.nextDouble();
    }

    /**
     * Reads a number input from the terminal
     *
     * @param prompt prompt
     * @param min    minimum value of the input
     * @param max    maximum value of the input
     * @return user input as a double
     */
    public static double readNumber(String prompt, double min, double max) {
        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between " + min + " and " + max + ".");
        }
        return value;
    }

}
