package com.shadhini.java.tryouts.basics;

import java.util.Arrays;

/**
 * About how to create/declare multidimensional arrays in Java.
 */
public class MultiDimensionalArrays {

    public static void main(String[] args) {

        // 1 Dimensional Array
        int[] numbers = new int[5];
        int[] numbersPredefined = {1, 2, 3, 4, 5};
        numbers[0] = 1;
        System.out.println("---------------1 Dimensional Array---------------");
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(numbersPredefined));
        /* Output:
        ---------------1 Dimensional Array---------------
        [0, 0, 0, 0, 0]
        [1, 2, 3, 4, 5]
         */

        // 2 Dimensional Array - To store a matrix
        int[][] numbers2Dim = new int[2][3]; // 2 rows , 2 columns
        int[][] numbers2DimPredefined = {{1,2,3},{4,5,6}};
        numbers2Dim[0][0] = 1;
        System.out.println("---------------2 Dimensional Array---------------");
        System.out.println(Arrays.toString(numbers2Dim));
        /* Output:
        ---------------2 Dimensional Array---------------
        [[I@64c64813, [I@3ecf72fd]
         */
        System.out.println(Arrays.deepToString(numbers2Dim));
        System.out.println(Arrays.deepToString(numbers2DimPredefined));
        /* Output:
        [[1, 0, 0], [0, 0, 0]]
        [[1, 2, 3], [4, 5, 6]]
         */

        // 3 Dimensional Array - To store a cube
        int[][][] numbers3Dim = new int[2][3][5];
        // Array design
        // {}
        // [2]--> {} --> {{},{}}
        //          -- add 2 curly braces inside the previous curly brace
        // [3]--> {{},{}} --> {{{},{},{}},{{},{},{}}
        //          -- add 3 curly braces inside each inner curly brace created in previous step
        // [5]--> {{{},{},{}},{{},{},{}} -->
        //      {{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}},{{0,0,0,0,0},{1,1,1,1,1},{2,2,2,2,2}}}
        //          -- add 5 items inside each inner curly brace created in previous step
        int[][][] numbers3DimPredefined = {{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}},{{0,0,0,0,0},{1,1,1,1,1},{2,2,2,2,2}}};
        numbers3Dim[1][1][1] = 100;
        System.out.println("---------------3 Dimensional Array---------------");
        System.out.println(Arrays.deepToString(numbers3Dim));
        System.out.println(Arrays.deepToString(numbers3DimPredefined));
        /* Output:
        ---------------3 Dimensional Array---------------
        [[[0, 0, 0, 0, 0], [0, 0, 0, 0, 0], [0, 0, 0, 0, 0]], [[0, 0, 0, 0, 0], [0, 100, 0, 0, 0], [0, 0, 0, 0, 0]]]
        [[[1, 2, 3, 4, 5], [6, 7, 8, 9, 10], [11, 12, 13, 14, 15]], [[0, 0, 0, 0, 0], [1, 1, 1, 1, 1], [2, 2, 2, 2, 2]]]
         */
    }
}
