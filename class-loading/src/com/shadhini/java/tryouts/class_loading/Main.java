package com.shadhini.java.tryouts.class_loading;

public class Main {

    public static void main(String[] args) {

        // ---------------------------------------------
        // Load using Default ClassLoader
        // ---------------------------------------------

        /*
        try {
            // Load the class using the system class loader
            Class<?> clazz = Class.forName("com.shadhini.java.tryouts.class_loading.MyClass");

            // Initialize the class (optional, done automatically by Class.forName)
            // Class.forName("com.shadhini.java.tryouts.class_loading.MyClass", true, ClassLoader.getSystemClassLoader());

            // Call a static method from the loaded class
            clazz.getMethod("printMessage").invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }

         */

        // ---------------------------------------------
        // Load using Custom ClassLoader
        // ---------------------------------------------

        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> clazz = customClassLoader.loadClass("com.shadhini.java.tryouts.class_loading.MyClass");
            clazz.getMethod("printMessage").invoke(null);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
