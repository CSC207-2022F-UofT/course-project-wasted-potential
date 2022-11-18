package SolvabilityChecker;

import entities.DesignableMaze;

public class MazeSolvabilityControl {
    private MazeSolvableInBoundary maze_solvability_in_boundary;

    public MazeSolvabilityControl(MazeSolvableInBoundary maze_solvability_in_boundary) {
        this.maze_solvability_in_boundary = maze_solvability_in_boundary;
    }

    public void checkMazeSolvability(DesignableMaze maze) {
        maze_solvability_in_boundary.checkMazeSolvability(maze);
    }
}
