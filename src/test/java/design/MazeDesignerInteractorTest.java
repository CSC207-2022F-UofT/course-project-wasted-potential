package design;

import entities.DesignableMaze;
import entities.Maze;
import entities.MazeSolver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MazeDesignerInteractorTest {
    @Test
    public void resetMazeTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        // randomize the maze first
        interactor.randomMaze();

        // reset the maze
        interactor.resetMaze();

        DesignableMaze dm = interactor.getDesignableMaze();
        char[][] state = dm.getState();

        // ensure the maze has the correct form
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (i == 0 || j == 0 || i == state.length - 1 || j == state[i].length - 1) {
                    // check if wall at border
                    Assertions.assertEquals(state[i][j], (char) Maze.getEncoding("wall"));
                } else if (i == 1 && j == 1) {
                    Assertions.assertEquals(state[i][j], (char) Maze.getEncoding("start"));
                } else if (i == state.length - 2 && j == state[i].length - 2) {
                    Assertions.assertEquals(state[i][j], (char) Maze.getEncoding("end"));
                }
                else {
                    // check if empty everywhere else
                    Assertions.assertEquals(state[i][j], (char) Maze.getEncoding("empty"));
                }
            }
        }

    }

    @Test
    public void buildWallTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.buildWall(3, 3);

        DesignableMaze dm = interactor.getDesignableMaze();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[3][3], (char) Maze.getEncoding("wall"));
    }

    @Test
    public void removeWallTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.buildWall(3, 5);
        interactor.removeWall(3, 5);

        DesignableMaze dm = interactor.getDesignableMaze();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[3][3], (char) Maze.getEncoding("empty"));

    }

    @Test
    public void startPointTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.startPoint(4, 4);

        DesignableMaze dm = interactor.getDesignableMaze();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[4][4], (char) Maze.getEncoding("start"));

    }

    @Test
    public void endPointTest() {

        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.endPoint(7, 4);

        DesignableMaze dm = interactor.getDesignableMaze();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[7][4], (char) Maze.getEncoding("end"));
    }

    @Test
    public void randomMazeTest() {

        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.randomMaze();

        DesignableMaze dm = interactor.getDesignableMaze();

        Assertions.assertTrue(MazeSolver.checkMazeSolvability(dm));
    }

    @Test
    public void getMazeStateTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.buildWall(3, 3);

        char[][] mazeState = interactor.getMazeState();
        DesignableMaze dm = interactor.getDesignableMaze();

        Assertions.assertEquals(mazeState[3][3], dm.getState()[3][3]);
    }


}
