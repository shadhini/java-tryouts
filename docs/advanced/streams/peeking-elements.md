---
icon: eyes
---

# Peeking Elements

## Peeking Elements

> **java.util.stream.Stream\<T>** Interface
>
> **`.peek(consumer)`**
>
> * returns a stream, additionally performing the provided action on each element as elements are consumed from the resulting stream
> * an intermediate operation that can be used to peek elements in processing pipeline at each step as elements are consumed from each pipe

```java
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Peeking Elements in a Stream ------------------------------------------------------------------------------
        movies.stream()
                // pipe 1
                .peek(movie -> System.out.println("Peeked: " + movie.getTitle())) // peek at each movie
                .filter(movie -> movie.getLikes() > 10) // filter movies with likes greater than 10
                // pipe2: fitered
                .peek(movie -> System.out.println("Filtered: " + movie.getTitle())) // peek at filtered movies
                .map(movie -> movie.getTitle())
                // pipe3: mapped
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
}
```

Here in the output, for each element, we have same sequence of messages printed as the element passes through the pipeline.&#x20;

The very first message is printed at our first peek for the first element and it has been filtered out @ pipe2. Thus, there are no more messages for the first element.&#x20;

The second message is printed at pipe1 for the second element.  The 3rd message is printed at pipe2 after second element being filtered. The 4th is printed at pipe 3 after second element being mapped an so on...

So, with the `peek()` method, we can observe the output of each operation and this is useful for troubleshooting problems.



### `peek(consumer)` vs `forEach(consumer)` methods

`peek(consumer)` method is an intermediate operation that peek at elements performing the provided action in a processing pipeline as they flow through the stream pipeline.

while `forEach` method is a terminal operation that returns void.

<table><thead><tr><th width="146">aspect</th><th>peek(consumer)</th><th>forEach(consumer)</th></tr></thead><tbody><tr><td>operation type</td><td>intermediate</td><td>terminal; consumes the stream, cannot be chained</td></tr><tr><td>chaining</td><td>can chain further operations on stream</td><td>cannot chain further operations</td></tr><tr><td>typical use</td><td>debugging / inspecting elements as they flow through the stream pipeline <strong>without modifying</strong> them</td><td>final processing / action on elements of the stream</td></tr><tr><td>execution happens when</td><td>only when terminal operation called on the stream</td><td>executes immediately; immediately processes all elements in the steam</td></tr><tr><td>return value</td><td>Stream</td><td>void</td></tr></tbody></table>



