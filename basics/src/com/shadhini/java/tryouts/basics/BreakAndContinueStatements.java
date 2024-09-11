package com.shadhini.java.tryouts.basics;

import java.util.Scanner;

/**
 * About Java `break` and `continue` statements.
 */
public class BreakAndContinueStatements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput = "";

        /*
        while (!userInput.equals("quit")) {
            System.out.print("Input: ");
            userInput = scanner.next().toLowerCase();
            if (!userInput.equals("quit"))
                System.out.println(userInput);
        }

         */

        while (true) {
            System.out.print("Input: ");
            userInput = scanner.next().toLowerCase();
            if (userInput.equals("pass"))
                continue;
            if (userInput.equals("quit"))
                break;
            System.out.println(userInput);
        }
        /* Sample Output:
        Input: 2
        2
        Input: pass
        Input: 3
        3
        Input: pass
        Input: pass
        Input: 4
        4
        Input: 5
        5
        Input: quit
         */


    }
}
