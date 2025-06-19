package com.shadhini.tryouts.java.basics.types;

public class TypesDemo {

    public static void demo() {
    // 1. Primitive Types: ---------------------------------------------------------------------------------------------
        System.out.println("Primitive Types: ------------------------------------------------------------------------");
        byte age = 29; //a byte can store [-128, 127], so that space is more than enough to store age

        // # of times a YouTube video has been watched
        long viewsCount = 3_123_456_789L; // with integers, we can store numbers upto 2 billion

        // a double is too large to store price of a product
        float price = 10.99F;

        char letter = 'A';

        boolean isEligible = false;

    // 2. Reference Types: ---------------------------------------------------------------------------------------------
        System.out.println("Reference Types: ------------------------------------------------------------------------");
        ReferenceTypes.demo();

    // 3. Primitive vs Reference Types: --------------------------------------------------------------------------------
        System.out.println("Primitive vs Reference Types: -----------------------------------------------------------");
        PrimitiveVsReference.demo();

    }
}
