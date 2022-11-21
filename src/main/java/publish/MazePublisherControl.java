package publish;

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
     * @param mazeInfo the maze info
     */
    public void publishMaze(MazePublishedRequestModel mazeInfo) {
        inBoundary.publishMaze(mazeInfo);
    }
}
