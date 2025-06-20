package com.shadhini.java.helpers.read_input;

import java.util.Scanner;

public class ReadInputFromTerminal {

    public static void main(String[] args) {
        // Example usage of the readNextLineTillQuitStatement method
        readNextLineTillQuitStatement("exit");
    }

    /**
     * Reads input from the terminal until a specific quit statement is entered.
     *
     * @param quitStatement The statement that will terminate the input reading loop.
     */
    public static void readNextLineTillQuitStatement(String quitStatement) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Enter input (type '" + quitStatement + "' to quit):");
            input = scanner.nextLine();
            System.out.println("You entered: " + input);
        } while (!input.equalsIgnoreCase(quitStatement));

        System.out.println("Exiting...");
        scanner.close();
    }
}
