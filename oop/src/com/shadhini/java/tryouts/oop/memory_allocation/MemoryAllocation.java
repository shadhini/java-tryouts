package com.shadhini.java.tryouts.oop.memory_allocation;

import com.shadhini.java.tryouts.oop.classes_n_objects.TextBox;

/**
 * About memory allocation and de-allocation in Java; how memory is allocated for reference types and primitives.
 */
public class MemoryAllocation {

    public static void main(String[] args) {

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
    // After finish executing the main method,
    // both textBox1 and textBox2 variable on the stack would be immediately removed.
    // Now we are left with the only TextBox object on the heap.
    // But now, there will be no reference to the object on the heap.
    // The Java Garbage Collector will collect that object.
}
