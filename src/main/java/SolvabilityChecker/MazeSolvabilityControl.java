package SolvabilityChecker;

import entities.DesignableMaze;

public class MazeSolvabilityControl {
    private MazeSolvableInBoundary mazeSolvabilityInBoundary;

    public MazeSolvabilityControl(MazeSolvableInBoundary mazeSolvabilityInBoundary) {
        this.mazeSolvabilityInBoundary = mazeSolvabilityInBoundary;
    }

    public void checkMazeSolvability(DesignableMaze maze) {
        mazeSolvabilityInBoundary.checkMazeSolvability(maze);
    }
}
