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
    public static final char PATH = '\u2022';

    private char[][] grid;

    public Labyrinth(char[][] grid) {
        this.grid = grid;
    }

    public char getChar(Point point) throws ArrayIndexOutOfBoundsException {
        return grid[point.x][point.y];
    }

    public void setPath(Point point) throws ArrayIndexOutOfBoundsException {
        grid[point.x][point.y] = PATH;
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
        return point.x == 0 || point.x == grid.length - 1 || point.y == 0 || point.y == grid[point.x].length - 1;
    }

    public char[][] getGrid() {
        return grid;
    }

    public static Labyrinth fromString(String labyrinth) {
        return new Labyrinth(
                Arrays.stream(labyrinth.split("\\r?\\n")).map(s -> s.toCharArray()).toArray(size -> new char[size][]));
    }

    @Override
    public String toString() {
        return Arrays.stream(grid).map(ch -> String.valueOf(ch)).map(str -> String.join("", str))
                .collect(Collectors.joining("\n"));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.deepHashCode(grid);
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
        if (!Arrays.deepEquals(grid, other.grid))
            return false;
        return true;
    }
}
