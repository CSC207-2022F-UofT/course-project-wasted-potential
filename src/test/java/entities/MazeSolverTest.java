package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MazeSolverTest {

    @Test
    public void MazeSolvableTest1() {
        char[][] mazeState = {{'S', '.', '.'}, {'.', '#', '.'}, {'.', '.', 'E'}};
        DesignableMaze maze = new DesignableMaze(3, 3, mazeState, new int[] {0, 0}, new int[] {2, 2});
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        Assertions.assertTrue(isSolvable);
    }

    @Test
    public void MazeSolvableTest2() {
        char[][] mazeState = {{'.', 'S', '.', '#'}, {'#', '#', '.', '#'}, {'E', '.', '.', '.'}};
        DesignableMaze maze = new DesignableMaze(3, 4, mazeState, new int[] {0, 1}, new int[] {2, 0});
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        Assertions.assertTrue(isSolvable);
    }

    @Test
    public void MazeUnsolvableTest1() {
        char[][] mazeState = {{'S', '.', '#'}, {'#', '#', '.'}, {'.', '.', 'E'}};
        DesignableMaze maze = new DesignableMaze(3, 3, mazeState, new int[] {0, 0}, new int[] {2, 2});
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        Assertions.assertFalse(isSolvable);
    }

    @Test
    public void MazeUnsolvableTest2() {
        char[][] mazeState = {{'.', 'S', '.', '#'}, {'#', '#', '.', '#'}, {'E', '#', '.', '.'}};
        DesignableMaze maze = new DesignableMaze(3, 4, mazeState, new int[] {0, 1}, new int[] {2, 0});
        boolean isSolvable = MazeSolver.checkMazeSolvability(maze);
        Assertions.assertFalse(isSolvable);
    }
}