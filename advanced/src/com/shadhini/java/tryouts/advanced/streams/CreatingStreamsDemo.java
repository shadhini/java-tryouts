package com.shadhini.java.tryouts.advanced.streams;

import java.util.ArrayList;
import java.util.Collection;

public class CreatingStreamsDemo {
    public static void show() {
        Collection x = new ArrayList<String>();
        x.stream().count();

        var y = new ArrayList<String>();
        y.stream().count();



    }
}
