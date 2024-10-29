package com.shadhini.java.tryouts.advanced.streams;

import java.util.List;

public class StreamsDemo {

    public  static void show() {
        // =============================================================================================================
        // Calculate # of movies that has more than 10 likes -----------------------------------------------------------
        List<Movie> movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Imperative Programming --------------------------------------------------------------------------------------
        int count = 0;
        for (var movie : movies)
            if (movie.getLikes() > 10)
                count++;
        System.out.println(count);

        // Declarative (Functional) Programming ------------------------------------------------------------------------
        var count2 = movies.stream()
                        .filter(movie -> movie.getLikes() > 10)
                        .count();
        System.out.println(count2);
        // Here only the movies that satisfies the criteria given in the filter predicate will be pulled out.
        // Here we don't have instructions that specify how something should be done,
        //      we are just expressing what needs to be done.
        // This makes our code cleaner and easier to read.


    }
}
