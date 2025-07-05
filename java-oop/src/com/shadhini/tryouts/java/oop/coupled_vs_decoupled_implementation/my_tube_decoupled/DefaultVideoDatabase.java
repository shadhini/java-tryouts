package com.shadhini.tryouts.java.oop.coupled_vs_decoupled_implementation.my_tube_decoupled;

public class DefaultVideoDatabase implements VideoDatabase {
    @Override
    public void store(Video video) {
        System.out.println("Storing video metadata in a SQL database...");
        System.out.println("Title: " + video.getTitle());
        System.out.println("File Name: " + video.getFileName());
        System.out.println("Done!\n");
    }
}
