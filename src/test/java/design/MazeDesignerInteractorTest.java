package design;

import entities.DesignableMaze;
import entities.Maze;
import entities.MazeSolver;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class MazeDesignerInteractorTest {
    @Test
    public void resetMazeTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        // randomize the maze first
        interactor.randomMaze();

        // reset the maze
        interactor.resetMaze();

        DesignableMaze dm = interactor.getDm();
        char[][] state = dm.getState();

        // ensure the maze has the correct form
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                if (i == 0 || j == 0 || i == state.length - 1 || j == state[i].length - 1) {
                    // check if wall at border
                    Assertions.assertEquals(state[i][j], (char) Maze.ENCODING.get("wall"));
                } else if (i == 1 && j == 1) {
                    Assertions.assertEquals(state[i][j], (char) Maze.ENCODING.get("start"));
                } else if (i == state.length - 2 && j == state[i].length - 2) {
                    Assertions.assertEquals(state[i][j], (char) Maze.ENCODING.get("end"));
                }
                else {
                    // check if empty everywhere else
                    Assertions.assertEquals(state[i][j], (char) Maze.ENCODING.get("empty"));
                }
            }
        }

    }

    @Test
    public void buildWallTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.buildWall(3, 3);

        DesignableMaze dm = interactor.getDm();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[3][3], (char) Maze.ENCODING.get("wall"));
    }

    @Test
    public void removeWallTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.buildWall(3, 5);
        interactor.removeWall(3, 5);

        DesignableMaze dm = interactor.getDm();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[3][3], (char) Maze.ENCODING.get("empty"));

    }

    @Test
    public void startPointTest() {
        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.startPoint(4, 4);

        DesignableMaze dm = interactor.getDm();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[4][4], (char) Maze.ENCODING.get("start"));

    }

    @Test
    public void endPointTest() {

        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.endPoint(7, 4);

        DesignableMaze dm = interactor.getDm();
        char[][] state = dm.getState();

        Assertions.assertEquals(state[7][4], (char) Maze.ENCODING.get("end"));
    }

    @Test
    public void randomMazeTest() {

        MazeDesignerOutputBoundary outputBoundary = new MazeDesignerPresenter();
        MazeDesignerInteractor interactor = new MazeDesignerInteractor(outputBoundary);

        interactor.randomMaze();

        DesignableMaze dm = interactor.getDm();

        Assertions.assertTrue(MazeSolver.checkMazeSolvability(dm));
    }



}
