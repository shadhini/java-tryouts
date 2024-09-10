package com.shadhini.java.tryouts.basics;

import java.util.Arrays;

/**
 * About Java Arrays.
 * [java.util.Arrays]
 */
public class ArraysType {

    public static void main(String[] args) {

        // Integer Array
        // ============================================================================================================

        int[] numbers = new int[5];
        numbers[4] = 5;
        numbers[0] = 1;
        numbers[1] = 2;

        // numbers[10] = 3;
        /* Output:
        java.lang.ArrayIndexOutOfBoundsException
         */

        System.out.println(numbers);
        /* Output: A string calculated based on the address of this object in memory
        [I@75b84c92
         */

        System.out.println(numbers.length);
        /* Output:
        5
         */

        System.out.println(Arrays.toString(numbers));
        /* Output:
        [1, 2, 0, 0, 5]

        Note:
        The elements that haven't been explicitly set are initialized to `0` by default in an integer array.
        If it's a boolean array, then all elements will be initialized to `false` by default.
        If it's a string array, then all elements will be initialized to empty string by default.
         */

        // Integer Array Initialization - When elements are known ahead of time
        // ===========================================================================================================

        int[] numbers2 = {2, 3, 5, 1, 4};

        System.out.println(Arrays.toString(numbers2));
        /* Output:
        [2, 3, 5, 1, 4]
         */

        // Sort Arrays
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));
        /* Output:
        [1, 2, 3, 4, 5]
         */



    }
}
