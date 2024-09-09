package com.shadhini.java.tryouts.basics;

/**
 * About Escape ('\') sequences for including special characters.
 */
public class EscapeSequences {

    public static void main(String[] args) {

        // Double Quotes
        System.out.println("------------Double Quotes-------------");
        System.out.println("Hello \"Jane\"!");
        /* Output:
        ------------Double Quotes-------------
        Hello "Jane"!
         */

        // Backslash
        System.out.println("------------Backslash-------------");
        System.out.println("c:\\Windows\\...");
        /* Output:
        ------------Backslash-------------
        c:\Windows\...
         */

        // New Lines \n
        System.out.println("------------New lines-------------");
        System.out.println("Line1\nLine2\nLine3");
        /* Output:
        ------------New lines-------------
        Line1
        Line2
        Line3
         */

        // Tabs \t
        System.out.println("------------Tabs-------------");
        System.out.println("Tab1\tTab2\tTab3");
        /* Output:
        ------------Tabs-------------
        Tab1	Tab2	Tab3
         */


    }
}
