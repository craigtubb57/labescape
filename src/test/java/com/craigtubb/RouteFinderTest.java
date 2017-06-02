package com.craigtubb;

import static com.craigtubb.TestHelper.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class RouteFinderTest {

    @Test
    public void withExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithExit()), 3, 1);
        Corridor result = finder.find();
        
        assertEquals(route(), result);
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExit()), 3, 1);
        finder.find(); 
    }
}
