package com.shadhini.java.tryouts.oop.method_overloading;

/**
 * Employee class
 */
public class Employee {

    private int baseSalary;
    private int hourlyRate;

    public Employee(int baseSalary, int hourlyRate) {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
    }

    public int calculateWage(int extraHours) {
        return baseSalary + hourlyRate * extraHours;
    }

    public int calculateWage() {
        return calculateWage(0);
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
