package solvability;

import entities.DesignableMaze;
import entities.MazeSolver;

/**
 * The type Maze solvability interactor.
 */
public class MazeSolvabilityInteractor implements MazeSolvableInBoundary {
    private final MazeSolvableOutBoundary mazeSolvableOutBoundary;

    /**
     * Instantiates a new Maze solvability interactor.
     *
     * @param mazeSolvableOutBoundary the maze solvable out boundary
     */
    public MazeSolvabilityInteractor(MazeSolvableOutBoundary mazeSolvableOutBoundary) {
        this.mazeSolvableOutBoundary = mazeSolvableOutBoundary;
    }
    public MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze) {
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        return mazeSolvableOutBoundary.reportSolvability(isSolvable);
    }


}
