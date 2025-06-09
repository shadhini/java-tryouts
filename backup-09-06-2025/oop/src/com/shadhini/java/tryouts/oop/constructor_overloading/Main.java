package com.shadhini.java.tryouts.oop.constructor_overloading;

/**
 * Demonstration of Constructor overloading.
 */
public class Main {

    // In this situation, rather than using constructor overloading, creating Employee as in A is better.
    public static void main(String[] args) {
        var employee1 = new Employee(50_000, 0); // -- A
        var employee2 = new Employee(50_000);
        var wage = employee1.calculateWage(0);
        var wage2 = employee1.calculateWage(0);
        System.out.println(wage + " " + wage2);

    }
}
