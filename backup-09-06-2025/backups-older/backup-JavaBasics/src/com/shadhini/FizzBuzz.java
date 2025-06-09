package com.shadhini;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        if ((num % 3 == 0) && (num % 5 == 0))
            System.out.println("FizzBuzz");
        else if (num % 3 == 0)
            System.out.println("Fizz");
        else if (num % 5 == 0)
            System.out.println("Buzz");
        else
            System.out.println(num);

    }
}
