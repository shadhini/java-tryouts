package com.shadhini.tryouts.java.oop;

import com.shadhini.tryouts.java.oop.abstraction_n_coupling.AbstractionNCoupling;
import com.shadhini.tryouts.java.oop.classes_n_objects.ClassesNObjects;
import com.shadhini.tryouts.java.oop.constructor_overloading.ConstructorOverloading;
import com.shadhini.tryouts.java.oop.constructors.Constructors;
import com.shadhini.tryouts.java.oop.encapsulation.Encapsulation;
import com.shadhini.tryouts.java.oop.inheritance.InheritanceDemo;
import com.shadhini.tryouts.java.oop.memory_management.MemoryManagement;
import com.shadhini.tryouts.java.oop.method_overloading.MethodOverloading;
import com.shadhini.tryouts.java.oop.static_members.StaticMembers;

/**
 * Main class for Java OOP tryouts.
 * This class serves as an entry point for the OOP examples.
 */
public class Main {

    public static void main(String[] args) {

        // 1. Classes and Objects --------------------------------------------------------------------------------------
        System.out.println("1. Classes and Objects ------------------------------------------------------------------");
        ClassesNObjects.demo();

        // 2. Memory Management ----------------------------------------------------------------------------------------
        System.out.println("2. Memory Management --------------------------------------------------------------------");
        MemoryManagement.demo();

        // 3. Encapsulation --------------------------------------------------------------------------------------------
        System.out.println("3. Encapsulation ------------------------------------------------------------------------");
        Encapsulation.demo();

        // 4. Abstraction and Coupling ---------------------------------------------------------------------------------
        System.out.println("4. Abstraction and Coupling -------------------------------------------------------------");
        AbstractionNCoupling.demo();

        // 5. Constructors ---------------------------------------------------------------------------------------------
        System.out.println("5. Constructors -------------------------------------------------------------------------");
        Constructors.demo();

        // 6. Method Overloading ---------------------------------------------------------------------------------------
        System.out.println("6. Method Overloading -------------------------------------------------------------------");
        MethodOverloading.demo();

        // 7. Constructor Overloading ----------------------------------------------------------------------------------
        System.out.println("7. Constructor Overloading --------------------------------------------------------------");
        ConstructorOverloading.demo();

        // 8. Static Members -------------------------------------------------------------------------------------------
        System.out.println("8. Static Members -----------------------------------------------------------------------");
        StaticMembers.demo();

        // 9. Inheritance ----------------------------------------------------------------------------------------------
        System.out.println("9. Inheritance --------------------------------------------------------------------------");
        InheritanceDemo.demo();
    }

}
