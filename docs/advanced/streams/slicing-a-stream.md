---
icon: pizza
---

# Slicing a Stream

## Slicing a Stream

> **java.util.stream.Stream\<T>** Interface
>
> * **limit(n)** — limit number of elements in the stream
> * **skip(n)** — skip number of elements in a stream
> * **takeWhile(predicate)** — pass a predicate and say keep taking elements from this stream as long as this condition/predicate is true; iteration over the stream stops the moment this predicate returns false
> * **dropWhile(predicate)** —  skip all the elements that match the criteria given in the predicate and then take the rest
>
> **limit(n)** and **skip(n)** methods are useful for pagination



```java
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 25),
                new Movie("d", 20),
                new Movie("e", 18),
                new Movie("f", 35)
        );

        // Slicing a Stream: Limit -------------------------------------------------------------------------------------
        movies.stream()
                .limit(2)
                .forEach(movie -> System.out.println(movie.getTitle()));

        /* Output:
            a
            b
         */

        // Slicing a Stream: Skip---------------------------------------------------------------------------------------
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
        movies.stream()
                .takeWhile(movie -> movie.getLikes() < 25)
                // this pipe take elements from the previous pipe as long as the predicate is true
                .forEach(movie -> System.out.println(movie.getTitle()));
        /* Output:
            a
            b
         */

        // Slicing a Stream: Drop While --------------------------------------------------------------------------------
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
}
```



#### takeWhile(predicate) vs filter(predicate)

`filter(predicate)` method iterates the entire data source to find objects that match our criteria.

whereas the `takeWhile(predicate)` method stops the moment this predicate returns false.



