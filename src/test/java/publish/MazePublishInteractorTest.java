package publish;

import design.*;
import entities.PublishedMaze;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import databases.MazeDatabase;
import singletons.PublishedMazeSingleton;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Map;

public class MazePublishInteractorTest {
    @Test
    public void publishMazeTest() {
        PublishMazeOutBoundary outBoundary = new PublishMazePresenter();
        MazeDatabase database;
        try {
            database = new MazeDatabase("./mazes.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        } catch (ParseException e) {
            throw new RuntimeException("Creation date is incorrect.");
        }
        PublishMazeInteractor interactor = new PublishMazeInteractor(outBoundary, database);
        MazeDesignerOutputBoundary designerOutputBoundary = new MazeDesignerPresenter();
        MazeDesignerInputBoundary designerInputBoundary = new MazeDesignerInteractor(designerOutputBoundary);
        MazeDesignerController designerController = new MazeDesignerController(designerInputBoundary);
        designerController.resetMaze();
        PublishMazeResponseModel mazeInfo = interactor.publishMaze("authorName", "mazeName", designerController.getDesignableMaze());

        Assertions.assertEquals("mazeName", mazeInfo.getName());
        Assertions.assertEquals(LocalDate.now(), mazeInfo.getPublishDate());

        Map<Integer, PublishedMaze> mazes = database.getMazes();
        PublishedMaze publishedMaze = new PublishedMaze("authorName",
                "mazeName",
                true,
                LocalDate.now(),
                designerController.getDesignableMaze().getState(),
                designerController.getDesignableMaze().getStartLocation(),
                designerController.getDesignableMaze().getNumRow(),
                designerController.getDesignableMaze().getNumCol(),
                PublishedMazeSingleton.getId() - 1);
        Assertions.assertTrue(mazes.containsValue(publishedMaze));
    }

}
