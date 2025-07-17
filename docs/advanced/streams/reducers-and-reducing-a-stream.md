---
description: >-
  Simple Reducers & Reducing a Stream to a single value using general purpose
  reduction operation
icon: forward-fast
---

# Reducers & Reducing a Stream

## Simple Reducers

> **Simple** **Reducers**:
>
> Operations that reduce a stream of objects to a single object.
>
> All of these operations are **terminal operations**.
>
> _**java.util.stream.Stream\<T>** Interface_
>
> * count()
> * anyMatch(predicate)
> * allMatch(predicate)
> * noneMatch(predicate)&#x20;
> * findFirst(): Returns an Optional describing the first element of this stream, or an empty Optional if the stream is empty.
> * findAny(): Returns an Optional describing some element of the stream, or an empty Optional if the stream is empty.
> * max(comparator)
> * min(comparator)

```java

import java.util.Comparator;
import java.util.List;

public class StreamsDemo {

    public static void main(String[] args) {
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
        // Output: Find Any result: a

        var resultMax = movies.stream()
                .max(Comparator.comparing(Movie::getLikes))
                .get(); // get() is used to retrieve the movie object from Optional

        System.out.println("Max result: " + resultMax.getTitle());
        // Output: Max result: c
    }
}
```





## Reducing a Stream to a single value using General Purpose Reduction Operation

> **General Purpose Reduction Operation:**
>
> _java.util.stream.Stream\<T> Interface_
>
> * **`.reduce(binaryOperator)`**
> * **`.reduce(identity, binaryOperator)`**
> * **`.reduce(identity, biFunction accumulator, binaryOperator combiner)`**
>
> identity --> initial value



```java
import java.util.List;
import java.util.Optional;

public class StreamsDemo {

    public static void main(String[] args) {
        var movies = List.of(
                new Movie("a", 10),
                new Movie("b", 15),
                new Movie("c", 20)
        );

        // [10, 15, 20]
        // [25, 20]
        // [45]

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
        Integer sum3 = movies.stream()
                .map(Movie::getLikes)
                .reduce(0, Integer::sum); // ----- A
        // Here, we are providing an identity value of 0; which is the initial value for the sum.

        System.out.println("Sum of likes using method reference with identity: " + sum3);
    }
}
```



Here, @A we are providing an initial value for the `reduce()` operation, which is an Integer of value 0. Therefore, even if the stream doesn't have any elements or it has strings, this `reduce()` operation will return the initial value which is an Integer. Thus, when calling reduce method with an identity value, it won't return an `Optional`.



