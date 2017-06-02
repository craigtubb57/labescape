package com.craigtubb;

/**
 * Please implement your solution here
 */
public class LabEscape {

    public static final char WALL = 'O';
    public static final char FREE = ' ';
    public static final char PATH = '•';

    /**
     * @param labyrinth
     *            A labyrinth drawn on a matrix of characters. It's at least 4x4, can be a rectangle or a square.
     *            Walkable areas are represented with a space character, walls are represented with a big O character.
     *            The escape point is always on the border (see README)
     * @param startX
     *            Starting row number for the escape. 0 based.
     * @param startY
     *            Starting column number for the escape. 0 based.
     * @return A char matrix with the same labyrinth and a path drawn from the starting point to the escape
     * @throws NoEscapeException
     *             when no path exists to the outside, from the selected starting point
     */
    public static char[][] drawPathForEscape(char[][] labyrinth, int startX, int startY) throws NoEscapeException {

        /**
         * Thoughts:<br>
         * Convert 2d char array to tree of objects with root being starting point<br>
         * Each object has references to adjacent spaces<br>
         * Call recursive function to get adjacent space objects<br>
         * Break branch if end reach but not an exit<br>
         * Return immediately when exit found (exit = x/y == 0 or x/y == size - 1)<br>
         * Remaining tree will be single escape route<br>
         * Throw NoEscapeException if tree is empty<br>
         * Iterate escape route to update 2d char array with route<br>
         * Return updated 2d char array
         * 
         * Potential classes:<br>
         * Corridor (int x, int y, List<Corridor> corridors)<br>
         * RouteFinder (char[][] labyrinth, int startX, int startY)<br>
         * CorridorCreator (fromChar(char ch))<br>
         **/
        
        Labyrinth lab = new Labyrinth(labyrinth);
        RouteFinder finder = new RouteFinder(lab, FREE, startX, startY);
        RoutePainter painter = new RoutePainter(lab, finder.find());
        return painter.paint().getLabyrinth();
    }
}
