package com.craigtubb;

import static com.craigtubb.TestHelper.labyrinthWithExit;
import static com.craigtubb.TestHelper.labyrinthWithRoute;
import static com.craigtubb.TestHelper.route;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoutePainterTest {

    @Test
    public void withExit() {
        RoutePainter painter = new RoutePainter(new Labyrinth(labyrinthWithExit()), route());
        Labyrinth result = painter.paint();

        assertEquals(new Labyrinth(labyrinthWithRoute()), result);
    }
}