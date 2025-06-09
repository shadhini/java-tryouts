package com.shadhini.java.tryouts.oop.static_members;

/**
 * Employee class
 */
public class Employee {

    private int baseSalary;
    private int hourlyRate;

    // Static Field
    public static int numberOfEmployees;

    public Employee(int baseSalary) {
        this(baseSalary, 0);
    }

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++; // Every time we create an employee object, this number should be incremented.
    }

    // Static Method
    public static void printNumberOfEmployees() {
        System.out.println("Number of employees: " + numberOfEmployees);
    }

    public int calculateWage(int extraHours) {
        return baseSalary + hourlyRate * extraHours;
    }

    public void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary cannot be 0 or less.");
        }
        this.baseSalary = baseSalary;
    }

    public void setHourlyRate(int hourlyRate) {
        if (hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less.");
        }
        this.hourlyRate = hourlyRate;
    }
}
