package com.shadhini.java.tryouts.advanced.collections;

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

        // Sorting with Comparator Interface
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Elizabeth", "b.elizabeth@gmail.com"));
        customerList.add(new Customer("John", "a.john@gmail.com"));
        customerList.add(new Customer("Charlie", "c.charlie@gmail.com"));

        System.out.println(customerList); // Output: [Customer [name=Elizabeth], Customer [name=John], Customer [name=Charlie]]

        // Sorting based on name
        Collections.sort(customerList, new NameComparator());
        System.out.println(customerList); // Output: [Customer [name=Charlie], Customer [name=Elizabeth], Customer [name=John]]

        // Sorting based on email
        Collections.sort(customerList, new EmailComparator());
        System.out.println(customerList); // Output: [Customer [name=John], Customer [name=Elizabeth], Customer [name=Charlie]]

    }
}
