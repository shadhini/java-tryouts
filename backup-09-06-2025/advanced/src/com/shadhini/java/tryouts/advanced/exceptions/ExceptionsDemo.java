package com.shadhini.java.tryouts.advanced.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionsDemo {

    public static void show() throws IOException {
        // Demo 1: Exceptions ------------------------------------------------------------------------------------------
        /*
        sayHello(null); // -> java.lang.NullPointerException

         */

        // Demo 2: Catch Exceptions & Finally block --------------------------------------------------------------------
        /*
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            System.out.println("File opened.");
            var value = reader.read();
            new SimpleDateFormat().parse("");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException | ParseException  e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("End of file reading.");

         */

        // Demo 3: try with resources statement ------------------------------------------------------------------------
        /*
        try (
                var reader = new FileReader("file.txt");
                var writer = new FileWriter("...");
        ) {
            System.out.println("File opened.");
            var value = reader.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End of file reading.");

         */

        // Demo 4: Throw Exceptions ------------------------------------------------------------------------------------
        /*
        var account = new Account();

        // Call a method that throw RuntimeException
        account.depositRuntime(-1);

        // Call a method that throw CheckedException
        try {
            account.depositChecked(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

         */

        // Demo 5: Re-throw Exceptions ---------------------------------------------------------------------------------
        /*
        var account = new Account();
        try {
            account.depositChecked(1);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e;
        }

         */

        // Demo 6: Custom Exceptions -----------------------------------------------------------------------------------
        /*
        var account = new Account();
        try {
            account.withdraw(100);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

         */

        // Demo 7: Chaining Exceptions ---------------------------------------------------------------------------------
        var account = new Account();
        try {
            account.withdraw(100);
        } catch (AccountException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }
}
