---
description: >-
  group / classify data of a stream with factory methods available in
  java.util.stream.Collectors class
icon: people-group
---

# Grouping Elements

## Grouping Elements with Collectors

**`java.util.stream.Collectors`** class has factory methods to return a map that groups the stream elements by a classifier function.

<pre class="language-java"><code class="lang-java">// Basic: returns Collector&#x3C;T, ?, Map&#x3C;K, List&#x3C;T>>>
Collectors.groupingBy(Function&#x3C;? super T, ? extends K> classifier)

// With downstream collector: returns Collector&#x3C;T, ?, Map&#x3C;K, D>>
<strong>Collectors.groupingBy(Function&#x3C;? super T, ? extends K> classifier, Collector&#x3C;? super T, A, D> downstream)
</strong>
// With map supplier: returns Collector&#x3C;T, ?, M>
Collectors.groupingBy(Function&#x3C;? super T, ? extends K> classifier, Supplier&#x3C;M> mapFactory, Collector&#x3C;? super T, A, D> downstream)
</code></pre>



The _`groupingByConcurrent()`_ method variant of **`java.util.stream.Collectors`** class is designed for concurrent grouping (parallel streams).

```java
// Basic: returns Collector<T, ?, ConcurrentMap<K, List<T>>>
Collectors.groupingByConcurrent(Function<? super T, ? extends K> classifier)

// With downstream collector: returns Collector<T, ?, ConcurrentMap<K, D>>
Collectors.groupingByConcurrent(Function<? super T, ? extends K> classifier, Collector<? super T, A, D> downstream)

// With map supplier: returns Collector<T, ?, M>
Collectors.groupingByConcurrent(Function<? super T, ? extends K> classifier, Supplier<M> mapFactory, Collector<? super T, A, D> downstream)
```



***

```java
public enum Genre {
    COMEDY,
    ACTION,
    THRILLER,
}

public class Movie implements Comparable<Movie> {

    private String title;
    private int likes;
    private Genre genre;

    public Movie(String title, int likes, Genre genre) {
        this.title = title;
        this.likes = likes;
        this.genre = genre;
    }

    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.title);
    }

    public int getLikes() {
        return likes;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }
}

```

```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 15, Genre.COMEDY),
                new Movie("c", 20, Genre.ACTION)
        );

        // classify movies by genre using groupingBy collector ---------------------------------------------------------
        var groupedMovies = movies.stream()
                .collect(Collectors.groupingBy(Movie::getGenre));

        System.out.println(groupedMovies);
        /* Output:
            {COMEDY=[Movie@6d78f375], ACTION=[Movie@50c87b21, Movie@6d78f375]}
         */

        // classify movies by genre and collect them into a Set --------------------------------------------------------
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
        var groupedMovies3 = movies.stream()
                .collect(Collectors.groupingBy(
                        Movie::getGenre,
                        Collectors.counting() // count the number of movies in each genre
                ));

        System.out.println(groupedMovies3);
        // output: {COMEDY=1, ACTION=2}


        // classify movies by genre and collect their titles into a single string --------------------------------------
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
}
```



