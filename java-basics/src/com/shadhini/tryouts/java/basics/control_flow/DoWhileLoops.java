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
            System.out.print("Input: ");
            userInput = scanner.next().toLowerCase();
            System.out.println(userInput);
        } while (!userInput.equals("quit"));
    }

}
