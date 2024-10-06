package com.shadhini.java.tryouts.oop.interfaces.interface_segregation;

public class Dragger {

    public void drag(Draggable draggable) {
        draggable.drag();
        System.out.println("Dragging done!");
    }
}
