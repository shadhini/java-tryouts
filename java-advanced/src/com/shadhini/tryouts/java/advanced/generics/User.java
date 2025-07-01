package com.shadhini.tryouts.java.advanced.generics;

public class User implements Comparable<User>, Cloneable {

    private int points;

    public User(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(User other) {
        // this < other     -> -1
        // this == other    -> 0
        // this > other     -> 1
        return points - other.points;
    }

    @Override
    public String toString() {
        return super.toString() + " ----- Points = " + points;
    }
}

