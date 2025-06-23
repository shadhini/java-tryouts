package com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.method_injection;

public class TaxReport {
    // ==> Programming against Interfaces
    // ==> Loose coupling

    private TaxCalculator calculator;

    public void show(TaxCalculator calculator) { // Method Injection
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

}
