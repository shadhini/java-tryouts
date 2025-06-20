package com.shadhini.tryouts.java.basics.control_flow;

/**
 * Java `for each` loops.
 */
public class ForEachLoops {

    public static void demo() {
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};

        for (String fruit : fruits)
            System.out.println(fruit);

        // print in reverse order
        for (int i = fruits.length; i>0; i--)
            System.out.println(fruits[i-1]);
    }
}
