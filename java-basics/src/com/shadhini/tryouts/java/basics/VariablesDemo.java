package com.shadhini.tryouts.java.basics;

/**
 * About declaring and initializing variables.
 */
public class VariablesDemo {
    public static void demo() {
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

        // `var` keyword: Type Inference
        // =============================================================================================================
        var a = new TextBox();
        System.out.println(a.toString());
        // Output: com.shadhini.tryouts.java.basics.TextBox@<hashcode>

    }
}
