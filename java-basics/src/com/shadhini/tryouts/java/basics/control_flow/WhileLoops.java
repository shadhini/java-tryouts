package com.shadhini.tryouts.java.basics.control_flow;

import java.util.Scanner;

/**
 * About Java `while` loops
 */
public class WhileLoops {

    public static void demo() {
        int i = 5;
        while (i > 0) {
            System.out.println(i);
            i--;
        }

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        while (!userInput.equals("quit")) {
            System.out.println("Type 'quit' to exit the loop. Type anything else to continue.");
            System.out.print("Input: ");
            // Scanner scanner = new Scanner(System.in);
            // with this, everytime we are going to create Scanner objects
            // if this executes 10 times, then there will be 10 Scanner objects in the memory.
            // Best practice: Declare and create Scanner object outside the loop, and reuse it inside the loop
            userInput = scanner.next().toLowerCase();
            System.out.println(userInput);
        }
        scanner.close();
    }
}
