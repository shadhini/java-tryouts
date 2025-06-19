package com.shadhini.tryouts.java.basics.types;

import java.awt.*;

/**
 * Difference between Primitive types and Reference types.
 */
public class PrimitiveVsReference {

    public static void demo() {
        // In terms of memory management -------------------------------------------------------------------------------

        // Primitive Types
        // =============================================================================================================
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(x);
        System.out.println(y);
        /* Output:
        2
        1
         */

        // Reference Types
        // =============================================================================================================
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 3;
        System.out.println(point1);
        System.out.println(point2);
        /* Output:
        java.awt.Point[x=3,y=1]
        java.awt.Point[x=3,y=1]
         */

    }
}
