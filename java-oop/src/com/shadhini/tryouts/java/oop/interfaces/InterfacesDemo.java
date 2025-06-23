package com.shadhini.tryouts.java.oop.interfaces;

import com.shadhini.tryouts.java.oop.interfaces.fields.InterfaceFields;
import com.shadhini.tryouts.java.oop.interfaces.interface_segregation.InterfaceSegregation;
import com.shadhini.tryouts.java.oop.interfaces.new_features.TaxCalculator;
import com.shadhini.tryouts.java.oop.interfaces.new_features.better_implementation.TaxCalculator2024;

/**
 * Demonstrates the use of interfaces in Java.
 */
public class InterfacesDemo {

    public static void demo() {
        // Interface Segregation Principle (ISP)
        // =============================================================================================================
        System.out.println("Interface Segregation Principle (ISP) ---------------------------------------------------");
        InterfaceSegregation.demo();

        // Fields in Interfaces: [not recommended to use]
        // =============================================================================================================
        System.out.println("Fields in Interfaces: [not recommended to use] ------------------------------------------");
        InterfaceFields.demo();

        // New Features in Interfaces: Static/Default/Private Methods[not recommended to use]
        // =============================================================================================================
        System.out.println("New Features in Interfaces: Static/Default/Private Methods [not recommended to use] -----");
        // Implementation with new features [not recommended]
        System.out.println(TaxCalculator.getTaxableIncome(100_000, 20_000));
        // Better implementation
        var taxCalculator2024 = new TaxCalculator2024(100_000);
        System.out.println(taxCalculator2024.calculateTax());

    }
}
