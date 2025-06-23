package com.shadhini.tryouts.java.oop.dependency_injection;

import com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.constructor_injection.ConstructorInjection;
import com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.method_injection.MethodInjection;
import com.shadhini.tryouts.java.oop.dependency_injection.loosely_coupled.setter_injection.SetterInjection;
import com.shadhini.tryouts.java.oop.dependency_injection.tightly_coupled.TightlyCoupledCodeDemo;

public class DependencyInjectionDemo {

    public static void demo() {
        // Tightly coupled code example
        // =============================================================================================================
        System.out.println("Tightly Coupled Code ------------------------------------------------------------");
        TightlyCoupledCodeDemo.demo();

        // =============================================================================================================
        // Loosely coupled code
        // =============================================================================================================
        System.out.println("Loosely Coupled Code ------------------------------------------------------------");

        // Constructor Injection
        // =============================================================================================================
        System.out.println("Constructor Injection -----------------------------------------------------------");
        ConstructorInjection.demo();

        // Setter Injection
        // =============================================================================================================
        System.out.println("Setter Injection ----------------------------------------------------------------");
        SetterInjection.demo();

        // Method Injection
        // =============================================================================================================
        System.out.println("Method Injection ----------------------------------------------------------------");
        MethodInjection.demo();
    }
}
