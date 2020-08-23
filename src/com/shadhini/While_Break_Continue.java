package com.shadhini;

import java.util.Scanner;

public class While_Break_Continue {

    public static void main(String[] args) {

        String input = "";
        Scanner scanner = new Scanner(System.in);

        while (!input.equals("quit")){
            System.out.println("Input: ");
            input = scanner.next();
            System.out.println(input);
        }

        while (true){
            System.out.println("Input: ");
            input = scanner.next();
            if (input.equals("pass"))
                continue;
            if (input.equals("quit"))
                break; // terminate the loop
            System.out.println(input);
        }
    }
}
