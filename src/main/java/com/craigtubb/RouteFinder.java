package com.craigtubb;

import java.util.AbstractMap;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.AbstractMap.SimpleEntry;

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
        SimpleEntry<Integer, Integer> none = new SimpleEntry<>(-1, -1);
        Corridor startCorridor = new Corridor(startX, startY, findNext(start, none));
        if (startCorridor.getNext() == null) {
            throw new NoEscapeException();
        }
        return startCorridor;
    }

    private Corridor findNext(SimpleEntry<Integer, Integer> at, SimpleEntry<Integer, Integer> ignoring) {
        Corridor next = adjacent(at).get().filter(pair -> !pair.equals(ignoring)).filter(pair -> labyrinth.hasCharAtPoint(freeChar, pair.getKey(), pair.getValue())).map(pair -> new Corridor(pair.getKey(), pair.getValue(), findNext(pair, at))).peek(System.out::println).findFirst().orElse(null);
        
        if (next != null && (next.getNext() != null || labyrinth.isExit(next.getX(), next.getY()))) {
            return next;
        }
        return null;
    }
    
    private Supplier<Stream<SimpleEntry<Integer, Integer>>> adjacent(SimpleEntry<Integer, Integer> to) {
        int x = to.getKey();
        int y = to.getValue();
        return () -> Stream.of(new SimpleEntry<>(x - 1, y), new SimpleEntry<>(x + 1, y), new SimpleEntry<>(x, y - 1), new SimpleEntry<>(x, y + 1));
    }
    
    private static Supplier<NoEscapeException> noEscape() {
        return () -> new NoEscapeException();
    }
}
