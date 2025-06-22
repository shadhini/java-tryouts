package com.shadhini.tryouts.java.oop.method_overloading;

/**
 * Demonstration of Method overloading.
 */
public class MethodOverloading {

    // In this scenario not using method overloading and just passing 0 as in A is better
    public static void demo() {
        var employee = new Employee(50_000, 20);
        var wage = employee.calculateWage(0); // -- A
        var wage2 = employee.calculateWage();
        System.out.println(wage + " " + wage2);

    }
}
