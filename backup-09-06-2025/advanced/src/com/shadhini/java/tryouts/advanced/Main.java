package com.shadhini.java.tryouts.advanced;

/*
import com.shadhini.java.tryouts.advanced.collections.CollectionDemo;
import com.shadhini.java.tryouts.advanced.collections.ListDemo;
import com.shadhini.java.tryouts.advanced.collections.MapDemo;
import com.shadhini.java.tryouts.advanced.collections.QueueDemo;
import com.shadhini.java.tryouts.advanced.collections.SetDemo;
import com.shadhini.java.tryouts.advanced.collections.SortingDemo;
import com.shadhini.java.tryouts.advanced.exceptions.ExceptionsDemo;
import com.shadhini.java.tryouts.advanced.generics.GenericList;
import com.shadhini.java.tryouts.advanced.generics.Instructor;
import com.shadhini.java.tryouts.advanced.generics.User;
import com.shadhini.java.tryouts.advanced.generics.Utils;
import com.shadhini.java.tryouts.advanced.lambdas.LambdasDemo;
import com.shadhini.java.tryouts.advanced.streams.StreamsDemo;
 */

import com.shadhini.java.tryouts.advanced.streams.CreatingStreamsDemo;
import com.shadhini.java.tryouts.advanced.streams.MappingElementsDemo;

public class Main {

    public static void main(String[] args) {



        // =============================================================================================================
        // Collections -------------------------------------------------------------------------------------------------

        // Collections: Iterables --------------------------------------------------------------------------------------
        /*
        var list = new GenericList<String>();
        list.add("A");
        list.add("B");
        /*
        var iterator = list.iterator();

        while (iterator.hasNext()) {
            var current = iterator.next();
            System.out.println(current);
        }

         */

        /*
        for (var item: list)
            System.out.println(item);

         */

        // Collections: Collection Interface ---------------------------------------------------------------------------
        // CollectionDemo.show();

        // Collections: List Interface ---------------------------------------------------------------------------------
        // ListDemo.show();

        // Collections: Comparable Interface & Sorting -----------------------------------------------------------------
        // SortingDemo.show();

        // Collections: Queue Interface --------------------------------------------------------------------------------
        // QueueDemo.show();

        // Collections: Set Interface ----------------------------------------------------------------------------------
        // SetDemo.show();

        // Collections: Map Interface & Hash Tables --------------------------------------------------------------------
        // MapDemo.show();

        // =============================================================================================================
        // Lambda Expressions and Functional Interfaces ----------------------------------------------------------------
        // LambdasDemo.show();

        // =============================================================================================================
        // Streams: Need for Streams -----------------------------------------------------------------------------------
        // StreamsDemo.show();

        // Streams: Creating Streams -----------------------------------------------------------------------------------
        CreatingStreamsDemo.show();

        // Streams: Mapping Elements -----------------------------------------------------------------------------------
        MappingElementsDemo.show();
    }
}
