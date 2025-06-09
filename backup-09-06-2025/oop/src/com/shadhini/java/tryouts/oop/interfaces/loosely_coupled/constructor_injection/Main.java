package com.shadhini.java.tryouts.oop.interfaces.loosely_coupled.constructor_injection;

public class Main {

    public static void main(String[] args) {
        // Poor man's Dependency Injection
        var calculator = new TaxCalculator2024(100_000);
        var report = new TaxReport(calculator); // Constructor Injection
        report.show();
    }
}
