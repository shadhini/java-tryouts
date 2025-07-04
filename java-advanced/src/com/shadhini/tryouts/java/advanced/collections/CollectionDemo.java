package com.shadhini.tryouts.java.advanced.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CollectionDemo {

    public static void show() {
        Collection<String> collection = new ArrayList<>();

        // Adding elements to the collection ---------------------------------------------------------------------------
        System.out.println("Adding elements to the collection -------------------------------------------------------");
        collection.add("A");
        collection.add("B");
        collection.add("C");

        // Iterate over collection -------------------------------------------------------------------------------------
        System.out.println("Iterate over collection -----------------------------------------------------------------");
        for (String item : collection)
            System.out.println(item);
        /* Output:
            A
            B
            C
         */

        System.out.println(collection); // Output: [A, B, C]

        // Collections utility class method to add elements ------------------------------------------------------------
        System.out.println("Collections utility class method to add elements ----------------------------------------");
        Collections.addAll(collection, "D", "E", "F");
        System.out.println(collection); // Output: [A, B, C, D, E, F]


        // Size of the collection --------------------------------------------------------------------------------------
        System.out.println("Size of the collection ------------------------------------------------------------------");
        System.out.println(collection.size()); // Output: 6

        // Remove elements from the collection -------------------------------------------------------------------------
        System.out.println("Remove elements from the collection -----------------------------------------------------");
        collection.remove("D");
        System.out.println(collection); // Output: [A, B, C, E, F]

        // Check whether a specific element is present in the collection -----------------------------------------------
        System.out.println("Check whether a specific element is present in the collection ---------------------------");
        System.out.println(collection.contains("E")); // Output: true

        // Clear collection --------------------------------------------------------------------------------------------
        System.out.println("Clear collection ------------------------------------------------------------------------");
        collection.clear();
        System.out.println(collection); // Output: []

        // Check whether the collection is empty -----------------------------------------------------------------------
        System.out.println("Check whether the collection is empty ---------------------------------------------------");
        System.out.println(collection.isEmpty()); // Output: true

        // Convert collection to a regular array -----------------------------------------------------------------------
        System.out.println("Convert collection to a regular array ---------------------------------------------------");
        Collections.addAll(collection, "A", "B", "C", "D", "E", "F");
        System.out.println(collection);

        var objectArray = collection.toArray();
        // In this case, every element in the array is an instance of the Object class.
        System.out.println(objectArray.length); // Output: 6

        var stringArray = collection.toArray(new String[0]);
        System.out.println(stringArray.length + " " + stringArray[1].toLowerCase()); // Output: 6 b
        // Here, the elements will be stored in a String array.
        // If you pass 0 as the array size (an empty array),
        //      the toArray() method will create an array with enough space for all elements in the collection.
        // If you pass a specific size, a pre-sized array will be created to hold the elements.

        // Compare collections for equality ----------------------------------------------------------------------------
        System.out.println("Compare collections for equality --------------------------------------------------------");
        Collection<String> otherCollection = new ArrayList<>();
        otherCollection.addAll(collection);

        System.out.println(collection == otherCollection); // Output: false
        // Because collection and otherCollection are 2 different objects in the memory;
        //      so their references are different.

        System.out.println(collection.equals(otherCollection)); // Output: true
        // Because content of both collections are same

    }
}
