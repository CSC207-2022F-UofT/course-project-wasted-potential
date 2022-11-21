package SolvabilityChecker;

import entities.DesignableMaze;
import entities.MazeSolver;

public class MazeSolvabilityInteractor implements MazeSolvableInBoundary {
    private MazeSolvableOutBoundary mazeSolvableOutBoundary;

    public MazeSolvabilityInteractor(MazeSolvableOutBoundary mazeSolvableOutBoundary) {
        this.mazeSolvableOutBoundary = mazeSolvableOutBoundary;
    }
    public void checkMazeSolvability(DesignableMaze maze) {
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        if (isSolvable) {
            mazeSolvableOutBoundary.reportSuccess();
        }
        else {
            mazeSolvableOutBoundary.reportFailure();
        }
    }


}
