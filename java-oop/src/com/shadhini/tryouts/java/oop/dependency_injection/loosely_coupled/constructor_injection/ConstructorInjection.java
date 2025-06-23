package com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.constructor_injection;

public class ConstructorInjection {

    public static void demo() {
        // Poor man's Dependency Injection
        var calculator = new TaxCalculator2024(100_000);
        var report = new TaxReport(calculator); // Constructor Injection
        report.show();
    }
}
