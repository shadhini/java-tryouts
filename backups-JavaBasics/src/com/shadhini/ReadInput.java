package com.shadhini;

import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args) {
        // --------- Read User Input ---------------
        Scanner scanner = new Scanner(System.in);

        System.out.print("First Name: ");
        String name = scanner.next(); // If you type 2 names, this would store only one name.
        // bcz the words we type are called as tokens. every time we call next() method it reads one token
        // if there's 2 words separated by spae, to get the whole name, we need to all next() method 2 times

        // So to read whole line user enters, use nextLine() method
        System.out.print("Full Name: ");
        String fullName = scanner.nextLine().trim();
        System.out.println(fullName);

        System.out.print("Age: ");
        byte age = scanner.nextByte(); // this method can parse only byte values, can't read floating point numbers

        System.out.print("Weight: ");
        float weight = scanner.nextFloat();

        System.out.println("Hi "+ name);
        System.out.println("Your full name is " + fullName);
        System.out.println("You are " + age);
        System.out.println("Your weight is " + weight);
    }

}
