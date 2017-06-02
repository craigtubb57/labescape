package com.craigtubb;

public class RoutePainter {

    private Labyrinth labyrinth;
    private Corridor routeStart;
    
    public RoutePainter(Labyrinth labyrinth, Corridor routeStart) {
        this.labyrinth = labyrinth;
        this.routeStart = routeStart;
    }
    
    public Labyrinth paint() {
        //paint route
        return labyrinth;
    }
    
    private void paintCorridor(Corridor corridor) {
        
    }
}
