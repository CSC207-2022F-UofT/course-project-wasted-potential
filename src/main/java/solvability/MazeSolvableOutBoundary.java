package solvability;

/**
 * The interface Maze solvable out boundary.
 */
public interface MazeSolvableOutBoundary {
    /**
     * Report solvability maze solvability response model.
     *
     * @param solvable the solvable
     * @return the maze solvability response model
     */
    MazeSolvabilityResponseModel reportSolvability(boolean solvable);
}
