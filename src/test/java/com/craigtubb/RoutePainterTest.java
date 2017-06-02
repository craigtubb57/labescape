package com.craigtubb;

import static com.craigtubb.TestHelper.labyrinthWithClearExit;
import static com.craigtubb.TestHelper.labyrinthWithClearRoute;
import static com.craigtubb.TestHelper.route;
import static org.junit.Assert.assertEquals;
import static com.craigtubb.LabEscape.*;

import org.junit.Test;

public class RoutePainterTest {

    @Test
    public void withExit() {
        RoutePainter painter = new RoutePainter(new Labyrinth(labyrinthWithClearExit()), route(), PATH);
        Labyrinth result = painter.paint();

        assertEquals(new Labyrinth(labyrinthWithClearRoute()), result);
    }
}
