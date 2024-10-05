package com.shadhini.java.tryouts.oop.interfaces.loosely_coupled.setter_injection;

public class TaxReport {
    // ==> Programming against Interfaces
    // ==> Loose coupling

    private TaxCalculator calculator;


    public TaxReport(TaxCalculator calculator) { // Constructor Injection
        this.calculator = calculator;
    }

    public void show() {
        var tax = calculator.calculateTax();
        System.out.println(tax);
    }

    public void setCalculator(TaxCalculator calculator) { // Setter Injection
        this.calculator = calculator;
    }
}
