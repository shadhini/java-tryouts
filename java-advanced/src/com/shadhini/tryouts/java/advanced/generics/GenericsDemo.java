package com.shadhini.tryouts.java.advanced.generics;

import com.shadhini.tryouts.java.advanced.generics.poor_implementation.PoorImplementationOfListDemo;

/**
 * Demonstrates the use of generics in Java.
 */
public class GenericsDemo {

    public static void main(String[] args) {
        // 1. Need for Generics ----------------------------------------------------------------------------------------
        System.out.println("1. Need for Generics --------------------------------------------------------------------");

        // Poor implementation of a List-like structure that does not use generics
        PoorImplementationOfListDemo.demo();

        // 2. Generic Classes & Boxing ---------------------------------------------------------------------------------
        System.out.println("2. Generic Classes & Boxing -------------------------------------------------------------");
        demo1GenericList();

        // 3. Constraints on Type Parameter  ---------------------------------------------------------------------------
        System.out.println("3. Constraints on Type Parameter --------------------------------------------------------");

        // implementation of com.shadhini.tryouts.java.advanced.generics.ComparableCloneableGenericList

        // 4. Type Erasure ---------------------------------------------------------------------------------------------
        System.out.println("4. Type Erasure -------------------------------------------------------------------------");

        // Check the byte code of the following classes to see how type erasure works.
        //    com.shadhini.tryouts.java.advanced.generics.ComparableCloneableGenericList
        //    com.shadhini.tryouts.java.advanced.generics.GenericList


        // 5. Generic Methods ------------------------------------------------------------------------------------------
        System.out.println("5. Generic Methods ----------------------------------------------------------------------");

        // Checkout com.shadhini.tryouts.java.advanced.generics.Utils class methods for examples of generic methods.

        // Methods in Utils class with a single type parameter
        System.out.println(Utils.max(1, 2)); // Output: 2
        System.out.println(Utils.max(new User(20), new User(10))); // Output: Points = 20

        // 6. Multiple Type Parameters ---------------------------------------------------------------------------------
        System.out.println("6. Multiple Type Parameters -------------------------------------------------------------");

        // Methods with multiple type parameters in com.shadhini.tryouts.java.advanced.generics.Utils class
        // Methods in Utils class with multiple type parameters
        Utils.print(1, "hello");

        // Generic class with multiple type parameters
        //       com.shadhini.tryouts.java.advanced.generics.KeyValuePair


        // 7. Inheritance & Wildcards ----------------------------------------------------------------------------------
        System.out.println("7. Inheritance & Wildcards --------------------------------------------------------------");
        demo2Wildcards();

    }

    // Based on com.shadhini.tryouts.java.advanced.generics.ComparableCloneableGenericList implementation &
    //      com.shadhini.tryouts.java.advanced.generics.GenericList  implementation
    public static void demo1GenericList() {
        var users = new ComparableCloneableGenericList<User>();
        var instructors = new ComparableCloneableGenericList<Instructor>();

        GenericList<Integer> numbers = new GenericList<>();
        GenericList<String> strings = new GenericList<>();

        users.add(new User(1));
        instructors.add(new Instructor(1));
        numbers.add(1); // -- BOXING

        User user = users.get(0);
        Instructor instructor = instructors.get(0);
        int value = numbers.get(0); // -- UNBOXING

        System.out.println("User @index 0: " + user);
        System.out.println("Instructor @index 0: " + instructor);
        System.out.println("Number @index 0: " + value);
    }

    // Wildcards .......
    // Based on
    //      public static void readUsersV1(GenericList<User> users)
    //      public static void readUsersV2(GenericList<?> users)
    //      public static void readUsersV3(GenericList<? extends User> users)
    //      public static void addUsers(GenericList<? super User> users)
    // methods of com.shadhini.tryouts.java.advanced.generics.Utils class
    public static void demo2Wildcards() {
        // com.shadhini.tryouts.java.advanced.generics.Instructor
        //      extends com.shadhini.tryouts.java.advanced.generics.User
        // But generic list of Instructor is not a generic list of User.
        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();

        // Without wildcards
        // =============================================================================================================
        System.out.println("---- Without wildcards ----");
        Utils.readUsersV1(users);
        // Utils.readUsersV1(instructors); // Compile time error: incompatible types

        // With wildcards -- with no constraints on wildcards
        // =============================================================================================================
        System.out.println("---- With wildcards: but without constraints on wildcards ----");
        Utils.readUsersV2(users);
        Utils.readUsersV2(instructors);

        // However, here we can pass GenericList of anything.
        Utils.readUsersV2(new GenericList<Integer>());
        Utils.readUsersV2(new GenericList<Object>());

        // With wildcards -- With extend constraint on wildcard
        // =============================================================================================================
        System.out.println("---- With wildcards: With extend constraint on wildcard ----");
        Utils.readUsersV3(instructors);
        Utils.readUsersV3(users);
        // Utils.readUsersV3(new GenericList<Integer>()); // Compile time error: incompatible types
        // Utils.readUsersV3(new GenericList<Object>()); // Compile time error: incompatible types

        // With wildcards -- With super constraint on wildcard
        // =============================================================================================================
        System.out.println("---- With wildcards: With super constraint on wildcard ----");
        Utils.addUsers(users);
        // Utils.addUsers(instructors); // Compile time error: Required type: GenericList <? super User>
        // Utils.addUsers(new GenericList<Integer>()); // Compile time error: Required type: GenericList <? super User>
        Utils.addUsers(new GenericList<Object>());
    }


}
