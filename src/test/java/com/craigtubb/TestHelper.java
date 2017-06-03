package com.craigtubb;

import static com.craigtubb.domain.Labyrinth.FREE;
import static com.craigtubb.domain.Labyrinth.PATH;
import static com.craigtubb.domain.Labyrinth.WALL;

import java.awt.Point;

import com.craigtubb.domain.Corridor;

/**
 * Helper methods for testing LabEscape and its functions.
 * 
 * @author craigtubb
 *
 */
public class TestHelper {

    static char[][] labyrinthWithClearExit() {
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

    static char[][] labyrinthWithUnclearExit() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, FREE, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, FREE, FREE, WALL, FREE, FREE},
            {WALL, FREE, WALL, WALL, WALL, WALL, WALL, WALL, FREE, WALL},
            {WALL, FREE, FREE, FREE, FREE, FREE, FREE, FREE, WALL, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
        /* @formatter:on */
    }

    static char[][] labyrinthWithClearExitAndClosedLoop() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, FREE, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, FREE, FREE, WALL, FREE, FREE},
            {WALL, FREE, WALL, WALL, WALL, WALL, WALL, WALL, FREE, WALL},
            {WALL, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
        /* @formatter:on */
    }

    static char[][] labyrinthWithClearExitAndOpenLoop() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, FREE, WALL, FREE, WALL, FREE, FREE, FREE, WALL},
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

    static char[][] labyrinthWithoutExitAndClosedLoop() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, FREE, WALL, FREE, WALL, FREE, WALL, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, FREE, FREE, WALL, FREE, WALL},//blocked exit
            {WALL, FREE, WALL, WALL, WALL, WALL, WALL, WALL, FREE, WALL},
            {WALL, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
        /* @formatter:on */
    }

    static char[][] labyrinthWithoutExitAndOpenLoop() {
        /* @formatter:off */
        return new char[][] {
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, FREE, WALL, FREE, WALL, FREE, FREE, FREE, WALL},
            {WALL, FREE, WALL, WALL, FREE, FREE, FREE, WALL, FREE, WALL},//blocked exit
            {WALL, FREE, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL},
            {WALL, FREE, FREE, FREE, FREE, FREE, FREE, FREE, FREE, WALL},
            {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL}
        };
        /* @formatter:on */
    }

    static char[][] labyrinthWithClearRoute() {
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
        Corridor cor_4_9 = new Corridor(p(4, 9), null);
        Corridor cor_4_8 = new Corridor(p(4, 8), cor_4_9);
        Corridor cor_3_8 = new Corridor(p(3, 8), cor_4_8);
        Corridor cor_2_8 = new Corridor(p(2, 8), cor_3_8);
        Corridor cor_1_8 = new Corridor(p(1, 8), cor_2_8);
        Corridor cor_1_7 = new Corridor(p(1, 7), cor_1_8);
        Corridor cor_1_6 = new Corridor(p(1, 6), cor_1_7);
        Corridor cor_2_6 = new Corridor(p(2, 6), cor_1_6);
        Corridor cor_3_6 = new Corridor(p(3, 6), cor_2_6);
        Corridor cor_4_6 = new Corridor(p(4, 6), cor_3_6);
        Corridor cor_4_5 = new Corridor(p(4, 5), cor_4_6);
        Corridor cor_4_4 = new Corridor(p(4, 4), cor_4_5);
        Corridor cor_3_4 = new Corridor(p(3, 4), cor_4_4);
        Corridor cor_2_4 = new Corridor(p(2, 4), cor_3_4);
        Corridor cor_1_4 = new Corridor(p(1, 4), cor_2_4);
        Corridor cor_1_3 = new Corridor(p(1, 3), cor_1_4);
        Corridor cor_1_2 = new Corridor(p(1, 2), cor_1_3);
        Corridor cor_1_1 = new Corridor(p(1, 1), cor_1_2);
        Corridor cor_2_1 = new Corridor(p(2, 1), cor_1_1);
        Corridor cor_3_1 = new Corridor(p(3, 1), cor_2_1);
        return cor_3_1;
    }

    private static Point p(int x, int y) {
        return new Point(x, y);
    }
}
