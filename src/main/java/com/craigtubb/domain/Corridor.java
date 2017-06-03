package com.craigtubb.domain;

import java.awt.Point;

/**
 * Represents a free corridor in a labyrinth.
 * 
 * @author craigtubb
 *
 */
public class Corridor {

    private Point point;
    private Corridor next;

    public Corridor(Point point, Corridor next) {
        this.point = point;
        this.next = next;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Corridor getNext() {
        return next;
    }

    public void setNext(Corridor next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return String.format("(%s) -> %s", point, next);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((next == null) ? 0 : next.hashCode());
        result = prime * result + ((point == null) ? 0 : point.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Corridor other = (Corridor) obj;
        if (next == null) {
            if (other.next != null)
                return false;
        } else if (!next.equals(other.next))
            return false;
        if (point == null) {
            if (other.point != null)
                return false;
        } else if (!point.equals(other.point))
            return false;
        return true;
    }
}
