package com.shadhini.java.tryouts.advanced.streams;

import java.util.List;

public class MappingElementsDemo {

    public static void show() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        movies.stream()
                .map(movie -> movie.getTitle())
                .forEach(System.out::println);
    }
}
