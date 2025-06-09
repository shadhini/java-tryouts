package com.shadhini.java.tryouts.basics;

import java.util.Scanner;

/**
 * About Java `do..while` loops.
 */
public class DoWhileLoops {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        do {
            System.out.print("Input: ");
            userInput = scanner.next().toLowerCase();
            System.out.println(userInput);
        } while (!userInput.equals("quit"));
    }

}
