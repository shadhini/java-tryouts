package com.shadhini.tryouts.java.oop;

import com.shadhini.tryouts.java.oop.classes_n_objects.ClassesNObjects;
import com.shadhini.tryouts.java.oop.encapsulation.Encapsulation;
import com.shadhini.tryouts.java.oop.memory_management.MemoryManagement;

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

    }

}
