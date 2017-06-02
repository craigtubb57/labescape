package com.craigtubb;

import static com.craigtubb.LabEscape.FREE;
import static com.craigtubb.TestHelper.labyrinthWithExit;
import static com.craigtubb.TestHelper.labyrinthWithoutExit;
import static com.craigtubb.TestHelper.route;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RouteFinderTest {

    @Test
    public void withExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithExit()), FREE, 3, 1);
        Corridor result = finder.find();
        
        assertEquals(route(), result);
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExit()), FREE, 3, 1);
        finder.find();
    }
}
