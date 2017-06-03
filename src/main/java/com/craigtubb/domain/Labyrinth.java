package com.craigtubb.domain;

import java.awt.Point;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents a labyrinth structure.
 * 
 * @author craigtubb
 *
 */
public class Labyrinth {

    public static final char WALL = 'O';
    public static final char FREE = ' ';
    public static final char PATH = '•';

    private char[][] labyrinth;

    public Labyrinth(char[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public char getChar(Point point) throws ArrayIndexOutOfBoundsException {
        return labyrinth[point.x][point.y];
    }

    public void setPath(Point point) throws ArrayIndexOutOfBoundsException {
        labyrinth[point.x][point.y] = PATH;
    }

    public boolean wallAtPoint(Point point) {
        return charAtPoint(WALL, point);
    }

    public boolean freeAtPoint(Point point) {
        return charAtPoint(FREE, point);
    }

    private boolean charAtPoint(char ch, Point point) {
        try {
            return getChar(point) == ch;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    public boolean isExit(Point point) {
        return point.x == 0 || point.x == labyrinth.length - 1 || point.y == 0
                || point.y == labyrinth[point.x].length - 1;
    }

    public char[][] getLabyrinth() {
        return labyrinth;
    }

    @Override
    public String toString() {
        return Arrays.stream(labyrinth).map(ch -> String.valueOf(ch)).map(str -> String.join("", str))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(labyrinth);
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
        Labyrinth other = (Labyrinth) obj;
        if (!Arrays.deepEquals(labyrinth, other.labyrinth))
            return false;
        return true;
    }
}
