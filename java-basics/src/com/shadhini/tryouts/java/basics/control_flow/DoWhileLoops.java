package com.shadhini.tryouts.java.basics.control_flow;

import java.util.Scanner;

/**
 * Java `do..while` loops.
 */
public class DoWhileLoops {

    public static void demo() {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.println("Type 'quit' to exit the loop. Type anything else to continue.");
            System.out.print("Input: ");

            // Defensive check: handle non-interactive environments where no input is available
            if (!scanner.hasNext()) {
                System.out.println("No input provided. Exiting loop.");
                break;
            }

            userInput = scanner.next().toLowerCase();
            System.out.println(userInput);
        } while (!userInput.equals("quit"));
        scanner.close();
    }

}
