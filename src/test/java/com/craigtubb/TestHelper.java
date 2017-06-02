package com.craigtubb;

import static com.craigtubb.LabEscape.FREE;
import static com.craigtubb.LabEscape.PATH;
import static com.craigtubb.LabEscape.WALL;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestHelper {

    static char[][] labyrinthWithExit() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, FREE, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, FREE, FREE, WALL, FREE, FREE},
            {WALL, FREE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
        /* @formatter:on */
    }

    static char[][] labyrinthWithoutExit() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, FREE, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, FREE, FREE, WALL, FREE, WALL},//blocked exit
            {WALL, FREE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
        /* @formatter:on */
    }

    static char[][] labyrinthWithRoute() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, PATH, PATH, PATH, PATH, WALL, PATH, PATH, PATH, WALL},
            {WALL, PATH, WALL, WALL, PATH, WALL, PATH, WALL, PATH, WALL},
            {WALL, PATH, FREE, WALL, PATH, WALL, PATH, WALL, PATH, WALL},
            {WALL, FREE, WALL, WALL, PATH, PATH, PATH, WALL, PATH, PATH},
            {WALL, FREE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
        /* @formatter:on */
    }

    static Corridor route() {
        Corridor cor_4_9 = new Corridor(4, 9, null);
        Corridor cor_4_8 = new Corridor(4, 8, cor_4_9);
        Corridor cor_3_8 = new Corridor(3, 8, cor_4_8);
        Corridor cor_2_8 = new Corridor(2, 8, cor_3_8);
        Corridor cor_1_8 = new Corridor(1, 8, cor_2_8);
        Corridor cor_1_7 = new Corridor(1, 7, cor_1_8);
        Corridor cor_1_6 = new Corridor(1, 6, cor_1_7);
        Corridor cor_2_6 = new Corridor(2, 6, cor_1_6);
        Corridor cor_3_6 = new Corridor(3, 6, cor_2_6);
        Corridor cor_4_6 = new Corridor(4, 6, cor_3_6);
        Corridor cor_4_5 = new Corridor(4, 5, cor_4_6);
        Corridor cor_4_4 = new Corridor(4, 4, cor_4_5);
        Corridor cor_3_4 = new Corridor(3, 4, cor_4_4);
        Corridor cor_2_4 = new Corridor(2, 4, cor_3_4);
        Corridor cor_1_4 = new Corridor(1, 4, cor_2_4);
        Corridor cor_1_3 = new Corridor(1, 3, cor_1_4);
        Corridor cor_1_2 = new Corridor(1, 2, cor_1_3);
        Corridor cor_1_1 = new Corridor(1, 1, cor_1_2);
        Corridor cor_2_1 = new Corridor(2, 1, cor_1_1);
        Corridor cor_3_1 = new Corridor(3, 1, cor_2_1);
        return cor_3_1;
    }
}
