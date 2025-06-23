package com.shadhini.tryouts.java.oop.interfaces.interface_segregation;

public class Dragger {

    public void drag(Draggable draggable) {
        draggable.drag();
        System.out.println("Dragging done!");
    }
}
