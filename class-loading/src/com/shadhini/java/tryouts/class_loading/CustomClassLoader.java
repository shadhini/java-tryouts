package com.shadhini.java.tryouts.class_loading;

import java.io.*;

public class CustomClassLoader extends ClassLoader{


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String fileName = name.replace('.', File.separatorChar) + ".class";
            byte[] classData = loadClassData(fileName);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    private byte[] loadClassData(String fileName) throws IOException {
        InputStream input = new FileInputStream(fileName);
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int data = input.read();
        while (data != -1) {
            buffer.write(data);
            data = input.read();
        }
        input.close();
        return buffer.toByteArray();
    }
}
