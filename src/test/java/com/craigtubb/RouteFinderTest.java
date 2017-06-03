package com.craigtubb;

import static com.craigtubb.TestHelper.labyrinthWithClearExit;
import static com.craigtubb.TestHelper.labyrinthWithClearExitAndClosedLoop;
import static com.craigtubb.TestHelper.labyrinthWithClearExitAndOpenLoop;
import static com.craigtubb.TestHelper.labyrinthWithUnclearExit;
import static com.craigtubb.TestHelper.labyrinthWithoutExit;
import static com.craigtubb.TestHelper.labyrinthWithoutExitAndClosedLoop;
import static com.craigtubb.TestHelper.labyrinthWithoutExitAndOpenLoop;
import static com.craigtubb.TestHelper.route;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.craigtubb.domain.Corridor;
import com.craigtubb.domain.Labyrinth;
import com.craigtubb.exception.NoEscapeException;

public class RouteFinderTest {

    @Test
    public void withClearExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithClearExit()), 3, 1);
        Corridor result = finder.find();

        assertEquals(route(), result);
    }

    @Test
    public void withUnclearExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithUnclearExit()), 3, 1);
        Corridor result = finder.find();

        assertEquals(route(), result);
    }

    @Test
    public void withClearExitAndClosedLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithClearExitAndClosedLoop()), 3, 1);
        Corridor result = finder.find();

        assertEquals(route(), result);
    }

    @Test
    public void withClearExitAndOpenLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithClearExitAndOpenLoop()), 3, 1);
        Corridor result = finder.find();

        assertEquals(route(), result);
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExit()), 3, 1);
        finder.find();
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExitAndClosedLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExitAndClosedLoop()), 3, 1);
        finder.find();
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExitAndOpenLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExitAndOpenLoop()), 3, 1);
        finder.find();
    }
}
