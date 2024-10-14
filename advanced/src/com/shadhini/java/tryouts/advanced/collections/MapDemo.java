package com.shadhini.java.tryouts.advanced.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
    public static void show() {
        List<Customer> customers = new ArrayList<>();
        var c1 = new Customer("Elizabeth", "b.elizabeth@gmail.com");
        var c2 = new Customer("John", "a.john@gmail.com");
        var c3 = new Customer("Charlie", "c.charlie@gmail.com");

        // Find customer with specific email -- O(n) time complexity ---------------------------------------------------
        for (var customer : customers)
            if (customer.getEmail() == "e1")
                System.out.println("Found!");

        // Hash Map -- O(1) time complexity for search =================================================================
        // Add key value paris to Hash Map -----------------------------------------------------------------------------
        Map<String, Customer> customerMap = new HashMap<>();
        customerMap.put(c1.getEmail(), c1);
        customerMap.put(c2.getEmail(), c2);
        customerMap.put(c3.getEmail(), c3);

        // Retrieve objects from Hash Map using key --------------------------------------------------------------------
        var customer1 = customerMap.get("b.elizabeth@gmail.com");
        System.out.println(customer1); // Output: Customer [name=Elizabeth]

        // Look for object that doesn't exist in the map ---------------------------------------------------------------
        var missingCustomer = customerMap.get("e1");
        System.out.println(missingCustomer); // Output: null

        // Set a default value if the object we are looking for doesn't exist in the map -------------------------------
        var unknownCustomer = new Customer("Unknown", "");
        var defaultCustomer = customerMap.getOrDefault("b", unknownCustomer);
        // Here, we are telling the map for object with key "b",
        //      and in case such an object doesn't exist, we are asking it to return the unknownCustomer object
        System.out.println(defaultCustomer); // Output: Customer [name=Unknown]

        // Check whether a specific key exists in the map --------------------------------------------------------------
        System.out.println(customerMap.containsKey("c")); // Output: false

        // Replace an object in a map ----------------------------------------------------------------------------------
        System.out.println(customerMap);
        // Output:
        // {c.charlie@gmail.com=Customer [name=Charlie],
        // b.elizabeth@gmail.com=Customer [name=Elizabeth],
        // a.john@gmail.com=Customer [name=John]}
        customerMap.replace("a.john@gmail.com", new Customer("a", "a@gmail.com"));
        System.out.println(customerMap);
        // Output:
        // {c.charlie@gmail.com=Customer [name=Charlie],
        // b.elizabeth@gmail.com=Customer [name=Elizabeth],
        // a.john@gmail.com=Customer [name=a]}     <---- replaced object

        // Go through the objects stored in a Map using keySet() -------------------------------------------------------
        System.out.println("====keySet()=============================================================================");
        for (var key: customerMap.keySet())
            System.out.println(customerMap.get(key));
        /* Output:
        Customer [name=Charlie]
        Customer [name=Elizabeth]
        Customer [name=a]
         */

        // Go through the objects stored in a Map using entrySet() -----------------------------------------------------
        System.out.println("====entrySet()===========================================================================");
        for (var entry: customerMap.entrySet()) {
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        /* Output:
        c.charlie@gmail.com=Customer [name=Charlie]
        c.charlie@gmail.com
        Customer [name=Charlie]
        b.elizabeth@gmail.com=Customer [name=Elizabeth]
        b.elizabeth@gmail.com
        Customer [name=Elizabeth]
        a.john@gmail.com=Customer [name=a]
        a.john@gmail.com
        Customer [name=a]
         */

        // Go through the objects stored in a Map using values() -------------------------------------------------------
        System.out.println("====values()=============================================================================");
        for (var customer: customerMap.values())
            System.out.println(customer);
        /* Output:
        Customer [name=Charlie]
        Customer [name=Elizabeth]
        Customer [name=a]
         */

    }
}
