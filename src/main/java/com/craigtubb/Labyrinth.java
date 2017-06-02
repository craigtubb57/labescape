package com.craigtubb;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Labyrinth {

    private char[][] labyrinth;

    public Labyrinth(char[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    public char getPoint(int x, int y) throws ArrayIndexOutOfBoundsException {
        return labyrinth[x][y];
    }

    public void setPoint(int x, int y, char ch) throws ArrayIndexOutOfBoundsException {
        labyrinth[x][y] = ch;
    }
    
    public boolean hasPoint(int x, int y) {
        try {
            return getPoint(x, y) > -1;
        } catch(ArrayIndexOutOfBoundsException e) {
            return false;
        }
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
