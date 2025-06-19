package com.shadhini.tryouts.java.basics.control_flow;

/**
 * Switch statement.
 */
public class SwitchStatement {

    public static void demo() {
        String role = "admin";

        // With If statements
        if (role == "admin")
            System.out.println("You're an admin");
        else if (role == "moderator")
            System.out.println("You're a moderator");
        else
            System.out.println("You are a guest");

        // With Switch statement
        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;

            case "moderator":
                System.out.println("You're a moderator");
                break;

            default:
                System.out.println("You are a guest");
        }

        short num = 8;

        switch (num) {
            case 1:
                System.out.println("You're number 1");
                break;

            case 2:
                System.out.println("You're number 2");
                break;

            default:
                System.out.println("Please take a number");
        }

    }
}
