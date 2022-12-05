package solvability;

import entities.DesignableMaze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MazeSolvabilityInteractorTest {

    @Test
    public void SolvableTest1() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'S', '.', '.'}, {'.', '#', '.'}, {'.', '.', 'E'}};
        DesignableMaze maze = new DesignableMaze(3, 3, mazeState, new int[] {0, 0}, new int[] {2, 2});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertTrue(resp.getIsSolvable());
        Assertions.assertEquals(resp.getMessage(), "This maze is solvable");
    }

    @Test
    public void SolvableTest2() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'.', 'S', '.', '#'}, {'#', '#', '.', '#'}, {'E', '.', '.', '.'}};
        DesignableMaze maze = new DesignableMaze(3, 4, mazeState, new int[] {0, 1}, new int[] {2, 0});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertTrue(resp.getIsSolvable());
        Assertions.assertEquals(resp.getMessage(), "This maze is solvable");
    }

    @Test
    public void UnsolvableTest1() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'S', '.', '#'}, {'#', '#', '.'}, {'.', '.', 'E'}};
        DesignableMaze maze = new DesignableMaze(3, 3, mazeState, new int[] {0, 0}, new int[] {2, 2});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertFalse(resp.getIsSolvable());
        Assertions.assertEquals(resp.getMessage(), "This maze is not solvable");
    }

    @Test
    public void UnsolvableTest2() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'.', 'S', '.', '#'}, {'#', '#', '.', '#'}, {'E', '#', '.', '.'}};
        DesignableMaze maze = new DesignableMaze(3, 4, mazeState, new int[] {0, 1}, new int[] {2, 0});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertFalse(resp.getIsSolvable());
        Assertions.assertEquals(resp.getMessage(), "This maze is not solvable");
    }
}
