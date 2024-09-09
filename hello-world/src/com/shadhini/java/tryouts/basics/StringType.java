package com.shadhini.java.tryouts.basics;

/**
 * About Java String type.
 */
public class StringType {

    public static void main(String[] args) {
        String message = "Hello World!";
        System.out.println(message);

        // Concatenate/Join strings
        System.out.println("----------Concatenation------------");
        String part1 = "part1";
        String part2 = "part2";
        System.out.println(part1 + part2);

        // Ends With
        System.out.println("----------Ends With------------");
        System.out.println(message.endsWith("d!"));

        //Starts With
        System.out.println("----------Starts With------------");
        System.out.println(message.startsWith("d!"));

        // Length
        System.out.println("-----------Length-----------");
        System.out.println(message.length());

        // Index of the first occurrence of a character/substring
        System.out.println("-----------Index Of------------");
        System.out.println(message.indexOf("H"));
        System.out.println(message.indexOf("l"));
        System.out.println(message.indexOf("d!"));
        System.out.println(message.indexOf("z"));

        // Replace
        System.out.println("----------Replace------------");
        System.out.println(message.replace('l', '*'));

        // To lowercase
        System.out.println("-----------To Lowercase------------");
        System.out.println(message.toLowerCase());

        // To UPPERCASE
        System.out.println("-----------To Uppercase------------");
        System.out.println(message.toUpperCase());

        // Trim - can get rid of extra white spaces that are at the beginning or in the end
        System.out.println("-----------Trim------------");
        String userInput = "   butterfly ";
        System.out.println(userInput);
        System.out.println(userInput.trim());

        // Strings are immutable
        System.out.println("-----------Immutability------------");
        System.out.println(message);

    }

}
