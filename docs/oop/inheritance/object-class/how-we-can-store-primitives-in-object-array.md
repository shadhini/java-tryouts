---
icon: comment-question
---

# How we can store primitives in Object array

```java
// This is a very poor implementation of List
public class List {
    private Object[] items = new Object[10];
    private int count;

    public void add(Object item) {
        items[count++] = item;
    }

    public Object get(int index) {
        return items[index];
    }
}

public class User {
    // attributes and getters setters
}

public class Main {

    public static void main(String[] args) {
        var list = new List();
        list.add(1); // -----A
        list.add("2");
        list.add(new User()); 
    }
}
```

All the reference types are inherited by the `Object` class; However @ A, we are sending a primitive (an int) to be stored at `Object` array. How can it be stored ?

* When this code is compiled `Java Compiler` turns this line to something as follows.

```java
list.add(Integer.valueOf(1));
```

Here, the `Integer` class in Java is a reference type and it is derived from `Object` class. The static method `.valueOf` of `Integer` class, returns a new instance of the `Integer` class.&#x20;

Similarly we have `a`` `**`wrapper class`** for every primitive type in Java .

-> That's why we can pass primitive value to this `list.add()` method which accepts objects of `Object` type.



