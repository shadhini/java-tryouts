package com.shadhini.java.tryouts.oop.encapsulation;

public class Main {

    public static void main(String[] args) {
        var employee = new Employee();
        // employee.setBaseSalary(-1); // Output: --> java.lang.IllegalArgumentException: Base salary cannot be 0 or less.
        employee.setBaseSalary(50_000);
        employee.setHourlyRate(20);
        int wage = employee.calculateWage(10);
        System.out.println(wage);
    }

}
