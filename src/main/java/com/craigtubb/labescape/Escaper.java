package com.craigtubb.labescape;

import java.awt.Point;
import java.util.Arrays;

import com.craigtubb.domain.Labyrinth;
import com.craigtubb.exception.NoEscapeException;

public interface Escaper {

    static LabToEscape escape(LabToEscape toEscape) throws NoEscapeException, ArrayIndexOutOfBoundsException {
        Labyrinth labyrinth = Labyrinth.fromString(toEscape.getInput());
        labyrinth.validatePoint(new Point(toEscape.getX(), toEscape.getY()));
        char[][] grid = labyrinth.getGrid();
        toEscape.setRows(grid.length);
        toEscape.setCols(Arrays.stream(grid).mapToInt(col -> col.length).max().getAsInt());
        char[][] escape = LabEscape.drawPathForEscape(grid, toEscape.getX(), toEscape.getY());
        toEscape.setOutput(new Labyrinth(escape).toString());
        return toEscape;
    }
}
