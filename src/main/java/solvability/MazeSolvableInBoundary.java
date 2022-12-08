package solvability;

import entities.DesignableMaze;

/**
 * The interface Maze solvable in boundary.
 */
public interface MazeSolvableInBoundary {
    /**
     * Check maze solvability maze solvability response model.
     *
     * @param maze the maze
     * @return the maze solvability response model
     */
    MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze);
}
