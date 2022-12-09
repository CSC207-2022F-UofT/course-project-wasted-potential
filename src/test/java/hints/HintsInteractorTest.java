package hints;

import entities.GameState;
import entities.MazeCell;
import entities.PublishedMaze;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.zip.DataFormatException;

import databases.MazeDatabase;

public class HintsInteractorTest {

    @Test
    void hintTest1() throws FileNotFoundException, DataFormatException {
        HintGeneratorPresenter hintGeneratorPresenter = new HintGeneratorPresenter();
        HintGeneratorInteractor hintGeneratorInteractor = new HintGeneratorInteractor(hintGeneratorPresenter);
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
        GameState maze = new GameState(pm.getAuthor(), pm.getName(), pm.getPublished(), pm.getPublishDate(), pm.getState(), pm.getStartPosition(), pm.getNumRow(), pm.getNumCol(), 0, pm.getStartPosition().clone());
        List<MazeCell> hint = hintGeneratorInteractor.generateHint(maze).getHint();
        int[][] expected_path = {{2, 1}, {3, 1}, {4, 1}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 5}, {5, 6}, {5, 7}, {5, 8}, {5, 9}, {6, 9}, {7, 9},  {7, 10}, {7, 11}, {8, 11}, {9, 11}};
        List<MazeCell> expected = new ArrayList<>();
        for (int[] cell : expected_path) {
            expected.add(new MazeCell(cell[0], cell[1]));
        }
        Assertions.assertEquals(expected, hint);
    }
    @Test
    void hintTest2() throws FileNotFoundException, DataFormatException {
        HintGeneratorPresenter hintGeneratorPresenter = new HintGeneratorPresenter();
        HintGeneratorInteractor hintGeneratorInteractor = new HintGeneratorInteractor(hintGeneratorPresenter);
        MazeDatabase md;
        try {
            md = new MazeDatabase("./mazes.csv");
        }
        catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        } catch (ParseException e) {
            throw new DataFormatException("Creation date is incorrect.");
        }
        PublishedMaze pm = md.retrieveMaze(1);
        GameState maze = new GameState(pm.getAuthor(), pm.getName(), pm.getPublished(), pm.getPublishDate(), pm.getState(), pm.getStartPosition(), pm.getNumRow(), pm.getNumCol(), 1, pm.getStartPosition().clone());
        List<MazeCell> hint = hintGeneratorInteractor.generateHint(maze).getHint();
        int[][] expected_path = {{1, 2}, {1, 3}, {2, 3}, {3, 3}, {3, 4}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}, {7, 6}, {7, 7}, {7, 8}, {7, 9},  {7, 10}, {7, 11}, {8, 11}, {9, 11}};
        List<MazeCell> expected = new ArrayList<>();
        for (int[] cell : expected_path) {
            expected.add(new MazeCell(cell[0], cell[1]));
        }
        Assertions.assertEquals(expected, hint);
    }
}
