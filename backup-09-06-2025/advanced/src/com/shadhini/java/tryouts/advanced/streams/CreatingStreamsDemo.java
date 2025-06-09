package com.shadhini.java.tryouts.advanced.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void show() {
        // Creating Finite Streams======================================================================================
        // Creating Streams: From Collections --------------------------------------------------------------------------
        Collection x = new ArrayList<String>();
        System.out.println(x.stream().count());

        var y = new ArrayList<String>();
        System.out.println(y.stream().count());

        // Creating Streams: From Arrays -------------------------------------------------------------------------------
        int[] array = {1, 2, 3, 4, 5};
        Arrays.stream(array)
                .forEach(System.out::print); // Output: 12345

        System.out.println();

        // Creating Streams: From arbitrary number of objects ----------------------------------------------------------
        Stream.of(1, 2, 3, 4, 5)
                .forEach(System.out::print); // Output: 12345

        System.out.println();

        // Creating Infinite Streams====================================================================================
        // Creating Infinite Streams: With Stream.generate() -----------------------------------------------------------
        System.out.println("===========Create Infinite Streams: With Stream.generator()==============================");
        var randomNumbersStream = Stream.generate(() -> Math.random() );
        // This will generate an infinite stream of random numbers

        randomNumbersStream
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        // Here `forEach()` method going to continuously request a new number from the randomNumbersStream and print it.
        // Then infinite number of random numbers will be generated and printed till the program is
        //      terminated by external party unless limit method is not used.
        // To prevent an infinite execution of this operation, we can use limit method.

        System.out.println();

        // Creating Infinite Streams: With Stream.iterate() ------------------------------------------------------------
        System.out.println("===========Create Infinite Streams: With Stream.iterator()===============================");
        Stream.iterate(1, i -> i + 1) // This generates an infinite stream
                .limit(10)
                .forEach(i -> System.out.print(i + " "));

    }
}
