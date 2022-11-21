package SolvabilityChecker;

import entities.DesignableMaze;

public class MazeSolvabilityInteractor implements MazeSolvableInBoundary {
    private MazeSolvableOutBoundary maze_solvable_out_boundary;

    public MazeSolvabilityInteractor(MazeSolvableOutBoundary maze_solvable_out_boundary) {
        this.maze_solvable_out_boundary = maze_solvable_out_boundary;
    }
    public void checkMazeSolvability(DesignableMaze maze) {
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        if (isSolvable) {
            maze_solvable_out_boundary.reportSuccess();
        }
        else {
            maze_solvable_out_boundary.reportFailure();
        }
    }


}
