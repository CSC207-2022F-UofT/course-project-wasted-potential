package publish;

/**
 * The interface Maze published in boundary.
 */
public interface MazePublishedInBoundary {
    /**
     * Publish maze.
     *
     * @param mazeInfo the maze info
     */
    public void publishMaze(MazePublishedRequestModel mazeInfo);
}
