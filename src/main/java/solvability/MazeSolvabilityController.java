package solvability;

import entities.DesignableMaze;

public class MazeSolvabilityController {
    private final MazeSolvableInBoundary mazeSolvabilityInBoundary;

    public MazeSolvabilityController(MazeSolvableInBoundary mazeSolvabilityInBoundary) {
        this.mazeSolvabilityInBoundary = mazeSolvabilityInBoundary;
    }

    public MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze) {
        return mazeSolvabilityInBoundary.checkMazeSolvability(maze);
    }
}
