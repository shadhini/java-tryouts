package com.shadhini.tryouts.java.advanced.generics;

public class Utils {

    // Method with a single type parameter
    // <T extends Comparable<T>> part in the method signature
    //      indicates that T must be a type that implements Comparable interface
    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    // Method with multiple type parameters
    // <K, V> part in the method signature
    //      indicates that K and V can be any types
    public static <K, V> void print(K a, V b) {
        System.out.println(a + " = " + b);
    }

    // GenericList of User
    public static void readUsersV1(GenericList<User> users) {
        // Implementation ...
        User x = users.get(0);
        Instructor y = (Instructor) users.get(0); // Safe cast, but not recommended

        users.add(new User(1));
        users.add(new Instructor(12));
        // Can't pass list of Instructor to this method as an argument, But can add an Instructor to the list
        // If Java allowed you to pass a GenericList<Instructor> to this method,
        //      you could accidentally add a User (who is not an Instructor)
        //      to a list that is supposed to contain only Instructor objects, breaking type safety.

        System.out.println("Printing users without wildcards: ....." + users);
    }

    // GenericList of any specific type
    //class CAP#1 {}
    public static void readUsersV2(GenericList<?> users) {
        // Implementation ...
        Object x = users.get(0);
        User y = (User) users.get(0); // Unsafe cast: no relationship between User and CAP#1(anonymous) class

        users.add(null);
        // users.add(new Object()); // Compile time error: required type: capture of ?
        // users.add(new User(1)); // Compile time error: required type: capture of ?
        // users.add(new Instructor(12)); // Compile time error: required type: capture of ?
        // Here, GenericList<?>` is a list of an unknown type.
        // The wildcard `?` means "some specific type, but we don't know which."
        // Therefore, you cannot safely add any object (not even a `User` or `Instructor`) to it,
        //      because the compiler cannot guarantee type safety.
        // The only thing you can add to a `GenericList<?> is null.

        System.out.println("Printing users with wildcards without any constraints: ....." + users);
    }

    // GenericList of any specific subtype of User
    //class CAP#1 extends User {}
    //class Instructor extends User {}
    public static void readUsersV3(GenericList<? extends User> users) {
        // Implementation ...
        User x = users.get(0);
        Instructor instructor = (Instructor) users.get(0); // Unsafe cast:
        // no relationship between Instructor and CAP#1(anonymous) class

        // users.add(new User(1)); // Compile time error: required type: capture of ? extends User
        // users.add(new Instructor(12)); // Compile time error: required type: capture of ? extends User
        // Here, you cannot add any object (except null) to a collection declared with ? extends User.
        // The compiler does not know the exact subtype of User the list holds,
        //      so adding a User or Instructor is unsafe.

        System.out.println("Read users with wildcards with constraints: ....." + users);
    }

    // GenericList of User and/or any of its subtypes
    //CAP#1 == parent of User {}
    //class Instructor extends User {}
    public static void addUsers(GenericList<? super User> users) {
        // Implementation ...
        Object x = users.get(0);
        User y = (User) users.get(0); // Safe cast
        Instructor instructor = (Instructor) users.get(0); // Safe cast

        users.add(new User(1));
        users.add(new Instructor(12));

        // users.add(new Object()); // Compile time error: required type: capture of ? super User
        //Here, you cannot add an Object because the list could be of type User or any of its subtypes,
        //  but not necessarily Object.
        //  Only User and its subclasses are allowed

        System.out.println("Add users with wildcards with constraints: ....." + users);
    }
}
