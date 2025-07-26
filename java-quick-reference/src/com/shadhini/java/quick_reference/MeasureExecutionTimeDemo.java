package com.shadhini.java.quick_reference;

public class MeasureExecutionTimeDemo {

    public static void main(String[] args) {
        var start = System.currentTimeMillis(); // milliseconds

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var end = System.currentTimeMillis();

        System.out.println("Execution time: " + (end - start)); // execution time in milliseconds
    }
}
