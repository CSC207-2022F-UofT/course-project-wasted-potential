package publish;

/**
 * The interface for the output boundary in the use case of publishing mazes.
 */
public interface PublishMazeOutBoundary {
    /**
     * Report success if the maze was published.
     *
     * @param mazeInfo the maze information in the form of a PublishMazeResponseModel.
     * @return the PublishMazeResponseModel
     */
    PublishMazeResponseModel reportSuccess(PublishMazeResponseModel mazeInfo);

    /**
     * Report failure if the maze was unable to be published correctly.
     */
    void reportFailure();
}
