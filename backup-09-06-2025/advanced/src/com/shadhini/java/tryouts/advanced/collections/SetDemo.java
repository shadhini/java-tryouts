package com.shadhini.java.tryouts.advanced.collections;

import java.util.*;

public class SetDemo {

    public static void show() {
        Set<String> set = new HashSet<>();
        Collections.addAll(set, "sky", "is", "blue", "blue");
        System.out.println(set); // Output: [sky, blue, is]

        // Remove duplicates of a collection ---------------------------------------------------------------------------
        Collection<String> collection = new ArrayList<>();
        Collections.addAll(collection, "A", "B", "C", "D", "D", "A");
        System.out.println(collection); // Output:[A, B, C, D, D, A]

        Set<String> hashSet = new HashSet<>(collection);
        System.out.println(hashSet); // Output: [A, B, C, D]

        // Create a Set using util methods in Arrays class -------------------------------------------------------------
        Set<String> set1 = new HashSet<>(Arrays.asList("P", "Q", "R"));
        Set<String> set2 = new HashSet<>(Arrays.asList("Q", "R", "S"));

        // Union operation: combination of 2 sets ----------------------------------------------------------------------
        set1.addAll(set2);
        System.out.println(set1); // Output: [P, Q, R, S]

        // Intersection: items that are common in both sets ------------------------------------------------------------
        Set<String> set3 = new HashSet<>(Arrays.asList("P", "Q", "R"));
        Set<String> set4 = new HashSet<>(Arrays.asList("Q", "R", "S"));
        set3.retainAll(set4); // remove every item that is not in set4 from set3
        System.out.println(set3); // Output: [Q, R]


        // Difference: what items we have in first set that do not have in second set ----------------------------------
        Set<String> set5 = new HashSet<>(Arrays.asList("P", "Q", "R"));
        Set<String> set6 = new HashSet<>(Arrays.asList("Q", "R", "S"));
        set5.removeAll(set6); // remove every item that is in set6 from set5
        System.out.println(set5); // Output: [P]

    }
}
