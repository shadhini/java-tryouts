package com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.method_injection;

public class MethodInjection {

    public static void demo() {
        // Poor man's Dependency Injection
        var calculator = new TaxCalculator2024(100_000);
        var report = new TaxReport();
        // Method Injection
        report.show(calculator); // Output: 30000.0
        report.show(new TaxCalculator2025()); // Output: 0.0
    }
}
