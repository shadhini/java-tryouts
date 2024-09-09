package com.shadhini.java.tryouts.basics;

import java.awt.*;

/**
 * Difference between Primitive Types and Reference Types
 */
public class PrimitiveVsReference {

    public static void main(String[] args) {
        // In terms of memory management

        // Primitive Types
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(x);
        System.out.println(y);

        // Reference Types
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 3;
        System.out.println(point2);

    }
}
