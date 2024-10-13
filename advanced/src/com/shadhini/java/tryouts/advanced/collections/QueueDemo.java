package com.shadhini.java.tryouts.advanced.collections;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

public class QueueDemo {

    public static void show() {
        Queue<String> queue = new ArrayDeque<>();
        Collections.addAll(queue, "C", "A", "B");
        System.out.println(queue); // Output: [C, A, B] // C at the front of the queue

        // Add an item to the end of the queue -------------------------------------------------------------------------
        queue.offer("D"); // In an ArrayDeque there's no difference between queue.add() and queue.offer()
        // In a different kind of Queue, it depends on the implementation
        // In some cases, Queue might have a specific size. In those cases, if the Queue gets full,
        //  the queue.add() method throws an exception where as queue.offer() method returns false.
        // queue.offer() is less aggressive.
        queue.add("E");
        System.out.println(queue); // Output: [C, A, B, D, E]

        // Retrieve an item from the front of the queue ----------------------------------------------------------------
        System.out.println(queue.peek()); // Output: C
        // queue.peek() returns `null` if queue is empty
        System.out.println(queue.element()); // Output: C
        // queue.element() throws NoSuchElementException if queue is empty
        System.out.println(queue); // Output: [C, A, B, D, E]

        // Remove an item from the front of the queue ------------------------------------------------------------------
        System.out.println(queue.remove()); // Output: C
        // queue.remove() throws an exception if queue is empty
        System.out.println(queue); // Output: [A, B, D, E]

        System.out.println(queue.poll()); // Output: A
        // queue.poll() returns null if queue is empty
        System.out.println(queue); // Output: [B, D, E]

    }
}
