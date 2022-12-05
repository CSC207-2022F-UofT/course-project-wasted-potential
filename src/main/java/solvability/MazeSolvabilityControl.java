package solvability;

import entities.DesignableMaze;

public class MazeSolvabilityControl {
    private MazeSolvableInBoundary mazeSolvabilityInBoundary;

    public MazeSolvabilityControl(MazeSolvableInBoundary mazeSolvabilityInBoundary) {
        this.mazeSolvabilityInBoundary = mazeSolvabilityInBoundary;
    }

    public MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze) {
        return mazeSolvabilityInBoundary.checkMazeSolvability(maze);
    }
}
