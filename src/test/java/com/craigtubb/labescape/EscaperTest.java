package com.craigtubb.labescape;

import static com.craigtubb.labescape.TestHelper.labExternalStart;
import static com.craigtubb.labescape.TestHelper.labInternalStart;

import org.junit.Test;

import com.craigtubb.exception.NoEscapeException;

public class EscaperTest {

    @Test(expected = NoEscapeException.class)
    public void internalStart() throws ArrayIndexOutOfBoundsException, NoEscapeException {
        Escaper.escape(labInternalStart());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void externalStart() throws ArrayIndexOutOfBoundsException, NoEscapeException {
        Escaper.escape(labExternalStart());
    }
}
