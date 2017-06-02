package com.craigtubb;

public class RoutePainter {

    private Labyrinth labyrinth;
    private Corridor routeStart;
    private char pathChar;
    
    public RoutePainter(Labyrinth labyrinth, Corridor routeStart, char pathChar) {
        this.labyrinth = labyrinth;
        this.routeStart = routeStart;
        this.pathChar = pathChar;
    }
    
    public Labyrinth paint() {
        paintCorridor(routeStart);
        return labyrinth;
    }
    
    private void paintCorridor(Corridor corridor) {
        if (corridor != null ) {
            labyrinth.setPoint(corridor.getX(), corridor.getY(), pathChar);
            paintCorridor(corridor.getNext());
        }
        
    }
}
