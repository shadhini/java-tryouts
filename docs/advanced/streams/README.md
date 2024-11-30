---
icon: wind
---

# Streams

> **allows us to process a collection of data in a declarative/functional way**; clear and concise way
>
>
>
> Stream is a **`sequence of objects`**; but it's not like a collection; it doesn't store data;&#x20;
>
> ╰┈➤ it's just a **way to get data out of the collection**.
>
>
>
> **Stream** object has bunch of methods:
>
> * **`filter`**`(Predicate ..........)`: used to filter data in stream based on a given Predicate
> * **`count`**`():` counts number of elements in the stream&#x20;
> * **`forEach`**`(Consumer .........)`: used to iterate over the stream and get each object
> * **`limit`**`(int)`: limit number of times values generated from an infinite stream



Every `collection` in Java, has a method called **`stream()`** and this returns a stream of objects.





ℹ️ **`Functional`** programming is special type of `declarative` programming; but it brings some additional concepts.

E.g: kind of like how you write SQL queries.



## Metaphor: **`Water Tank`**

* The actual water is inside the tank.
* But we have bunch of pipes to get the water out of the tank.
* The **`Collection`** is like the **water tank**; that is where we store some data.
* The **`Stream`** is like the **pipe**; we attach one pipe after another as we can build a pipeline to transform data and get it out of the collections.



## `Stream` object methods

```java
public class StreamsDemo {
    public static void main(String[] args) {
        // Declarative (Functional) Programming ----------------------------------------
        var count2 = movies.stream()
                        .filter(movie -> movie.getLikes() > 10)
                        .count();
        System.out.println(count2);
        // Here only the movies that satisfies the criteria 
        //      given in the filter predicate will be pulled out and counted.
        // Here we don't have instructions that specify how something should be done,
        //      we are just expressing what needs to be done.
        // This makes our code cleaner and easier to read.

    }
}
```

***



{% content-ref url="creating-streams.md" %}
[creating-streams.md](creating-streams.md)
{% endcontent-ref %}

