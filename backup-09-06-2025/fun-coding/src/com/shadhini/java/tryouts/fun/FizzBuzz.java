package com.shadhini.java.tryouts.fun;

import java.util.Scanner;

/**
 * Fizz Buzz
 * Input: a number
 * Prompt:
 *      Number:
 * Output:
 *      If number is divisible by 5 --> "Fizz"
 *      If number is divisible by 3 --> "Buzz"
 *      If number is divisible by both 5 and 3 --> "FizzBuzz"
 *      If number is not divisible by both 5 or 3 --> number printed on the terminal
 */
public class FizzBuzz {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Number: ");
        int number = scanner.nextInt();

        // Programming is all about trade-offs.
        fizzBuzzMoreReadable(number);
        fizzBuzzNoRepetition(number);

    }

    /**
     * Fizz Buzz with no repetition
     * @param number: Input number: integer
     */
    public static void fizzBuzzNoRepetition(int number) {
        // No repetition, but nested if else statements make the code more confusing/complicated for the reader
        if (number % 5 == 0)
            if (number % 3 == 0)
                System.out.println("FizzBuzz");
            else
                System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);
    }

    /**
     * More readable Fizz Buzz, but with little repetition
     * @param number: Input number: integer
     */
    public static void fizzBuzzMoreReadable(int number) {
        // This is more readable bcz of flat structure
        // however repeated evaluations are present, which is regarded as not a good practice
        // In coding we don't repeat
        if (number % 5 == 0 && number % 3 == 0) // the most specific conditions comes to top
            System.out.println("FizzBuzz");
        else if (number % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number); // the most generic conditions goes to bottom
    }
}
