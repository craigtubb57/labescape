package com.craigtubb.labescape;

import static com.craigtubb.labescape.TestHelper.labyrinthWithClearExit;
import static com.craigtubb.labescape.TestHelper.labyrinthWithClearRoute;
import static com.craigtubb.labescape.TestHelper.labyrinthWithoutExit;
import static com.craigtubb.labescape.TestHelper.route;
import static org.junit.Assert.*;

import org.junit.Test;

import com.craigtubb.exception.NoEscapeException;
import com.craigtubb.labescape.LabEscape;

public class LabEscapeTest {

    @Test
    public void withExit() throws NoEscapeException {
        char[][] result = LabEscape.drawPathForEscape(labyrinthWithClearExit(), 3, 1);
        
        assertArrayEquals(labyrinthWithClearRoute(), result);
    }

    @Test(expected = NoEscapeException.class)
    public void withoutExit() throws NoEscapeException {
        LabEscape.drawPathForEscape(labyrinthWithoutExit(), 3, 1);
    }

}
