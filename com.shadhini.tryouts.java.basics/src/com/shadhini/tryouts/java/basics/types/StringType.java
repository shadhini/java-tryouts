package com.shadhini.tryouts.java.basics.types;

/**
 * Java String type.
 * [java.lang.String]
 */
public class StringType {

    public static void demo() {
        String message = "Hello World!";
        System.out.println(message);
        /*
        Output:
        Hello World!
         */

        // Concatenate/Join strings
        // =============================================================================================================
        System.out.println("----------Concatenation------------");
        String part1 = "part1";
        String part2 = "part2";
        System.out.println(part1 + part2);
        /* Output:
        ----------Concatenation------------
        part1part2
         */

        // Ends With
        // =============================================================================================================
        System.out.println("----------Ends With------------");
        System.out.println(message.endsWith("d!"));
        /* Output:
        ----------Ends With------------
        true
         */

        //Starts With
        // =============================================================================================================
        System.out.println("----------Starts With------------");
        System.out.println(message.startsWith("d!"));
        /* Output:
        ----------Starts With------------
        false
         */

        // Length
        // =============================================================================================================
        System.out.println("-----------Length-----------");
        System.out.println(message.length());
        /* Output:
        -----------Length-----------
        12
         */

        // Index of the first occurrence of a character/substring
        // =============================================================================================================
        System.out.println("-----------Index Of------------");
        System.out.println(message.indexOf("H"));
        System.out.println(message.indexOf("l"));
        System.out.println(message.indexOf("d!"));
        System.out.println(message.indexOf("z"));
        /* Output:
        -----------Index Of------------
        0
        2
        10
        -1
         */

        // Replace
        // =============================================================================================================
        System.out.println("----------Replace------------");
        System.out.println(message.replace('l', '*'));
        /* Output:
        ----------Replace------------
        He**o Wor*d!
         */

        // To lowercase
        // =============================================================================================================
        System.out.println("-----------To Lowercase------------");
        System.out.println(message.toLowerCase());
        /* Output:
        -----------To Lowercase------------
        hello world!
         */

        // To UPPERCASE
        // =============================================================================================================
        System.out.println("-----------To Uppercase------------");
        System.out.println(message.toUpperCase());
        /* Output:
        -----------To Uppercase------------
        HELLO WORLD!
         */

        // Trim - can get rid of extra white spaces that are at the beginning or in the end
        // =============================================================================================================
        System.out.println("-----------Trim------------");
        String userInput = "   butterfly ";
        System.out.println(userInput);
        System.out.println(userInput.trim());
        /* Output:
        -----------Trim------------
           butterfly
        butterfly
         */

        // Strings are immutable
        // =============================================================================================================
        System.out.println("-----------Immutability------------");
        System.out.println(message);
        /* Output:
        -----------Immutability------------
        Hello World!
         */

    }

}
