---
description: >-
  partition data of a stream by a predicate with factory methods available in
  java.util.stream.Collectors class
icon: grid-dividers
---

# Partitioning Elements

## Partitioning Elements with Collectors

The `Collectors.partitioningBy` method in Java is a collector used with the Stream API to partition elements of a stream into two groups according to a given predicate. It returns a `Map<Boolean, List<T>>` (or a map with a downstream collector), where the keys are `true` and `false`:

* `true` key: Elements that satisfy the predicate.
* `false` key: Elements that do not satisfy the predicate

```java
// Basic usage: returns Collector<T, ?, Map<Boolean, List<T>>>
Collectors.partitioningBy(Predicate<? super T> predicate)

// With downstream collector: returns Collector<T, ?, Map<Boolean, D>>
Collectors.partitioningBy(Predicate<? super T> predicate, Collector<? super T, A, D> downstream)
```



***

<pre class="language-java"><code class="lang-java"><strong>import java.util.List;
</strong>import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10, Genre.ACTION),
                new Movie("b", 15, Genre.COMEDY),
                new Movie("c", 20, Genre.ACTION)
        );

        // partition movies by likes greater than 15 using partitioningBy collector
        var result = movies.stream()
                .collect(Collectors.partitioningBy(m -> m.getLikes() > 15));

        System.out.println(result);
        /* Output:
            {false=[Movie@464bee09, Movie@f6c48ac], true=[Movie@13deb50e]}
         */

        // partition movies by likes greater than 15 and collect their titles into a single string
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
}
</code></pre>





