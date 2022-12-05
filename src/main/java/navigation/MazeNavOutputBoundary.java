package navigation;

/**
 * The output boundary for the maze navigation use case.
 *
 * @author Oscar Tuvey
 */
public interface MazeNavOutputBoundary {

    /**
     * Moves the icon to the requested position.
     *
     * @param responseModel a response model containing the maze state
     * @return a response model
     */
    MazeNavResponseModel moveIcon(MazeNavResponseModel responseModel);

    /**
     * Notifies the user that the requested move is invalid.
     *
     * @param error an error message to be returned
     * @return a response model
     */
    MazeNavResponseModel prepareFailView(String error);

}
