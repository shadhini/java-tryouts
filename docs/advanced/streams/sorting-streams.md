---
icon: arrow-down-1-9
---

# Sorting Streams

## Sorting Streams

> **Default Order:**
>
> — Order of the elements in the stream is as same as the order of elements in the data source.
>
>
>
> **java.util.stream.Stream\<T>** Interface
>
> * **.sorted()** --> require the class of the collection/array elements to implement the `Comparable<T>` interface
> * **.sorted​(comparator)** --> should pass a `Comparator<T>` to be used for sorting as the argument&#x20;
>   * since Comparator interface is also a functional interface, the Comparator function can be passed as a lambda expressions to this method
>   * <kbd>Simpler Version</kbd>: using Comparator.comparing() factory method with method reference on the filed you want to use for the sorting



```java
public class Movie implements Comparable<Movie> {

    private String title;
    private int likes;

    public Movie(String title, int likes) {
        this.title = title;
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.title);
    }
}
```



```java
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("c", 10),
                new Movie("b", 15),
                new Movie("d", 20),
                new Movie("A", 5)
        );

        // Sorting Streams with Comparable Interface -------------------------------------------------------------------
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
        movies.stream()
                .sorted(java.util.Comparator.comparing(m -> m.getLikes()))
                // sort by likes using Comparator.comparing() method
                .forEach(movie -> System.out.println(movie.getTitle()));

        // More readable version of the above sorting with method reference
        movies.stream()
                .sorted(java.util.Comparator.comparingInt(Movie::getLikes))
                // sort by likes using method reference
                .forEach(movie -> System.out.println(movie.getTitle()));

        // Change the order of sorting by using reversed() method of Comparator interface
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
}
```



