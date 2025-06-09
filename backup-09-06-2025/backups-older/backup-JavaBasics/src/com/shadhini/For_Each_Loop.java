package com.shadhini;

public class For_Each_Loop {

    public static void main(String[] args) {
        String[] fruits = {"Apple", "Mango", "Orange"};

        for (String fruit : fruits)
            System.out.println(fruit);

        // limitations
        // 1. it's always forward only
        // 2. We don't have the access to the index
    }
}
