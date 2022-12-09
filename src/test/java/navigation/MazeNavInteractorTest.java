package navigation;

import databases.MazeDatabase;
import entities.GameState;
import entities.PublishedMaze;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.zip.DataFormatException;

class MazeNavInteractorTest {

    @Test
    public void moveTest() throws FileNotFoundException, DataFormatException {
        MazeNavOutputBoundary mazeNavPresenter = new MazeNavPresenter();
        MazeNavInputBoundary mazeNavInteractor = new MazeNavInteractor(mazeNavPresenter);
        MazeDatabase md;
        try {
            md = new MazeDatabase("./mazes.csv");
        }
        catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        } catch (ParseException e) {
            throw new DataFormatException("Creation date is incorrect.");
        }
        PublishedMaze pm = md.retrieveMaze(0);
        GameState maze = new GameState(pm.getAuthor(), pm.getName(), pm.getPublished(), pm.getPublishDate(), pm.getState(), pm.getStartPosition(), pm.getNumRow(), pm.getNumCol(), 0, new int[] {5, 3});

        // moving up
        MazeNavRequestModel requestModel = new MazeNavRequestModel('w', maze.getPosition(), maze);
        boolean isComplete = mazeNavInteractor.create(requestModel);
        Assertions.assertFalse(isComplete);
        Assertions.assertTrue(Arrays.equals(maze.getPosition(), new int[] {4, 3}));
        // moving down
        requestModel = new MazeNavRequestModel('s', maze.getPosition(), maze);
        isComplete = mazeNavInteractor.create(requestModel);
        Assertions.assertFalse(isComplete);
        Assertions.assertTrue(Arrays.equals(maze.getPosition(), new int[] {5, 3}));
        // moving left
        requestModel = new MazeNavRequestModel('a', maze.getPosition(), maze);
        isComplete = mazeNavInteractor.create(requestModel);
        Assertions.assertFalse(isComplete);
        Assertions.assertTrue(Arrays.equals(maze.getPosition(), new int[] {5, 2}));
        // moving right
        requestModel = new MazeNavRequestModel('d', maze.getPosition(), maze);
        isComplete = mazeNavInteractor.create(requestModel);
        Assertions.assertFalse(isComplete);
        Assertions.assertTrue(Arrays.equals(maze.getPosition(), new int[] {5, 3}));
    }
    @Test
    public void mazeCompleteTest() throws FileNotFoundException, DataFormatException {
        MazeNavOutputBoundary mazeNavPresenter = new MazeNavPresenter();
        MazeNavInputBoundary mazeNavInteractor = new MazeNavInteractor(mazeNavPresenter);
        MazeDatabase md;
        try {
            md = new MazeDatabase("./mazes.csv");
        }
        catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        } catch (ParseException e) {
            throw new DataFormatException("Creation date is incorrect.");
        }
        PublishedMaze pm = md.retrieveMaze(0);
        GameState maze = new GameState(pm.getAuthor(), pm.getName(), pm.getPublished(), pm.getPublishDate(), pm.getState(), pm.getStartPosition(), pm.getNumRow(), pm.getNumCol(), 0, new int[] {15, 22});
        MazeNavRequestModel requestModel = new MazeNavRequestModel('d', maze.getPosition(), maze);
        boolean isComplete = mazeNavInteractor.create(requestModel);
        Assertions.assertTrue(isComplete);
    }

    @Test
    public void illegalMoveTest() throws FileNotFoundException, DataFormatException {
        MazeNavOutputBoundary mazeNavPresenter = new MazeNavPresenter();
        MazeNavInputBoundary mazeNavInteractor = new MazeNavInteractor(mazeNavPresenter);
        MazeDatabase md;
        try {
            md = new MazeDatabase("./mazes.csv");
        }
        catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        } catch (ParseException e) {
            throw new DataFormatException("Creation date is incorrect.");
        }
        PublishedMaze pm = md.retrieveMaze(0);
        GameState maze = new GameState(pm.getAuthor(), pm.getName(), pm.getPublished(), pm.getPublishDate(), pm.getState(), pm.getStartPosition(), pm.getNumRow(), pm.getNumCol(), 0, new int[] {1, 1});
        MazeNavRequestModel requestModel = new MazeNavRequestModel('w', maze.getPosition(), maze);
        Assertions.assertThrows(InvalidMove.class, () -> mazeNavInteractor.create(requestModel));
    }
}
