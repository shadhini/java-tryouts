package com.shadhini.java.tryouts.tools.my_tube_improved;

public class DefaultVideoEncoder implements VideoEncoder {
    @Override
    public void encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
    }
}
