package com.craigtubb;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class RouteFinder {

    private Labyrinth labyrinth;
    private char freeChar;
    private int startX;
    private int startY;

    public RouteFinder(Labyrinth labyrinth, char freeChar, int startX, int startY) {
        this.labyrinth = labyrinth;
        this.freeChar = freeChar;
        this.startX = startX;
        this.startY = startY;
    }

    public Corridor find() throws NoEscapeException {
        SimpleEntry<Integer, Integer> start = new SimpleEntry<>(startX, startY);
        Corridor startCorridor = new Corridor(startX, startY, findNext(start, new ArrayList<>()));
        if (startCorridor.getNext() == null) {
            throw new NoEscapeException();
        }
        return startCorridor;
    }

    private Corridor findNext(SimpleEntry<Integer, Integer> at, List<SimpleEntry<Integer, Integer>> previous) {
        previous.add(at);
        Corridor next = adjacent(at).get().filter(pair -> !previous.contains(pair))
                .filter(pair -> labyrinth.hasCharAtPoint(freeChar, pair.getKey(), pair.getValue()))
                .map(pair -> new Corridor(pair.getKey(), pair.getValue(), findNext(pair, previous))).findFirst()
                .orElse(null);

        if (next != null && (next.getNext() != null || labyrinth.isExit(next.getX(), next.getY()))) {
            return next;
        }
        return null;
    }

    private Supplier<Stream<SimpleEntry<Integer, Integer>>> adjacent(SimpleEntry<Integer, Integer> to) {
        int x = to.getKey();
        int y = to.getValue();
        return () -> Stream.of(new SimpleEntry<>(x - 1, y), new SimpleEntry<>(x, y + 1), new SimpleEntry<>(x + 1, y),
                new SimpleEntry<>(x, y - 1));
    }

    private static Supplier<NoEscapeException> noEscape() {
        return () -> new NoEscapeException();
    }
}
