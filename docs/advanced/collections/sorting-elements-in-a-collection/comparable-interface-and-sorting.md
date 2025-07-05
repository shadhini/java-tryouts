---
description: java.lang.Comparable<T> interface
icon: arrow-down-1-9
---

# Comparable Interface & Sorting

Lot of sorting algorithms work by comparing objects. So, to be able to compare objects, the class should implement `Comparable` interface.

```java
// Sorting Customers with Comparable Interface
public class Customer implements Comparable<Customer> {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Customer other) {
        // this < other  ---> negative value
        // this == other ---> 0
        // this > other  ---> positive value
        return name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + "]";
    }
}
```

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingDemo {

    public static void show() {
        // Sorting with Comparable Interface
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jane"));
        customers.add(new Customer("Alexander"));
        customers.add(new Customer("Bob"));
        System.out.println(customers); // Output: [Customer [name=Jane], Customer [name=Alexander], Customer [name=Bob]]
        Collections.sort(customers);
        System.out.println(customers); // Output: [Customer [name=Alexander], Customer [name=Bob], Customer [name=Jane]]

    }
}
```



### Limitation:

Here we sorted the `Customer`s based on the value of only one field. In case, you want to compare objects based on another field, you have to change the implemetation of `compareTo`() method.&#x20;

However with  `Comparator` interface, we can create multiple comparators for different fields.

