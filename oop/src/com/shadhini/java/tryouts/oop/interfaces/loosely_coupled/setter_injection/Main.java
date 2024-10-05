package com.shadhini.java.tryouts.oop.interfaces.loosely_coupled.setter_injection;

public class Main {

    public static void main(String[] args) {
        // Poor man's Dependency Injection
        var calculator = new TaxCalculator2024(100_000);
        var report = new TaxReport(calculator); // Constructor Injection
        report.show(); // Output: 30000.0

        report.setCalculator(new TaxCalculator2025()); // Setter Injection
        report.show(); // Output: 0.0
    }
}
