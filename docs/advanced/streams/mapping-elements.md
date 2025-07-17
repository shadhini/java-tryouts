---
description: Mapping Elements with Streams
icon: function
---

# Mapping Elements

## Mapping Elements with Streams

> **java.util.stream.Stream\<T>** Interface
>
> * **`.map(`**&#x46;unction\<? super T,​? extends R>**`)`**
>   * primitive variations
>     * .**mapToDouble**​(ToDoubleFunction\<? super T>)
>     * .**mapToInt**​(ToIntFunction\<? super T>)
>     * .**mapToLong**​(ToLongFunction\<? super T>)
> * **`.flatMap(`**&#x46;unction\<? super T,​? extends Stream\<? extends R>>**)**
>   * primitive variations
>     * .**flatMapToDouble**​(Function\<? super T,​? extends DoubleStream>)
>     * .**flatMapToInt**​(Function\<? super T,​? extends IntStream>)
>     * .**flatMapToLong**​(Function\<? super T,​? extends LongStream>)



### **`.map(.....)`**

```java
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // Convert stream of movie objects to stream of movie title strings
        movies.stream()
                .map(Movie::getTitle) // now we have a stream of strings
                .forEach(System.out::println); // Output: a b c
                
        
        movies.stream()
                .mapToInt(movie -> movie.getLikes()) // ---- A
                .map(movie -> movie.getTitle()) // ---- B
                // Compile Error: Cannot resolve method 'getTitle()' in 'int'
                .forEach(System.out::println); 
              
    }
}
```



Here, the pipe @A,  converts the stream of movie objects in to a stream of integers which denotes number of likes for each movie and pass it to the next pipe.&#x20;

Thus, the pipe @B, doesn't receive a movie object, instead it receives an integer; number of likes. Since integers don't have a method named `.getTitle()`, we get the Compile Error @line B.



### **`.flatMap(.....)`**

```java
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamsDemo {

    public static void main(String[] args) {

        Stream.of(List.of(1,2,3), List.of(4,5,6)) // stream of list of integers
                .forEach(System.out::println);
        // Here, every item in the stream is a list of integers.
        /* Output:
            [1, 2, 3]
            [4, 5, 6]
         */

        // Flattening the stream of lists to a stream of integers
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
}
```





