package com.craigtubb;

import static com.craigtubb.TestHelper.labyrinthWithExit;
import static com.craigtubb.TestHelper.labyrinthWithoutExit;
import static com.craigtubb.TestHelper.labyrinthWithRoute;
import static com.craigtubb.TestHelper.route;
import static org.junit.Assert.*;

import org.junit.Test;

public class LabEscapeTest {

    @Test
    public void withExit() throws NoEscapeException {
        char[][] result = LabEscape.drawPathForEscape(labyrinthWithoutExit(), 3, 1);
        
        assertArrayEquals(labyrinthWithRoute(), result);
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExit() throws NoEscapeException {
        LabEscape.drawPathForEscape(labyrinthWithoutExit(), 3, 1);
    }

}
