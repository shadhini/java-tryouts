---
icon: square-plus
---

# Creating Streams

We can generate infinite/finite streams.

## Create finite streams

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void main(String[] args) {
        // Creating Streams: From Collections --------------------------------------------------------------------------
        Collection x = new ArrayList<String>();
        System.out.println(x.stream().count());

        var y = new ArrayList<String>();
        System.out.println(y.stream().count());

        // Creating Streams: From Arrays -------------------------------------------------------------------------------
        int[] array = {1, 2, 3, 4, 5};
        Arrays.stream(array)
                .forEach(System.out::print); // Output: 12345

        System.out.println();

        // Creating Streams: From arbitrary number of objects ----------------------------------------------------------
        Stream.of(1, 2, 3, 4, 5)
                .forEach(System.out::print); // Output: 12345

        System.out.println();

    }
}
```

### From collections

* Every class that implements the **`Collection`** interface has `stream()` method, i.e they have the ability to return a `Stream`.

### From arrays

* Arrays don't have the `stream()` method.&#x20;
* But we have **`Arrays`** utility class in the `java.util` package and there we have a static method called `stream()` to which we can pass an array and get a `Stream`.

### From an arbitrary number of objects&#x20;

* `java.util.stream.Stream` class has a static factory method called **`of`** and it has `var args` parameter; so we can pass as many arguments (objects) as you want.

## Generate infinite streams

We can also generate infinite streams; there're 2 ways.

### Using **`Stream.generate(Supplier .......)` method of** `java.util.stream` package

* Here we should pass a `Supplier` to the `generate()` method.
* And it will generate infinite stream according to the `Supplier` we provide.
* This is not something we can do with `Collection`s.
  * Because if we want to store an infinite number of objects in a collection, we are gonna run out of memory.
* But with streams, the `Supplier` function is gonna get called, every time we read a number from this stream.
* So these objects in this infinite stream created with `Stream.generate()`  method are not gonna generated ahead of time.
  * ╰┈➤ We call this **`Lazy Evaluation`**.



```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void main(String[] args) {
    
        // Creating Infinite Streams: With Stream.generator() -------------------------------------------------
        var randomNumbersStream = Stream.generate(() -> Math.random());
        // This will generate an infinite stream of random numbers

        randomNumbersStream
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        // Here `forEach()` method going to 
        //     continuously request a new number from the randomNumbersStream 
        //     and print it till it hits the limit.
        
    }
}
```

&#x20;

### Using **`Stream.iterate(Object seed ,`**` ``UnaryOperator .....`**`)` method of**  `java.util.stream` package

* `Stream.iterate()` method has 2 parameters;
  * `Object seed` -> an initial value
  * `UnaryOperator`  -> used to modify the initial value

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void main(String[] args) {
    
        // Creating Infinite Streams: With Stream.iterate() ------------------------------------------------------------
        Stream.iterate(1, i -> i + 1) // This generates an infinite stream
                .limit(10)
                .forEach(i -> System.out.print(i + " "));
        
    }
}
```

## How we work with streams

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void main(String[] args) {
    
        // 1. Start off with creating a stream
        var randomNumbersStream = Stream.generate(() -> Math.random());

        randomNumbersStream
        // 2. Apply one or more transformations on that stream
                .limit(10)
        // 3. Finally, we call an operation that actually terminates that stream
                .forEach(i -> System.out.print(i + " "));
        
    }
}
```

&#x20;



