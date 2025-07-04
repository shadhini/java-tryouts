package com.shadhini.tryouts.java.basics;

import java.util.Scanner;

/**
 * Reading user input from terminal in Java.
 * [java.util.Scanner]
 */
public class ReadingInput {

    public static void demo() {

        Scanner scanner = new Scanner(System.in);
        /*
        System.out.print("Age: ");
        byte age = scanner.nextByte(); // This can parse only byte values
        System.out.println("You are " + age); // Implicit casting of age from byte to String
         */
        /*
        Input:
        23
        Output:
        You are 23

        Input:
        23.8
        Output:
        ==> java.util.InputMismatchException
         */

        /*
        System.out.print("How do you feel?: ");
        String input = scanner.next();
        System.out.println("Input: " + input);
         */
        /*
        Input:
        blah blah
        Output:
        blah

         */

        System.out.print("How was today?: ");
        String input2 = scanner.nextLine();
        System.out.println("Input: " + input2);
        /*
        Input:
        blah blah blah
        Output:
        blah blah blah

         */

        // Close the scanner to free up resources
        scanner.close();

    }
}
