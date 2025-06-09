package com.shadhini.java.tryouts.oop.interfaces.tightly_coupled;

public class TaxReport {

    private TaxCalculator calculator; // coupling point 1: Here we are dependent on the TaxCalculator class
    // If this class changes it affects the TaxReport class too

    public TaxReport() {
        calculator =  new TaxCalculator(100_000); // coupling point 2
        // Dependency Injection required...
    }

    public void show() {
        var tax = calculator.calculateTax(); // coupling point 3
        System.out.println(tax);
    }
}
