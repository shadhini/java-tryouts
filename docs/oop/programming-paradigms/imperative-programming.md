---
icon: person-chalkboard
---

# Imperative Programming

> **Implementing logic using instructions**
>
> ╰┈➤ We have statements that specify **`how`** something should be done

e.g:

* When **`for`** loops, **`if/else`** and **`switch/case`** statements are used, then the code is written in **Imperative Style**.

```java
List<Integer> list = List.of(1, 2, 3);

// Imperative Programming
for (var item : list)
    System.out.println(item);
```

```java
List<Movie> movies = List.of(
        new Movie("a", 10),
        new Movie("b", 15),
        new Movie("c", 20)
);

// Calculate # of movies that has more than 10 likes -----------------------------------------------------------

// Imperative programming
int count = 0;
for (var movie : movies)
    if (movie.getLikes() > 10)
        count++;
```

