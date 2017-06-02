package com.craigtubb;

import static com.craigtubb.LabEscape.FREE;
import static com.craigtubb.TestHelper.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RouteFinderTest {

    @Test
    public void withClearExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithClearExit()), FREE, 3, 1);
        Corridor result = finder.find();
        
        assertEquals(route(), result);
    }
    
    @Test
    public void withUnclearExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithUnclearExit()), FREE, 3, 1);
        Corridor result = finder.find();
        
        assertEquals(route(), result);
    }
    
    @Test
    public void withClearExitAndClosedLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithClearExitAndClosedLoop()), FREE, 3, 1);
        Corridor result = finder.find();
        
        assertEquals(route(), result);
    }
    
    @Test
    public void withClearExitAndOpenLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithClearExitAndOpenLoop()), FREE, 3, 1);
        Corridor result = finder.find();
        
        assertEquals(route(), result);
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExit() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExit()), FREE, 3, 1);
        finder.find();
    }
    
    @Test(expected = NoEscapeException.class)
    public void withoutExitAndClosedLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExitAndClosedLoop()), FREE, 3, 1);
        finder.find();
    }
    
    @Test(expected = NoEscapeException.class)
    public void withoutExitAndOpenLoop() throws NoEscapeException {
        RouteFinder finder = new RouteFinder(new Labyrinth(labyrinthWithoutExitAndOpenLoop()), FREE, 3, 1);
        finder.find();
    }
}
