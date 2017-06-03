package com.craigtubb;

import com.craigtubb.domain.Corridor;
import com.craigtubb.domain.Labyrinth;

/**
 * Replaces free points in a given Labyrinth with path points, following a chain of Corridors starting with the given
 * Corridor.
 * 
 * @author craigtubb
 *
 */
public class RoutePainter {

    private Labyrinth labyrinth;
    private Corridor routeStart;

    public RoutePainter(Labyrinth labyrinth, Corridor routeStart) {
        this.labyrinth = labyrinth;
        this.routeStart = routeStart;
    }

    /**
     * Replaces free points in the Labyrinth with paths indicated by the starting Corridor.
     * 
     * @return The given Labyrinth with a path 'painted' on it.
     */
    public Labyrinth paint() {
        paintCorridor(routeStart);
        return labyrinth;
    }

    /*
     * Replace a free point in the given Labyrinth with a path specified by the given Corridor.
     */
    private void paintCorridor(Corridor corridor) {
        if (corridor != null) {
            labyrinth.setPath(corridor.getPoint());
            // Recurse and paint the next corridor
            paintCorridor(corridor.getNext());
        }

    }
}
