package publish;

/**
 * The interface Maze published out boundary.
 */
public interface MazePublishedOutBoundary {
    /**
     * Report success.
     *
     * @param mazeInfo the maze info
     */
    void reportSuccess(MazePublishedResponseModel mazeInfo);

    /**
     * Report failure.
     */
    void reportFailure();
}
