package com.craigtubb;

import java.util.AbstractMap;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class RouteFinder {

    private Labyrinth labyrinth;
    private int startX;
    private int startY;

    public RouteFinder(Labyrinth labyrinth, int startX, int startY) {
        this.labyrinth = labyrinth;
        this.startX = startX;
        this.startY = startY;
    }

    public Corridor find() throws NoEscapeException {
        Corridor startCorridor = new Corridor(startX, startY, findNext(startX, startY));
        if (startCorridor.getNext() == null) {
            throw new NoEscapeException();
        }
        return startCorridor;
    }

    private Corridor findNext(int x, int y) {
        return IntStream.rangeClosed(x - 1, x + 1).boxed().flatMap(
                row -> IntStream.rangeClosed(y - 1, y + 1).boxed().map(col -> new AbstractMap.SimpleEntry<>(row, col)))
                .filter(pair -> labyrinth.hasPoint(pair.getKey(), pair.getValue())).map(pair -> findNext(pair.getKey(), pair.getValue())).map(next -> new Corridor(x, y, next)).findFirst().orElse(null);
    }
    
    private static Supplier<NoEscapeException> noEscape() {
        return () -> new NoEscapeException();
    }
}
