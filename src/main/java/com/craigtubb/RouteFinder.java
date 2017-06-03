package com.craigtubb;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.craigtubb.domain.Corridor;
import com.craigtubb.domain.Labyrinth;
import com.craigtubb.exception.NoEscapeException;

/**
 * Finds a route of free points in a Labyrinth, returning a Corridor representing the starting Point.
 * 
 * @author craigtubb
 *
 */
public class RouteFinder {

    private Labyrinth labyrinth;
    private int startX;
    private int startY;

    public RouteFinder(Labyrinth labyrinth, int startX, int startY) {
        this.labyrinth = labyrinth;
        this.startX = startX;
        this.startY = startY;
    }

    /**
     * Find the first route through the Labyrinth, returning a Corridor at the starting point. Directions are checked in
     * order of N, E, S, W.
     * 
     * @return A new Corridor at the starting point.
     * @throws NoEscapeException
     *             If no route to the exit was found.
     */
    public Corridor find() throws NoEscapeException {
        return Stream.of(new Point(startX, startY)).map(next()).filter(onRoute()).findFirst().orElseThrow(noEscape());
    }

    private Function<Point, Corridor> next() {
        return next(new ArrayList<>());
    }

    /*
     * Next point as a Corridor, recursing to populate the next next points as a chain.
     */
    private Function<Point, Corridor> next(List<Point> past) {
        return point -> new Corridor(point, findNext(point, past));
    }

    /**
     * Finds the next Corridor on the exit route from the given Point.
     * 
     * Algorithm:
     * <ul>
     * <li>Add given Point to past point list.</li>
     * <li>Get NSEW points from given Point.</li>
     * <li>Filter out those in the past.</li>
     * <li>Filter out those that are not free.</li>
     * <li>Map to next Corridor point candidates using recursion.</li>
     * <li>Filter out those that are not on an exit route.</li>
     * <li>Return the first next Corridor, or null if there are none.</li>
     * </ul>
     * 
     * @param at
     *            The Point from which to find the next Corridor.
     * @param past
     *            All the Points which have been previously analysed.
     * @return A new Corridor representing the next point on the exit route, or null if there is none.
     **/
    private Corridor findNext(Point at, List<Point> past) {
        past.add(at);
        Predicate<Point> contains = past::contains;
        Predicate<Point> free = labyrinth::freeAtPoint;
        // get NSEW Points, filter those from the past and those not free, map to
        return adjacent(at).get().filter(contains.negate()).filter(free).map(next(past)).filter(onRoute()).findFirst()
                .orElse(null);
    }

    /*
     * Supplies a Stream of new Points representing N, E, S, W from the given point, in that order.
     */
    private Supplier<Stream<Point>> adjacent(Point to) {
        // @formatter:off
        // X =        N  E  S  W
        // Y =           N  E  S   W
        int[] os = { -1, 0, 1, 0, -1 };
        // @formatter:on

        // For i = 0-4, returns new Point where x = os[i] and y = os[i + 1]
        return () -> IntStream.range(0, 4).boxed().map(i -> new Point(to.x + os[i], to.y + os[i + 1]));
    }

    /*
     * A given Corridor is potentially on an exit route if it's next Corridor is on an exit route, or it represents the
     * exit itself.
     */
    private Predicate<Corridor> onRoute() {
        return next -> next.getNext() != null || labyrinth.isExit(next.getPoint());
    }

    private static Supplier<NoEscapeException> noEscape() {
        return () -> new NoEscapeException();
    }
}
