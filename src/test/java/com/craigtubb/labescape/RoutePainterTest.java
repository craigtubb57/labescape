package com.craigtubb.labescape;

import static com.craigtubb.labescape.TestHelper.labyrinthWithClearExit;
import static com.craigtubb.labescape.TestHelper.labyrinthWithClearRoute;
import static com.craigtubb.labescape.TestHelper.route;
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
