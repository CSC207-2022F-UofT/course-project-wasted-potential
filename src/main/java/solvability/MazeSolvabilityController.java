package solvability;

import entities.DesignableMaze;

/**
 * The type Maze solvability controller.
 */
public class MazeSolvabilityController {
    private final MazeSolvableInBoundary mazeSolvabilityInBoundary;

    /**
     * Instantiates a new Maze solvability controller.
     *
     * @param mazeSolvabilityInBoundary the maze solvability in boundary
     */
    public MazeSolvabilityController(MazeSolvableInBoundary mazeSolvabilityInBoundary) {
        this.mazeSolvabilityInBoundary = mazeSolvabilityInBoundary;
    }

    /**
     * Check maze solvability maze solvability response model.
     *
     * @param maze the maze
     * @return the maze solvability response model
     */
    public MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze) {
        return mazeSolvabilityInBoundary.checkMazeSolvability(maze);
    }
}
