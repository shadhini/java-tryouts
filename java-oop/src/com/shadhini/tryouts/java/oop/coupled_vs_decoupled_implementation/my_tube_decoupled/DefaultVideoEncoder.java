package com.shadhini.tryouts.java.oop.coupled_vs_decoupled_implementation.my_tube_decoupled;

public class DefaultVideoEncoder implements VideoEncoder {
    @Override
    public void encode(Video video) {
        System.out.println("Encoding video...");
        System.out.println("Done!\n");
    }
}
