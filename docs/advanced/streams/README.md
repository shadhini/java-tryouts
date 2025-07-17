---
icon: wind
---

# Streams

## Streams

> **allows us to process a collection of data in a declarative/functional way**; clear and concise way
>
> — like SQL query
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
> * **`filter`**`(predicate)`: used to filter data in stream of collection based on a given Predicate
> * **`count`**`():` counts number of elements in the stream&#x20;
> * **`forEach`**`(consumer)`: used to iterate over the stream and consume each object according to the Consumer lambda expression
> * **`limit`**`(n)`: limit number of times values generated from an infinite stream
> * `distinct()`: retrieve unique elements from the stream
> * `peek(consumer)`: an intermediate operation that can be used to peek a processing pipeline; returns a stream, additionally performing the provided action on each element as elements are consumed from the resulting stream



Every `collection` in Java, has a method called **`stream()`** and this returns a stream of objects.



ℹ️ **`Functional`** programming is special type of `declarative` programming; but it brings some additional concepts.

E.g: kind of like how you write SQL queries.



## Metaphor for Stream: **`Water Tank`**

* The actual water is inside the tank.
* But we have bunch of pipes to get the water out of the tank.
* The **`Collection`** is like the **water tank**; that is where we store some data.
* The **`Stream`** is like the **pipe**; we attach one pipe after another as we can build a pipeline to transform data and get it out of the collection.



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
        
        movies.stream()
                .filter(movie -> movie.getLikes() > 10) // filtering -- intermediate operation
                // new pipe of movies with more than 10 likes
                .forEach(movie -> System.out.println(movie.getTitle())); // terminal operation
                // terminal operation -- returns a void, so no further operations can be chained

    }
}
```



### Stream Method Categories

<table><thead><tr><th valign="top">Intermediate methods</th><th valign="top">Terminal methods</th><th valign="top">Reducers</th></tr></thead><tbody><tr><td valign="top">intermediate operations</td><td valign="top">terminal operations</td><td valign="top">terminal operations</td></tr><tr><td valign="top"><p>return a new stream; a new pipe</p><ul><li>you can continue <strong>transforming</strong> that pipe to get the data we want</li></ul></td><td valign="top"><p>methods that start consuming values</p><ul><li>if you don't call a terminal operation, nothing is done</li></ul></td><td valign="top">Operations that reduce a stream of objects to a single object</td></tr><tr><td valign="top"><p>e.g:</p><ul><li>map(function&#x3C;T,R>) / flatMap(function&#x3C;T,Stream&#x3C;R>>)</li><li>filter(predicate)</li><li>limit(n)</li><li>skip(n)</li><li>takeWhile(predicate) / dropWhile(predicate)</li><li>sorted() / sorted(comparator)</li><li>distinct()</li><li>peek(consumer)</li></ul></td><td valign="top"><p>e.g:</p><ul><li>forEach(consumer)</li></ul><p></p></td><td valign="top"><p>Simple Reducers</p><p>e.g:</p><ul><li>count()</li></ul><ul><li>anyMatch(predicate)</li><li>allMatch(predicate)</li><li>noneMatch(predicate) </li><li>findFirst()</li><li>findAny()</li><li>max(comparator)</li><li>min(comparator)</li></ul><p>Generic Reducer</p><ul><li>reduce(binaryOperator)</li><li>reduce(identity, binaryOperator)</li><li>reduce(identity, biFunction accumulator, binaryOperator combiner)</li></ul></td></tr></tbody></table>





***



{% content-ref url="creating-streams.md" %}
[creating-streams.md](creating-streams.md)
{% endcontent-ref %}

{% content-ref url="mapping-elements.md" %}
[mapping-elements.md](mapping-elements.md)
{% endcontent-ref %}

{% content-ref url="filtering-elements.md" %}
[filtering-elements.md](filtering-elements.md)
{% endcontent-ref %}

{% content-ref url="slicing-a-stream.md" %}
[slicing-a-stream.md](slicing-a-stream.md)
{% endcontent-ref %}

{% content-ref url="sorting-streams.md" %}
[sorting-streams.md](sorting-streams.md)
{% endcontent-ref %}

{% content-ref url="peeking-elements.md" %}
[peeking-elements.md](peeking-elements.md)
{% endcontent-ref %}

{% content-ref url="reducers-and-reducing-a-stream.md" %}
[reducers-and-reducing-a-stream.md](reducers-and-reducing-a-stream.md)
{% endcontent-ref %}

{% content-ref url="collectors/" %}
[collectors](collectors/)
{% endcontent-ref %}

{% content-ref url="primitive-type-streams.md" %}
[primitive-type-streams.md](primitive-type-streams.md)
{% endcontent-ref %}





