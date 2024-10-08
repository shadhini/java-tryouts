package com.shadhini.java.tryouts.basics;

/**
 * About declaring and initializing variables.
 */
public class Variables {
    public static void main(String[] args) {
        int age = 29; // initialize the variable
        // we are storing number 30 somewhere in computer's memory, and
        // we are assigning this label `age` to that memory location
        System.out.println(age);
        // Output: 29

        age = 35;
        System.out.println(age);
        // Output: 35

        int ageMom = 59, ageDad = 68;
        System.out.println(ageMom + " "  + ageDad);
        // Output: 59 68

        int myAge = 30;
        int myFriendAge = myAge;
        System.out.println(myFriendAge);
        // Output: 30
    }
}
