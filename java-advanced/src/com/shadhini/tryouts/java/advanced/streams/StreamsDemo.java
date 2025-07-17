package com.shadhini.tryouts.java.advanced.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {
        // Declarative vs Imperative Programming with Java Streams -----------------------------------------------------
        System.out.println("Declarative vs Imperative Programming with Java Streams ---------------------------------");
        demoDeclarativeVsImperativeProgramming();

        // Creating Finite Streams -------------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Creating Finite Streams -----------------------------------------------------------------");
        demo2CreatingFiniteStreams();

        // Creating Infinite Streams -----------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Creating Infinite Streams ---------------------------------------------------------------");
        demo3CreatingInfiniteStreams();

        // Mapping Elements with Streams -------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Mapping Elements with Streams -----------------------------------------------------------");
        demo4MappingElements();

        // Filtering Elements with Streams ----------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Filtering Elements with Streams ---------------------------------------------------------");
        demo5FilteringElements();

        // Slicing a Stream --------------------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Slicing a Stream ------------------------------------------------------------------------");
        demo6SlicingStream();

        // Sorting Streams ---------------------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Sorting Streams -------------------------------------------------------------------------");
        demo7SortingStreams();

        // Getting Unique Elements from a Stream -----------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Getting Unique Elements from a Stream ---------------------------------------------------");
        demo8GettingUniqueElements();

        // Peeking Elements in a Stream --------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Peeking Elements in a Stream ------------------------------------------------------------");
        demo9PeekingElements();

        // Simple Reducers ---------------------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Simple Reducers -------------------------------------------------------------------------");
        demo10SimpleReducers();

        // Reducing a Stream using General Purpose Reduction Operation -------------------------------------------------
        // =============================================================================================================
        System.out.println("Reducing a Stream using General Purpose Reduction Operation -----------------------------");
        demo11GeneralPurposeReductionOperation();

        // Collectors --------------------------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Collectors ------------------------------------------------------------------------------");
        demo12Collectors();

        // Collectors: Grouping Elements in a Stream -------------------------------------------------------------------
        System.out.println("Collectors: Grouping Elements in a Stream -----------------------------------------------");
        demo13GroupingElementsWithCollectors();

        // Collectors: Partitioning Elements in a Stream ---------------------------------------------------------------
        System.out.println("Collectors: Partitioning Elements in a Stream -------------------------------------------");
        demo14PartitioningElementsWithCollectors();
        
        // Primitive Type Streams --------------------------------------------------------------------------------------
        // =============================================================================================================
        System.out.println("Primitive Type Streams ------------------------------------------------------------------");
        demo15PrimitiveTypeStreams();

    }



    // Demonstrates the difference between declarative and imperative programming using Java Streams
    private  static void demoDeclarativeVsImperativeProgramming() {
        // Calculate # of movies that has more than 10 likes -----------------------------------------------------------
        // =============================================================================================================
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
        System.out.println(count); // Output: 2

        // Declarative (Functional) Programming ------------------------------------------------------------------------
        var count2 = movies.stream()
                        .filter(movie -> movie.getLikes() > 10)
                        .count();
        System.out.println(count2); // Output: 2
        // Here only the movies that satisfies the criteria given in the filter predicate will be pulled out.
        // Here we don't have instructions that specify how something should be done,
        //      we are just expressing what needs to be done.
        // This makes our code cleaner and easier to read.
    }

    // Demonstrates how to create finite streams from collections, arrays, and arbitrary number of objects
    private static void demo2CreatingFiniteStreams() {
        // Creating Streams: From Collections --------------------------------------------------------------------------
        System.out.println("============Creating Streams: From Collection============");
        Collection x = new ArrayList<String>();
        System.out.println(x.stream().count()); // Output: 0

        var y = new ArrayList<String>();
        System.out.println(y.stream().count()); // Output: 0


        // Creating Streams: From Arrays -------------------------------------------------------------------------------
        System.out.println("============Creating Streams: From Arrays============");
        int[] array = {1, 2, 3, 4, 5};
        Arrays.stream(array)
                .forEach(System.out::print); // Output: 12345

        System.out.println();

        // Creating Streams: From arbitrary number of objects ----------------------------------------------------------
        System.out.println("==========Creating Streams: From arbitrary number of objects==========");
        Stream.of(1, 2, 3, 4, 5)
                .forEach(System.out::print); // Output: 12345

        System.out.println();

    }

    // Demonstrates how to create infinite streams using Stream.generate() and Stream.iterate()
    private static void demo3CreatingInfiniteStreams() {
        // Creating Infinite Streams: With Stream.generate() -----------------------------------------------------------
        System.out.println("===========Create Infinite Streams: With Stream.generator()============");
        var randomNumbersStream = Stream.generate(() -> Math.random() );
        // This will generate an infinite stream of random numbers; but numbers will not be generated ahead of time.
        // The numbers will be generated only when requested.

        randomNumbersStream
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        // Here `forEach()` method going to continuously request a new number from the randomNumbersStream and print it.
        // Then infinite number of random numbers will be generated and printed till the program is
        //      terminated by external party unless limit method is not used.
        // To prevent an infinite execution of this operation, we can use limit method.

        System.out.println();

        // Creating Infinite Streams: With Stream.iterate() ------------------------------------------------------------
        System.out.println("===========Create Infinite Streams: With Stream.iterator()=======");
        Stream.iterate(1, i -> i + 1) // This generates an infinite stream
                .limit(10)
                .forEach(i -> System.out.print(i + " "));

        System.out.println();
    }

    // Demonstrates how to map elements in a stream to different types or flatten a stream of lists
    private static void demo4MappingElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Convert stream of movie objects to stream of movie title strings --------------------------------------------
        System.out.println("==========Convert stream of movie objects to stream of movie title strings==========");
        movies.stream()
                .map(Movie::getTitle) // now we have a stream of strings
                .forEach(System.out::println);
        /* Output:
            a
            b
            c
         */

        /*
        movies.stream()
                .mapToInt(movie -> movie.getLikes())
                // now we have a stream of integers; not a stream of Movie objects
                .map(movie -> movie.getTitle()) // Compile Error: Cannot resolve method 'getTitle()' in 'int'
                .forEach(System.out::println);
         */

        // Flattening a stream of lists  -------------------------------------------------------------------------------
        System.out.println("==========Flattening a stream of lists ==========");
        Stream.of(List.of(1,2,3), List.of(4,5,6)) // stream of list of integers
                .forEach(System.out::println);
        // Here, every item in the stream is a list of integers.
        /* Output:
            [1, 2, 3]
            [4, 5, 6]
         */

        // Flattening the stream of lists of integers to a stream of integers
        Stream.of(List.of(1,2,3), List.of(4,5,6)) // stream of list of integers
                .flatMap(Collection::stream) // convert each list to a stream of integers
                // now we have a stream of integers
                .forEach(System.out::println);
        /* Output:
            1
            2
            3
            4
            5
            6
         */

    }

    // Demonstrates how to filter elements in a stream based on a predicate
    private static void demo5FilteringElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Filtering Elements with Streams -----------------------------------------------------------------------------

        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10; // filter predicate

        movies.stream()
                .filter(isPopular) // filter movies with likes greater than 10
                // new pipe of popular movies
                .forEach(movie -> System.out.println(movie.getTitle())); // terminal operation
                // terminal operation -- returns a void, so no further operations can be chained

        // Here, the original collection of movies is not affected/modified.
    }

    // Demonstrates how to slice a stream using limit, skip, takeWhile, and dropWhile
    private static void demo6SlicingStream() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 25),
                new Movie("d", 20),
                new Movie("e", 18),
                new Movie("f", 35)
        );

        // Slicing a Stream: Limit -------------------------------------------------------------------------------------
        System.out.println("==========Slicing a Stream: Limit==========");
        movies.stream()
                .limit(2)
                .forEach(movie -> System.out.println(movie.getTitle()));

        /* Output:
            a
            b
         */

        // Slicing a Stream: Skip---------------------------------------------------------------------------------------
        System.out.println("==========Slicing a Stream: Skip==========");
        movies.stream()
                .skip(2) // skip the first 2 elements
                .forEach(movie -> System.out.println(movie.getTitle()));
        /* Output:
            c
            d
            e
            f
         */

        // Slicing a Stream: Take While --------------------------------------------------------------------------------
        System.out.println("==========Slicing a Stream: Take While==========");
        movies.stream()
                .takeWhile(movie -> movie.getLikes() < 25)
                // this pipe take elements from the previous pipe as long as the predicate is true
                .forEach(movie -> System.out.println(movie.getTitle()));
        /* Output:
            a
            b
         */

        // Slicing a Stream: Drop While --------------------------------------------------------------------------------
        System.out.println("==========Slicing a Stream: Drop While==========");
        movies.stream()
                .dropWhile(movie -> movie.getLikes() < 25)
                // this pipe take elements from the previous pipe as long as the predicate is true
                .forEach(movie -> System.out.println(movie.getTitle()));
        /* Output:
            c
            d
            e
            f
         */
    }

    // Demonstrates how to sort streams using Comparable and Comparator interfaces
    private static void demo7SortingStreams() {
        var movies = List.of(
                new Movie("c", 10),
                new Movie("b", 15),
                new Movie("d", 20),
                new Movie("A", 5)
        );

        // Sorting Streams with Comparable Interface -------------------------------------------------------------------
        System.out.println("==========Sorting Streams with Comparable Interface==========");
        movies.stream()
                .sorted() // Movie.compareTo() method will be used to sort the movies
                .forEach(movie -> System.out.println(movie.getTitle()));
        /* Output:
            A
            b
            c
            d
         */

        // Sorting Streams with Comparator Functional Interface --------------------------------------------------------
        System.out.println("==========Sorting Streams with Comparator Functional Interface==========");
        movies.stream()
                .sorted((m1, m2) -> m1.getLikes() - m2.getLikes())
                // sort by likes using Comparator functional interface
                .forEach(movie -> System.out.println(movie.getTitle()));
        /* Output:
            A
            c
            b
            d
         */

        // Simpler version of the above sorting with .comparing() factory method of Comparator interface
        System.out.println("Simpler version with .comparing() factory method of Comparator interface");
        movies.stream()
                .sorted(java.util.Comparator.comparing(m -> m.getLikes()))
                // sort by likes using Comparator.comparing() method
                .forEach(movie -> System.out.println(movie.getTitle()));

        // More readable version of the above sorting with method reference
        System.out.println("More readable version with method reference");
        movies.stream()
                .sorted(java.util.Comparator.comparingInt(Movie::getLikes))
                // sort by likes using method reference
                .forEach(movie -> System.out.println(movie.getTitle()));

        // Change the order of sorting by using reversed() method of Comparator interface
        System.out.println("Change the order of sorting by using reversed() method of Comparator interface");
        movies.stream()
                .sorted(java.util.Comparator.comparingInt(Movie::getLikes).reversed())
                // sort by likes in descending order using method reference
                .forEach(movie -> System.out.println(movie.getTitle()));
        /* Output:
            d
            b
            c
            A
         */
    }

    // Demonstrates how to get unique elements from a stream using distinct() method
    private static void demo8GettingUniqueElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20),
                new Movie("a", 10) // duplicate movie
        );

        // Getting Unique Elements from a Stream ----------------------------------------------------------------------
        System.out.println("==========Getting Unique Elements from a Stream==========");
        movies.stream()
                .map(Movie::getTitle) // convert stream of Movie objects to stream of movie titles
                .distinct() // filter out duplicates
                .forEach(System.out::println);
        /* Output:
            a
            b
            c
         */
    }

    // Demonstrates how to peek at elements in a stream without modifying them
    private static void demo9PeekingElements() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Peeking Elements in a Stream ------------------------------------------------------------------------------
        System.out.println("==========Peeking Elements in a Stream==========");
        movies.stream()
                .peek(movie -> System.out.println("Peeked: " + movie.getTitle())) // peek at each movie
                .filter(movie -> movie.getLikes() > 10) // filter movies with likes greater than 10
                .peek(movie -> System.out.println("Filtered: " + movie.getTitle())) // peek at filtered movies
                .map(movie -> movie.getTitle())
                .peek(m -> System.out.println("Mapped: " + m)) // peek at mapped titles
                .forEach(System.out::println); // terminal operation
        /* Output:
            Peeked: a
            Peeked: b
            Filtered: b
            Mapped: b
            b
            Peeked: c
            Filtered: c
            Mapped: c
            c
         */
    }

    // Demonstrates how to use simple reducers like anyMatch, allMatch, noneMatch, findFirst, findAny, max, and min
    private static void demo10SimpleReducers() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        var resultAnyMatch = movies.stream()
                .anyMatch(m-> m.getLikes() > 15);

        System.out.println("Any Match result: " + resultAnyMatch);
        // Output: Any Match result: true

        var resultAllMatch = movies.stream()
                .allMatch(m-> m.getLikes() > 15);

        System.out.println("All Match result: " + resultAllMatch);
        // Output: All Match result: false

        var resultNoneMatch = movies.stream()
                .noneMatch(m-> m.getLikes() > 15);

        System.out.println("None Match result: " + resultNoneMatch);
        // Output: None Match result: false

        var resultFindFirst = movies.stream()
                .findFirst() // returns the first element of the stream wrapped in an Optional
                .get(); // get() is used to retrieve the movie object from Optional

        System.out.println("Find First result: " + resultFindFirst.getTitle());
        // Output: Find First result: a

        movies.stream()
                .findAny() // returns any element of the stream wrapped in an Optional
                .ifPresent(m -> System.out.println("Find Any result: " + m.getTitle()));
        // ifPresent() is used to print the title of the movie if it exists
        // Output: Find Any result: a (or any other movie title, as it returns any element)


        var resultMax = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get(); // get() is used to retrieve the movie object from Optional

        System.out.println("Max result: " + resultMax.getTitle());
        // Output: Max result: c

    }

    // Demonstrates how to reduce a stream using general purpose reduction operation
    private static void demo11GeneralPurposeReductionOperation() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // [10, 15, 20]
        // [25, 20]
        // [45]

        // Reducing a Stream using General Purpose Reduction Operation -------------------------------------------------
        System.out.println("==========Reducing a Stream using General Purpose Reduction Operation===========");
        Optional<Integer> sum  = movies.stream()
                .map(m -> m.getLikes())
                .reduce((a, b) -> a + b);

        System.out.println("Sum of likes: " + sum.orElse(0)); // If the stream is empty, return 0

        // using method references
        // Integer class has a static method called sum() that takes two integers and returns their sum.
        Optional<Integer> sum2 = movies.stream()
                .map(Movie::getLikes)
                .reduce(Integer::sum);

        System.out.println("Sum of likes using method reference: " + sum2.orElse(0));

        // Call reduce() method with an identity value -----------------------------------------------------------------
        System.out.println("==========Call reduce() method with an identity value===========");
        Integer sum3 = movies.stream()
                .map(Movie::getLikes)
                .reduce(0, Integer::sum); // ----- A
        // Here, we are providing an identity value of 0; which is the initial value for the sum.

        System.out.println("Sum of likes using method reference with identity: " + sum3);
    }

    // Demonstrates how to use various collectors to collect results from a stream
    private static void demo12Collectors() {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Collecting to a List ----------------------------------------------------------------------------------------
        var resultList = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toList());

        System.out.println("==========Collecting to a List===========");
        System.out.println(resultList);

        // Collecting to a Map -----------------------------------------------------------------------------------------
        System.out.println("==========Collecting to a Map===========");
        // key (title) -> value (likes)
        // Collectors.toMap() method takes two functions as arguments: keyMapper and valueMapper
        var resultMap = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));

        System.out.println(resultMap);
        // Output: {b=15, c=20}

        var resultMap2 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toMap(
                        Movie::getTitle, // keyMapper
                        Function.identity() // valueMapper: returns the Movie object itself
                        // Function.identity() is a function that returns its input argument unchanged
                ));

        System.out.println(resultMap2);
        // Output: {b=Movie@6d78f375, c=Movie@50c87b21}

        // Summing to an Integer ---------------------------------------------------------------------------------------
        System.out.println("==========Summing likes to an Integer===========");

        var sum = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));
        // Collects the sum of likes of movies with likes greater than 10

        System.out.println(sum);

        // Summarizing likes -------------------------------------------------------------------------------------------
        System.out.println("==========Summarizing likes===========");
        var summary = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(summary);
        // Output: IntSummaryStatistics{count=2, sum=35, min=15, average=17.500000, max=20}

        // Joining values by a delimiter -------------------------------------------------------------------------------
        System.out.println("==========Joining values by a delimiter===========");

        var joinedTitles = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", ")); // Joining titles with a comma and space

        System.out.println(joinedTitles);
        // Output: b, c
    }

    // demonstrates how to group elements in a stream using Collectors
    private static void demo13GroupingElementsWithCollectors() {
        var movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 15, Genre.COMEDY),
                new Movie("c", 20, Genre.ACTION)
        );

        // classify movies by genre using groupingBy collector ---------------------------------------------------------
        System.out.println("==========classify movies by genre using groupingBy collector===========");
        var groupedMovies = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

        System.out.println(groupedMovies);
        /* Output:
            {COMEDY=[Movie@6d78f375], ACTION=[Movie@50c87b21, Movie@6d78f375]}
         */

        // classify movies by genre and collect them into a Set --------------------------------------------------------
        System.out.println("==========classify movies by genre and collect them into a Set===========");
        var groupedMovies2 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.toSet()
                ));

        System.out.println(groupedMovies2);
        /* Output:
            {COMEDY=[Movie@6d78f375], ACTION=[Movie@50c87b21, Movie@6d78f375]}
         */

        // classify movies by genre and count the number of movies in each genre ---------------------------------------
        System.out.println("==========classify movies by genre and count the number of movies in each genre===========");
        var groupedMovies3 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.counting() // count the number of movies in each genre
                ));

        System.out.println(groupedMovies3);
        // output: {COMEDY=1, ACTION=2}


        // classify movies by genre and collect their titles into a single string --------------------------------------
        System.out.println("=========classify movies by genre and collect their titles into a single string==========");
        var groupedMovies4 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.mapping(
                                Movie::getTitle, // map each movie to its title
                                Collectors.joining(", ") // collect titles into a single string
                        )
                ));

        System.out.println(groupedMovies4);
        // Output: {COMEDY=b, ACTION=a, c}

    }

    // Demonstrates how to partition elements in a stream using Collectors
    private static void demo14PartitioningElementsWithCollectors() {
        var movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 15, Genre.COMEDY),
                new Movie("c", 20, Genre.ACTION)
        );

        // partition movies by likes greater than 15 using partitioningBy collector
        System.out.println("========partition movies by likes greater than 15 using partitioningBy collector=========");
        var result = movies.stream()
                .collect(Collectors.partitioningBy(m -> m.getLikes() > 15));

        System.out.println(result);
        /* Output:
            {false=[Movie@464bee09, Movie@f6c48ac], true=[Movie@13deb50e]}
         */

        // partition movies by likes greater than 15 and collect their titles into a single string
        System.out.println("============partition movies and collect their titles into a single string============");
        var result2 = movies.stream()
                .collect(Collectors.partitioningBy(
                        m -> m.getLikes() > 15,
                        Collectors.mapping(Movie::getTitle, Collectors.joining(", "))
                ));
        System.out.println(result2);
        /* Output:
            {false=a, b, true=c}
         */

    }

    // Demonstrates how to create primitive type streams like IntStream, LongStream, and DoubleStream
    private static void demo15PrimitiveTypeStreams() {
        // IntStream ---------------------------------------------------------------------------------------------------
        // IntStream: of()
        System.out.println("==========IntStream: of()===========");
        IntStream.of(1,2,3)
                .forEach(m -> System.out.print(m + " ")); // Output: 1 2 3

        // IntStream: rangeClosed()
        System.out.println("\n==========IntStream: rangeClosed()===========");
        IntStream.rangeClosed(1, 5)
                .forEach(m -> System.out.print(m + " ")); // Output: 1 2 3 4 5

        // IntStream: range()
        System.out.println("\n==========IntStream: range()===========");
        IntStream.range(1, 5)
                .forEach(m -> System.out.print(m + " ")); // Output: 1 2 3 4

        System.out.println();

    }
}
