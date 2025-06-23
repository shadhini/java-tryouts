package com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.constructor_injection;

public class TaxReport {
    // Here TaxReport talk to the interface; not to a concrete implementation -> no coupling
    // Tax Report doesn't know anything about the concrete implementation
    // ==> Programming against Interfaces

    // Even if implementation of method in TaxCalculator2024 class changes,
    // this class (i.e. TaxReport) doesn't need to be recompiled. Since this doesn't depend on it.
    // ==> Loose coupling

    private TaxCalculator calculator;


    public TaxReport(TaxCalculator calculator) { // Constructor Injection
        this.calculator = calculator;
    }

    public void show() {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }
}
