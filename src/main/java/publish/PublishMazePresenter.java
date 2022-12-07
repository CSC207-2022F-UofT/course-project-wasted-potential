package publish;

/**
 * The type Maze publisher presenter.
 */
public class PublishMazePresenter implements PublishMazeOutBoundary {
    /**
     * Report success if the maze was published.
     *
     * @param mazeInfo the maze information in the form of a PublishMazeResponseModel.
     * @return the PublishMazeResponseModel
     */
    public PublishMazeResponseModel reportSuccess(PublishMazeResponseModel mazeInfo) {
        return mazeInfo;
    }
    /**
     * Report failure if the maze was unable to be published correctly.
     */
    public void reportFailure() {
        // Do nothing, as the print button has been disabled.
    }
}
