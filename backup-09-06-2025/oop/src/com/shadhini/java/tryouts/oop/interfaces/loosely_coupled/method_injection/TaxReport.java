package com.shadhini.java.tryouts.oop.interfaces.loosely_coupled.method_injection;

public class TaxReport {
    // ==> Programming against Interfaces
    // ==> Loose coupling

    private TaxCalculator calculator;

    public void show(TaxCalculator calculator) { // Method Injection
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

}
