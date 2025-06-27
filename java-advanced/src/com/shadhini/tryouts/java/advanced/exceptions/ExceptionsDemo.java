package com.shadhini.tryouts.java.advanced.exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Exceptions Demo
 */
public class ExceptionsDemo {

    public static void main(String[] args) {
        // Demo 1: Exceptions ------------------------------------------------------------------------------------------
        System.out.println("Demo 1: Exceptions ----------------------------------------------------------------------");
         demo1Exceptions();

        // Handling Exceptions
        // =============================================================================================================
        // Demo 2: Exception Handling with Catch & Finally block -------------------------------------------------------
        System.out.println("Demo 2: Exception Handling with Catch & Finally block -----------------------------------");
        demo2ExceptionHandlingWithTryCatchFinallyBlocks();
        /* Output: without file.txt
        Inside try.. block.
        Trying to open a file...
        Inside catch.. block for FileNotFoundException.
        file.txt (No such file or directory)
        Inside finally.. block.
        Outside try.. catch.. block.
        End of file reading.
        java.io.FileNotFoundException: file.txt (No such file or directory)
            ...
            at com.shadhini.tryouts.java.advanced.exceptions.ExceptionsDemo.demo2ExceptionHandlingWithCatchFinallyBlocks(ExceptionsDemo.java:36)
            at com.shadhini.tryouts.java.advanced.exceptions.ExceptionsDemo.main(ExceptionsDemo.java:19)
         */

        // Demo 3: try with resources statement ------------------------------------------------------------------------
        System.out.println("Demo 3: try with resources statement ----------------------------------------------------");
        demo3TryWithResources();

        // Demo 4: Throw Exceptions ------------------------------------------------------------------------------------
        System.out.println("Demo 4: Throw Exceptions ----------------------------------------------------------------");
        demo4ThrowExceptions();

        // Demo 5: Re-throw Exceptions & Generic Exception Handler -----------------------------------------------------
        System.out.println("Demo 5: Re-throw Exceptions & Generic Exception Handler ---------------------------------");
        demo5RethrowExceptions();

        // Demo 6: Generic Exception Handler  --------------------------------------------------------------------------
        // When exception is caught without handling/displaying it,
        //     you should re-throw it so it can be manage elsewhere in the application.
        // A generic exception handler that catches all kinds of exceptions
        //     can get it and display a generic error message.
        System.out.println("Demo 6: Generic Exception Handler -------------------------------------------------------");
        demo6GenericExceptionHandler();


        // Demo 7: Custom Exceptions -----------------------------------------------------------------------------------
        System.out.println("Demo 7: Custom Exceptions ---------------------------------------------------------------");
        demo7CustomExceptions();

        // Demo 8: Chaining Exceptions ---------------------------------------------------------------------------------
        System.out.println("Demo 8: Chaining Exceptions -------------------------------------------------------------");
        demo8ChainingExceptions();

    }

    // Demo 1: Exceptions
    public static void demo1Exceptions() {
        sayHello(null); // -> java.lang.NullPointerException
    }

    // Demo 2: Exception Handling with Catch & Finally block
    public static void demo2ExceptionHandlingWithTryCatchFinallyBlocks() {
        FileReader reader = null;
        try {
            System.out.println("Inside try.. block.");

            System.out.println("Trying to open a file...");
            reader = new FileReader("file.txt"); // --- A
            System.out.println("File opened.");

            System.out.println("Trying to read from the file...");
            var value = reader.read(); // --- B
            System.out.println("Value read from the file: " + value);

            System.out.println("Trying to parse a date...");
            new SimpleDateFormat().parse(""); // --- C
            System.out.println("Date parsed successfully.");

        } catch (FileNotFoundException e) {
            // Gets executed if FileNotFoundException is thrown at line A
            System.out.println("Inside catch.. block for FileNotFoundException.");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException | ParseException  e) {
            // Gets executed if IOException or ParseException is thrown at line B or C
            System.out.println("Inside catch.. block for IOException & ParseException.");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Inside finally.. block.");
            if (reader != null) {
                try {
                    reader.close();
                    System.out.println("File closed.");
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Outside try.. catch.. block.");
        System.out.println("End of file reading.");
    }

    // Demo 3: try with resources statement
    public static void demo3TryWithResources() {
        try (
                var reader = new FileReader("file.txt");
                var writer = new FileWriter("...");
        ) {
            System.out.println("Files opened.");
            var value = reader.read();
            writer.write(value);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End of file reading & writing.");
    }

    // Demo 4: Throw Exceptions
    private static void demo4ThrowExceptions() {
        var account = new Account();

        System.out.println("Demo 4.1: Call a method that throw RuntimeException");
        // Call a method that throw RuntimeException
        account.depositThrowRuntimeException(-1);

        System.out.println("Demo 4.2: Call a method that throw CheckedException");
        // Call a method that throw CheckedException
        try {
            account.depositTrowCheckedException(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    // Demo 5: Re-throw Exceptions
    public static void demo5RethrowExceptions() {
        var account = new Account();
        try {
            account.depositTrowCheckedException(1);
        } catch (IOException e) {
            System.out.println("Logging");
            // Rethrow the exception
            throw new RuntimeException(e);
        }
    }

    // Demo 6: Generic Exception Handler
    public static void demo6GenericExceptionHandler() {
        try {
            rethrowCheckedException();
        } catch (IOException e) {
            System.out.println("Generic Exception Handler....." + e.getMessage());
            e.printStackTrace();
        }
    }

    // Demo 7: Custom Exceptions
    public static void demo7CustomExceptions() {
        var account = new Account();
        try {
            account.withdrawWithCustomException(100);
        } catch (InsufficientFundsException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

    }

    // Demo 8: Chaining Exceptions
    public static void demo8ChainingExceptions() {
        var account = new Account();
        try {
            account.withdrawWithChainingException(100);
        } catch (AccountException e) {
            System.out.println("Chained Exception: " + e.getCause().getMessage());
        }
    }


    // Support Methods -------------------------------------------------------------------------------------------------

    public static void sayHello(String name) {
        System.out.println(name.toUpperCase());
    }

    public static void rethrowCheckedException() throws IOException {
        var account = new Account();
        try {
            account.depositTrowCheckedException(1);
        } catch (IOException e) {
            System.out.println("Logging");
            throw e; // Re-throwing the Exception
        }
    }
}
