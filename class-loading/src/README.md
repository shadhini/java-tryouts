# Example of Java Class Loading

Here’s an example to illustrate class loading in Java:

* MyClass.java --> a simple class with static block and static method
* Main.java --> loads and initializes the MyClass using default ClassLoader


**Compile and Run**:
Compile the classes and run the `Main` class:
```sh
javac com/shadhini/java/tryouts/class_loading/MyClass.java com/shadhini/java/tryouts/class_loading/Main.java
java com.shadhini.java.tryouts.class_loading.Main
```

Output:
```plaintext
MyClass static block initialized
Hello from MyClass
```

# Example of Custom Class Loader

Here’s an example of a custom class loader:

CustomClassLoader.java --> custom Class Loader that extends ClassLoader
Main.java --> loads and initializes the MyClass using custom ClassLoader

**Compile and Run**:
Compile the classes and run the `Main` class using the custom class loader:
```sh
javac com/shadhini/java/tryouts/class_loading/CustomClassLoader.java com/shadhini/java/tryouts/class_loading/MyClass.java com/shadhini/java/tryouts/class_loading/Main.java
java com.shadhini.java.tryouts.class_loading.Main
```

