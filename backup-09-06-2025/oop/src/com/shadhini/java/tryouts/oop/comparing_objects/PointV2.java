package com.shadhini.java.tryouts.oop.comparing_objects;

import java.util.Objects;

public class PointV2 {

    private int x;
    private int y;

    public PointV2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) // In case both variables reference to the same object
            return true;

        if (!(obj instanceof PointV2)) // In case the argument is not an instance of PointV2 class
            return false;

        var other = (PointV2) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        // Generate hash based on the content of the object instead of the address of the object in the memory
        // In theory a hash uniquely identifies an object; This is true 99% of the time.
        return Objects.hash(x, y);
    }
}
