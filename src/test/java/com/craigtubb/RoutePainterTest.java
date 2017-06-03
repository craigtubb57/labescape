package com.craigtubb;

import static com.craigtubb.TestHelper.labyrinthWithClearExit;
import static com.craigtubb.TestHelper.labyrinthWithClearRoute;
import static com.craigtubb.TestHelper.route;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.craigtubb.domain.Labyrinth;
import com.craigtubb.labescape.RoutePainter;

public class RoutePainterTest {

    @Test
    public void withExit() {
        RoutePainter painter = new RoutePainter(new Labyrinth(labyrinthWithClearExit()), route());
        Labyrinth result = painter.paint();

        assertEquals(new Labyrinth(labyrinthWithClearRoute()), result);
    }
}
