package com.shadhini.java.tryouts.basics;

/**
 * About creating methods.
 */
public class CreatingMethods {

    public static void main(String[] args) {
        System.out.println(greetUser("Patrick", "Jane"));
        System.out.println(greetUser("Teressa", "Lisbon"));

    }

    public static String greetUser(String firstName, String lastName) {
        return "Hello " + firstName + " " + lastName + "!";
    }
}
