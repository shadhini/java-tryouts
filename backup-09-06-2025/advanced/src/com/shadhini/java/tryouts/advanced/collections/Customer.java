package com.shadhini.java.tryouts.advanced.collections;

public class Customer implements Comparable<Customer> {
    private String name;
    private String email;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
