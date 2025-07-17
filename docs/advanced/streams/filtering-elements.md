---
description: Filtering Elements with Streams
icon: filter
---

# Filtering Elements

## Filtering Elements with Streams

> **java.util.stream.Stream\<T>** Interface
>
> * **`.filter​(predicate``)`**



```java
import java.util.List; 
import java.util.function.Predicate;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );
        
        // filter predicate
        Predicate<Movie> isPopular = movie -> movie.getLikes() > 10; 

        movies.stream()
                .filter(isPopular) // filter movies with likes greater than 10
                // new pipe of popular movies
                .forEach(movie -> System.out.println(movie.getTitle())); 

    }
}
```

Here, the original collection of movies is not affected/modified.



