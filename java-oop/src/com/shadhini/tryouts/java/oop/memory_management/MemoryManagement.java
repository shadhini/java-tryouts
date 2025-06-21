package com.shadhini.tryouts.java.oop.memory_management;

import com.shadhini.tryouts.java.oop.classes_n_objects.TextBox;

/**
 * Java Memory Management.
 * Memory allocation and de-allocation in Java;
 * how memory is allocated for reference types and primitives.
 */
public class MemoryManagement {

    public static void demo() {

        // Memory Allocation -------------------------------------------------------------------------------------------
        // =============================================================================================================
        var textBox1 = new TextBox();
        var textBox2 = textBox1;
        textBox2.setText("Hello World");
        System.out.println(textBox1.text); // Output: Hello World

        System.out.println(textBox2.toString().equals(textBox1.toString()));
        /* Output:
        true

        Explanation: bcz both textBox1 and textBox2 variables on the stack stores
        the memory location of the same TextBox object on the heap
         */
    }
    // Memory De-allocation --------------------------------------------------------------------------------------------
    // =================================================================================================================
    // After finish executing the main method,
    // both textBox1 and textBox2 variable on the stack would be immediately removed.
    // Now we are left with the only TextBox object on the heap.
    // But now, there will be no reference to the object on the heap.
    // The Java Garbage Collector will collect that object.
}
