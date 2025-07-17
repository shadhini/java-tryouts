---
description: java.util.stream.Collector<T, A, R>, java.util.stream.Collectors
icon: album-collection-circle-plus
---

# Collectors

## Collectors

> **Collectors**:
>
> Collect the result of a stream into a data structure like a list / set / map and so on ..
>
> _java.util.stream.Stream\<T> Interface_
>
> * **`.collect​(collector)`**
> * **`.collect(supplier, biConsumer accumulator, biConsumer combiner)`**

Here, the interface that represents the _`collector`_ object of _`.collect​(collector)`_ method is **`java.util.stream.Collector<T, A, R>`** interface.&#x20;

It has several different implementations. We have collectors for converting a stream into&#x20;

* a list,&#x20;
* a set,&#x20;
* a map,
* and so on..



**`java.util.stream.Collectors`** class has many factory methods to return `Collector` instances that convert a stream into a data structure.

```java
// collect the resulting stream into a List
Collectors.toList() 

// collect the resulting stream into a Set
Collectors.toSet()

// collect the resulting stream into a HashMap
Collectors.toMap()
```



**`java.util.stream.Collectors`** class also has methods to collect the sum of the values resulting from a  `ToIntFunction` / `ToDoubleFunction` and `ToLongFunction`.

```java
// collects the sum of the values of toIntFunction
Collectors.summingInt(toIntFunction)

// collects the sum of the values of toDoubleFunction
Collectors.summingDouble(toDoubleFunction)

// collects the sum of the values of toLongFunction
Collectors.summingLong(toLongFunction)
```



Also **`java.util.stream.Collectors`** class has methods to give statistics about the values in the stream resulting from a  `ToIntFunction` / `ToDoubleFunction` and `ToLongFunction`.

```java
// gives statistics about the values in the stream resulting from a toIntFunction
Collectors.summarizingInt(toIntFunction)

// gives statistics about the values in the stream resulting from a toDoubleFunction
Collectors.summarizingDouble(toDoubleFunction)

// gives statistics about the values in the stream resulting from a toLongFunction
Collectors.summarizingLong(toLongFunction)
```



Moreover, **`Collectors.joining(delimiter)`** method of **`java.util.stream.Collectors`** class allows to join/concatenate a stream of strings by a provided delimiter.

```java
Collectors.joining(delimiter)
```



***

```java
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Collecting to a List ----------------------------------------------------------------------------------------
        var resultList = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.toList());

        System.out.println(resultList);
        // Output: [Movie@6d78f375, Movie@50c87b21]


        // Collecting to a Map -----------------------------------------------------------------------------------------
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

        var sum = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summingInt(Movie::getLikes));
        // Collects the sum of likes of movies with likes greater than 10

        System.out.println(sum);

        // Summarizing likes -------------------------------------------------------------------------------------------
        var summary = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .collect(Collectors.summarizingInt(Movie::getLikes));

        System.out.println(summary);
        // Output: IntSummaryStatistics{count=2, sum=35, min=15, average=17.500000, max=20}

        // Joining values by a delimiter -------------------------------------------------------------------------------

        var joinedTitles = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .map(Movie::getTitle)
                .collect(Collectors.joining(", ")); // Joining titles with a comma and space

        System.out.println(joinedTitles);
        // Output: b, c
    }
}
```



## Grouping Elements

{% content-ref url="grouping-elements.md" %}
[grouping-elements.md](grouping-elements.md)
{% endcontent-ref %}



## Partitioning Elements

{% content-ref url="partitioning-elements.md" %}
[partitioning-elements.md](partitioning-elements.md)
{% endcontent-ref %}



