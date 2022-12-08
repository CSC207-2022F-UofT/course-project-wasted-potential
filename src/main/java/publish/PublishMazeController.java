package publish;

import entities.DesignableMaze;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller class for the use case of publishing mazes.
 */
public class PublishMazeController {
    private final PublishMazeInBoundary inputBoundary;

    /**
     * Instantiates a new PublishMazeController.
     *
     * @param inBoundary the input boundary, generally the interactor.
     */
    public PublishMazeController(PublishMazeInBoundary inBoundary) {
        this.inputBoundary = inBoundary;
    }

    /**
     * Publish the maze, given the following information.
     *
     * @param author the author
     * @param name   the maze's name
     * @param designableMaze     the DesignableMaze that is being published.
     * @return an ArrayList of information to be shown to the user.
     */
    public List<String> publishMaze(String author, String name, DesignableMaze designableMaze) {
        PublishMazeResponseModel mazeInfo = inputBoundary.publishMaze(author, name, designableMaze);
        ArrayList<String> displayedInfo = new ArrayList<>();
        displayedInfo.add(mazeInfo.getName());
        displayedInfo.add(mazeInfo.getPublishDate().toString());
        return displayedInfo;
    }
}
