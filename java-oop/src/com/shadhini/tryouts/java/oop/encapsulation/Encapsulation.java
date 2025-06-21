package com.shadhini.tryouts.java.oop.encapsulation;

/**
 * Demonstration of Encapsulation.
 */
public class Encapsulation {

    // Encapsulation class is dependent on the Employee class
    // Encapsulation class has 4 coupling points to the Employee class
    public static void demo() {
        var employee = new Employee(); // First coupling point
        // employee.setBaseSalary(-1); // Output: --> java.lang.IllegalArgumentException: Base salary cannot be 0 or less.
        employee.setBaseSalary(50_000);
        employee.setHourlyRate(20);
        int wage = employee.calculateWage(10);
        System.out.println(wage);
    }

}
