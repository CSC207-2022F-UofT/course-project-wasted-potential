package publish;

import entities.DesignableMaze;

import java.util.ArrayList;

/**
 * The type Maze publisher control.
 */
public class MazePublisherControl {
    private MazePublishedInBoundary inBoundary;

    /**
     * Instantiates a new Maze publisher control.
     *
     * @param inBoundary the in boundary
     */
    public MazePublisherControl(MazePublishedInBoundary inBoundary) {
        this.inBoundary = inBoundary;
    }

    /**
     * Publish maze.
     *
     * @param author the author
     * @param name   the name
     * @param dm     the dm
     */
    public ArrayList<String> publishMaze(String author, String name, DesignableMaze dm) {
        MazePublishedResponseModel mazeInfo = inBoundary.publishMaze(author, name, dm);
        ArrayList<String> displayedInfo = new ArrayList<>();
        displayedInfo.add(mazeInfo.getId());
        displayedInfo.add(mazeInfo.getName());
        displayedInfo.add(mazeInfo.getPublishDate().toString());
        return displayedInfo;
    }
}
