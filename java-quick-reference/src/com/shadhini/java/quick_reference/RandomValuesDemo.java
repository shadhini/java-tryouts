package com.shadhini.java.quick_reference;

import java.util.Random;

public class RandomValuesDemo {

    public static void main(String[] args) {
        // generate decimal between 0 - 1
        System.out.println(Math.random()); // 0.6283457026487501

        // generate random integer between 100 - 110
        Random random = new Random();
        System.out.println(100 + random.nextInt(10)); // 104
    }
}
