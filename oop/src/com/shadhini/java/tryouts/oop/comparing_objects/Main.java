package com.shadhini.java.tryouts.oop.comparing_objects;

public class Main {

    public static void main(String[] args) {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);

        System.out.println(point1 == point2); // Output: false
        // These Point objects are reference types.
        // Thus, values stored in variables point1 and point2 are the addresses of the actual objects.
        // Here, we are dealing with 2 different Point objects. Thus, addresses are different leading to the `false` output.

        System.out.println(point1.equals(point2)); // Output: false
        // Default implementation of equals() method in Object class compares 2 objects based on their references.
        // If we want to compare Point objects based on content,
        // Then we have to override the default implementation of Object class.

        PointV2 point3 = new PointV2(1, 2);
        PointV2 point4 = new PointV2(1, 2);
        System.out.println(point3 == point4); // Output: false
        System.out.println(point3.equals(point4)); // Output: true

        System.out.println(point1.hashCode()); // Output: 1975358023
        System.out.println(point2.hashCode()); // Output: 2101440631
        System.out.println(point3.hashCode()); // Output: 994
        System.out.println(point4.hashCode()); // Output: 994
    }
}
