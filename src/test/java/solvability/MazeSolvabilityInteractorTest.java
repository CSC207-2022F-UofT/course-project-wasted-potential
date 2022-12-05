package solvability;

import entities.DesignableMaze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MazeSolvabilityInteractorTest {

    @Test
    void SolvableTest1() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'S', '.', '.'}, {'.', '#', '.'}, {'.', '.', 'E'}};
        DesignableMaze maze = new DesignableMaze(3, 3, mazeState, new int[] {0, 0}, new int[] {2, 2});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertTrue(resp.getIsSolvable());
        Assertions.assertEquals("This maze is solvable", resp.getMessage());
    }

    @Test
    void SolvableTest2() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'.', 'S', '.', '#'}, {'#', '#', '.', '#'}, {'E', '.', '.', '.'}};
        DesignableMaze maze = new DesignableMaze(3, 4, mazeState, new int[] {0, 1}, new int[] {2, 0});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertTrue(resp.getIsSolvable());
        Assertions.assertEquals("This maze is solvable", resp.getMessage());
    }

    @Test
    void UnsolvableTest1() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'S', '.', '#'}, {'#', '#', '.'}, {'.', '.', 'E'}};
        DesignableMaze maze = new DesignableMaze(3, 3, mazeState, new int[] {0, 0}, new int[] {2, 2});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertFalse(resp.getIsSolvable());
        Assertions.assertEquals( "This maze is not solvable", resp.getMessage());
    }

    @Test
    void UnsolvableTest2() {
        MazeSolvableOutBoundary presenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary interactor = new MazeSolvabilityInteractor(presenter);

        char[][] mazeState = {{'.', 'S', '.', '#'}, {'#', '#', '.', '#'}, {'E', '#', '.', '.'}};
        DesignableMaze maze = new DesignableMaze(3, 4, mazeState, new int[] {0, 1}, new int[] {2, 0});

        MazeSolvabilityResponseModel resp = interactor.checkMazeSolvability(maze);
        Assertions.assertFalse(resp.getIsSolvable());
        Assertions.assertEquals("This maze is not solvable", resp.getMessage());
    }
}
