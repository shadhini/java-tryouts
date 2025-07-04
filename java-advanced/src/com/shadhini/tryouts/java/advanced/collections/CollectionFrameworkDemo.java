package com.shadhini.tryouts.java.advanced.collections;

public class CollectionFrameworkDemo {

    public static void main(String[] args) {
        // Collections -------------------------------------------------------------------------------------------------
        // =============================================================================================================

        // 1. Collections: Iterables -----------------------------------------------------------------------------------
        System.out.println("1. Collections: Iterables ---------------------------------------------------------------");
        demo1Iterables();

        // 2. Collections: Collection Interface ------------------------------------------------------------------------
        System.out.println("2. Collections: Collection Interface ----------------------------------------------------");
        CollectionDemo.show();

        // 3. Collections: List Interface ------------------------------------------------------------------------------
        System.out.println("3. Collections: List Interface ----------------------------------------------------------");
        ListDemo.show();

        // 4. Sorting Elements in Collections --------------------------------------------------------------------------
        System.out.println("4. Sorting Elements in Collections ------------------------------------------------------");
        SortingDemo.show();

        // 5. Collections: Queue Interface -----------------------------------------------------------------------------
        System.out.println("5. Collections: Queue Interface ---------------------------------------------------------");
        QueueDemo.show();

        // 6. Collections: Set Interface -------------------------------------------------------------------------------
        System.out.println("6. Collections: Set Interface -----------------------------------------------------------");
        SetDemo.show();

        // 7. Collections: Map Interface & Hash Tables -----------------------------------------------------------------
        System.out.println("7. Collections: Map Interface & Hash Tables ---------------------------------------------");
        MapDemo.show();


    }

    // Demo on Iterables & Iterators
    // Based on ListIterator private class implementation in com.shadhini.tryouts.java.advanced.collections.GenericList
    public static void demo1Iterables() {
        var list = new GenericList<String>();
        list.add("A");
        list.add("B");

        System.out.println("Iterating over list with explicit Iterator object ---------------------------------------");
        // Iterating over list with explicit Iterator object
        var iterator = list.iterator();

        while (iterator.hasNext()) {
            var current = iterator.next();
            System.out.println(current);
        }

        System.out.println("Iterating over list with for-each loop --------------------------------------------------");
        // Iterating over list with for-each loop
        for (var item: list)
            System.out.println(item);
    }
}
