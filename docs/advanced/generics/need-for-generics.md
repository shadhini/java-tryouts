---
icon: comment-check
---

# Need for Generics

```java
// Poor implementation
//List for intergers
public class List {
    private int[] items = new int[10];
    private int count;

    public void add(int item) {
        items[count++] = item;
    }

    public int get(int index) {
        return items[index];
    }
}

// List for Users
public class User {
    // attributes and getters setters
}

public class UserList {

    private User[] users = new User[100];
    private int count;

    // add methods to add and get items here too
}
```

╰┈➤ Creating lists for different types of objects this way is tedious and there going to be so much duplicated similar code.



## Poor Solution

```java
//List for all types
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
        list.add(1);
        list.add("2");
        list.add(new User()); 
        
        int value = (int) list.get(0);
    }
}
```

### Problems of this code

* Here, we have to explicitly cast every value returned by `get()` method. This makes code noisy.

```java
int value = (int) list.get(0);
```

* Also, since Object array stores all kinds of objects, if we cast the value returned by `get()` method to wrong type, then we will get invalid ClassCastException.
* We will not be aware about problem like this, until we run our application and test all the functions. We can only identify these problems at runtime.

> **It would be good if we can catch these issues at compile time -> That's what generics are for.**



## Why need Generics ?

When dealing with operations common to many types of objects, but not possible between 2 different types, we need to have means to catch issues at compile time rather than running into unexpected issues at runtime.

> **Ensure code that works with different types is&#x20;**<kbd>**type-safe**</kbd>**.**
>
> **Generics help catch errors at compile time by preventing operations between incompatible types, reducing unexpected issues at runtime.**



