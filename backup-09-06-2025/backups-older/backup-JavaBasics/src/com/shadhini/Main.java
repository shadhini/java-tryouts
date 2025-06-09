package com.shadhini;

import java.awt.*;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        int age = 30; // variables hold integers, with no decimal points
        int a = 1, b = 2; // not nice
        age = 35;
        System.out.println("Hello World !");
        System.out.println(age);

        // --------- Primitive Types ---------------
        byte age2 = 3;
        int viewCount0 = 123_456_789;
        // int viewCount1 = 3_123_456_789; //integer number too large
        long viewCount2 = 3_123_456_789l; // define as a long
        long viewCount3 = 3_123_456_789L; // better to use CAPITAL L
        double price = 10.99; // double is too large to store price of a product
        // float price2 = 10.99; // by default JAVA see this number with decimal points as a double
        float price3 = 10.99F;
        char letter = 'A'; // always wrap single characters with single quotes and multiple characters or strings with double quoates
        boolean isEligible = true;
        boolean isNotEligible = false;

        // --------- Reference Types ---------------
        Date now = new Date();
        System.out.println(now);
        now.getTime();

        // --------- Primitive Variables ---------------
        byte x = 1;
        byte y = x;
        x = 2;
        System.out.println(x);

        // --------- Reference Variables ---------------
        Point point1 = new Point(1, 1);
        Point point2 = point1;
        point1.x = 2;
        System.out.println(point2);

        // --------- Strings ---------------
        System.out.println("Hello World !"); // string literal
        // String message = new String("message 1");
        String message2 = "  message 2" + " !! ";
        System.out.println(message2.endsWith("!!"));
        System.out.println(message2.length());
        System.out.println(message2.indexOf("2"));
        System.out.println(message2.indexOf("sky"));
        System.out.println(message2.replace("!", "*"));
        System.out.println(message2.toUpperCase());
        System.out.println(message2.trim()); // get rid of extra white spaces that can be at the beginning or the end of a string
        System.out.println(message2);

        // --------- Escape Sequences ---------------
        String message3 = "Hello \"Mosh\" !!";
        String message4 = "c:\\Windows\\..";
        String message5 = "Hello \nMosh \n!!";
        String message6 = "c:\tWindows\\..";
        System.out.println(message6);

        // --------- Arrays ---------------
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        //numbers[10] = 3; // raise an Exception: ArrayIndex
        System.out.println(numbers); // by default when you print an array, JAVA returns a string which is calculated based on the address of this object in memory
        System.out.println(Arrays.toString(numbers));

        // initialize an array if we know the elements beforehand
        int[] numbers2 = {2, 3, 5, 1, 4};
        System.out.println(numbers2.length);
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));

        // --------- Multi-dimensional Arrays ---------------
        int[][] numbers3 = new int[2][3]; // 2 rows, 3 columns
        int[][][] numbers4 = new int[2][3][5];
        numbers3[0][0] = 1;
        System.out.println(Arrays.toString(numbers3)); // gives the addresses as this is a multi dimensional array
        System.out.println(Arrays.deepToString(numbers3));

        int[][] numbers5 = {{1, 2, 3}, {4, 5, 6}}; // 2 rows, 3 columns  each row is a an array again as it is a list of items
        System.out.println(Arrays.deepToString(numbers5));

        // --------- Constants ---------------
        float pi2 = 3.14F;
        pi2 = 1;
        final float PI = 3.14F; // capital letters to define constants
        //PI = 1; // cannot change the value later, gives a compilation error

        // --------- Arithmetic Expressions ---------------
        int result = (4 + 6 - 9) * 3;
        System.out.println(result);
        int division = 10 / 3; // division of 2 whole numbers are a whole number,
        // if you want to get a floating point number, you need t convert these numbers to a float or a double
        double division2 = (double) 10 / (double) 3; // casting result to a double
        // numbers we have here --> operands
        // symbols --> operators

        int z = 1;
        z++;
        ++z;
        System.out.println(z);

        int q = 1;
        int r = q++; // first, q's value is copied to r, and then q is incremented by 1
        System.out.println(q);
        System.out.println(r);

        int s = 1;
        int t = ++s; // first, s is incremented by 1, then s's value is copied to t
        System.out.println(s);
        System.out.println(t);

        int u = 1;
        u = u + 2;
        u += 2; // augmented/compelled assignment operator
        u /= 2;
        // both of above these are identical
        System.out.println(u);

        // --------- Casting & Type Conversion ---------------
        // Implicit Casting --- automatic casting/conversion
        // whenever we have a value and that value can be converted to data type that is bigger, casting/conversion happens automatically/implicitly
        // Implicit casting happens whenever we are not going to loose data. No chance for data loss
        // so byte can be converted to a short, short to int ...
        // byte > short > int > long . float > dpuble

        short l = 1;
        int m = l + 2; // a short variable has 2 bytes, an integer has 4 bytes. so any value stores in a short can also be stored in an integer variable
        // first JAVA looks at l's value (1). it's gonna allocate an anonymous variable somewhere in memory. that variable is gonna be the type of integer.
        // it's copy l's value to that memory space and it's add those numbers together
        System.out.println(m);

        double n = 1.1;
        double o = n + 2; // here addition happens between an integer and a double
        // an integer is less precise that a double, so here jAVA automatically cast integer to a double (2.0) and then addition happens

        // Explicit Casting ---
        // can happen only between compatible data types. we can't cast string to a number
        double e = 1.1;
        int f = (int) e + 2; // e is casted to integer that is converted to 1 and then added to 2

        // for all the primitive types we have wrapper classes
        String g = "1";
        // Integer --> wrapper class for ints, Float --> wrapper for flaots, Short --> wrapper for shorts
        int h = Integer.parseInt(g) + 2;
        // we always receive input from the user as a string
        System.out.println(h);
        String i = "1.1";
        double j = Double.parseDouble(i) + 2;
        System.out.println(j);

        // --------- Math Class ---------------
        int mResult = Math.round(1.1F);
        int mResult2 = (int) Math.ceil(1.1F); // returns the smallest number greater than or equal to this number
        int mResult3 = (int) Math.floor(1.1F); // returns the largest number less than or equal to this number
        int mResult4 = Math.max(1,2);
        int mResult5 = Math.min(1,2);
        double mResult6 = Math.random(); // returns a floating point number between 0 and 1
        int mResult7 = (int) Math.round(Math.random() * 100); // returns a integer between 0 and 100
        // round method returns a long which is larger than an integer. so implicit casting doesn't happen here
        int mResult8 = (int) Math.random() * 100; // this returns --> 0 always, as (int) casting is applied to random method, not affect to multplication by 100
        int mResult9 = (int) (Math.random() * 100); // correct answer


        // --------- Format Numbers ---------------
        // NumberFormat class is abstract, can't be instantiated
        // like half baked cake
        NumberFormat currency = NumberFormat.getCurrencyInstance(); // this method creates an instance of NumberFormat class and returns it
        // this is calle a "Factory Method", bcz it's like a factory, it creates new objects
        String cResult = currency.format(1234567.891);
        System.out.println(cResult);

        NumberFormat percent = NumberFormat.getPercentInstance(); // this method creates an instance of NumberFormat class and returns it
        String pResult = percent.format(0.1);
        System.out.println(pResult);

        // method chaining
        System.out.println(NumberFormat.getPercentInstance().format(0.4));


















    }
}
