package com.shadhini.java.tryouts.advanced.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListDemo {

    public static void show() {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "A", "B", "C");
        System.out.println(list); // Output: [A, B, C]

        // Add values at a particular index ----------------------------------------------------------------------------
        list.add(1,"D");
        System.out.println(list); // Output: [A, D, B, C]

        // Retrieve an object by index ---------------------------------------------------------------------------------
        System.out.println(list.get(3)); // Output: C

        // Replacing an object at a given index ------------------------------------------------------------------------
        list.set(0,"A+");
        System.out.println(list); // Output: [A+, D, B, C]

        // Remove an object by an index --------------------------------------------------------------------------------
        list.remove(1);
        System.out.println(list); // Output: [A+, B, C]

        // Find the index of the first occurrence of an element --------------------------------------------------------
        System.out.println(list.indexOf("C")); // Output: 2
        System.out.println(list.indexOf("D")); // Output: -1 // "D" doesn't exist in the list

        // Find the index of the last occurrence of an object ----------------------------------------------------------
        list.add("B");
        System.out.println(list); // Output: [A+, B, C, B]
        System.out.println(list.lastIndexOf("B")); // Output: 3

        // Create a sublist --------------------------------------------------------------------------------------------
        // Here "from" is inclusive, "to" is exclusive
        // And original list won't be affected, as this method returns a new list
        System.out.println(list.subList(0,2)); // Output: [A+, B]
    }
}
