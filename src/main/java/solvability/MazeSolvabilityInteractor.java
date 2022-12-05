package solvability;

import entities.DesignableMaze;
import entities.MazeSolver;

public class MazeSolvabilityInteractor implements MazeSolvableInBoundary {
    private MazeSolvableOutBoundary mazeSolvableOutBoundary;

    public MazeSolvabilityInteractor(MazeSolvableOutBoundary mazeSolvableOutBoundary) {
        this.mazeSolvableOutBoundary = mazeSolvableOutBoundary;
    }
    public MazeSolvabilityResponseModel checkMazeSolvability(DesignableMaze maze) {
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        return mazeSolvableOutBoundary.reportSolvability(isSolvable);
    }


}
