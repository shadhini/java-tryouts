package com.shadhini.java.tryouts.advanced;

import com.shadhini.java.tryouts.advanced.collections.GenericList;
/*
import com.shadhini.java.tryouts.advanced.exceptions.ExceptionsDemo;
import com.shadhini.java.tryouts.advanced.generics.GenericList;
import com.shadhini.java.tryouts.advanced.generics.Instructor;
import com.shadhini.java.tryouts.advanced.generics.User;
import com.shadhini.java.tryouts.advanced.generics.Utils;
 */

public class Main {

    public static void main(String[] args) {

        // =============================================================================================================
        // Exceptions --------------------------------------------------------------------------------------------------
        /*
        try {
            ExceptionsDemo.show();
        } catch (Throwable e) {
            System.out.println("An unexpected error occurred.");;
        }

         */

        // =============================================================================================================
        // Generics ----------------------------------------------------------------------------------------------------
        /*
        var genericList = new GenericList<Integer>();
        genericList.add(1);
        genericList.add(2);
        int a = genericList.get(0);

        var userList = new GenericList<User>();
        userList.add(new User());
        User user = userList.get(0);

        GenericList<Integer> numbers = new GenericList<>();
        numbers.add(1); // -- A: BOXING
        int value = numbers.get(0); // -- B: UNBOXING

         */

        // Generics: Comparable Interface ------------------------------------------------------------------------------
        /*
        var user1 = new User(10);
        var user2 = new User(20);

        if ((user1.compareTo(user2)) < 0) {
            System.out.println("User1 < User2");
        } else if ((user1.compareTo(user2)) == 0) {
            System.out.println("User1 == User2");
        } else {
            System.out.println("User1 > User2");
        }

         */

        // Generics: Generic Methods------------------------------------------------------------------------------------
        /*
        System.out.println(Utils.max(1, 2));
        System.out.println(Utils.max(new User(20), new User(10)));

        Utils.print(1, "hello");

         */

        // Generics: Inheritance & Wildcards----------------------------------------------------------------------------
        /*
        var instructors = new GenericList<Instructor>();
        var users = new GenericList<User>();
        Utils.readUsers(instructors);
        Utils.readUsers(users);
        Utils.addUsers(users);

         */

        // =============================================================================================================
        // Collections -------------------------------------------------------------------------------------------------

        // Collections: Iterables --------------------------------------------------------------------------------------
        var list = new GenericList<String>();
        list.add("A");
        list.add("B");
        /*
        var iterator = list.iterator();

        while (iterator.hasNext()) {
            var current = iterator.next();
            System.out.println(current);
        }

         */

        for (var item: list)
            System.out.println(item);

    }
}
