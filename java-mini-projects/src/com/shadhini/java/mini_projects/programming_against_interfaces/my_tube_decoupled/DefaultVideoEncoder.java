package com.shadhini.java.mini_projects.programming_against_interfaces.my_tube_decoupled;

public class DefaultVideoEncoder implements VideoEncoder {
    @Override
    public void encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
    }
}
