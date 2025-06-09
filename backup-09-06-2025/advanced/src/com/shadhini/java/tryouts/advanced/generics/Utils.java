package com.shadhini.java.tryouts.advanced.generics;

public class Utils {

    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static <K, V> void print(K a, V b) {
        System.out.println(a + " = " + b);
    }


    //class CAP#1 extends User {}
    //class Instructor extends User {}
    public static void readUsers(GenericList<? extends User> users) {
        // Implementation ...
        User x = users.get(0);
    }

    //CAP#1 == parent of User {}
    //class Instructor extends User {}
    public static void addUsers(GenericList<? super User> users) {
        // Implementation ...
        users.add(new User(1));
        users.add(new Instructor(12));
        Object x = users.get(0);
    }
}
