package com.craigtubb.labescape;

import static com.craigtubb.labescape.TestHelper.labyrinthWithClearExit;
import static com.craigtubb.labescape.TestHelper.labyrinthWithClearRoute;
import static com.craigtubb.labescape.TestHelper.labyrinthWithoutExit;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import com.craigtubb.exception.NoEscapeException;

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
