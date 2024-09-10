package com.shadhini.java.tryouts.basics;

import java.util.Scanner;

/**
 * About reading user input from terminal in Java.
 * [java.util.Scanner]
 */
public class ReadingInput {

    public static void main(String[] args) {

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

    }
}
