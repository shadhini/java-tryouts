package com.shadhini.tryouts.java.basics.control_flow;

/**
 * Java `for` loops.
 */
public class ForLoops {

    public static void demo() {

        for (int i=0; i<5; i++)
            System.out.printf("%d ", i);
        // Output: 0 1 2 3 4

        System.out.println();
        System.out.println("------------------------------------");
        for (int j=1; j<=5; j++)
            System.out.printf("%d ", j);
        // Output: 1 2 3 4 5

        System.out.println();
        System.out.println("------------------------------------");
        for (int k=5; k>0; k--)
            System.out.printf("%d ", k);
        // Output: 5 4 3 2 1

        System.out.println();
        System.out.println("------------------------------------");
        for (int l=4; l>=0; l--)
            System.out.printf("%d ", l);
        // Output: 4 3 2 1 0
    }
}
