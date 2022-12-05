package display;

/**
 * The input boundary for the maze display use case.
 *
 * @author Oscar Tuvey
 */
public interface MazeDisplayInputBoundary {

    /**
     * Creates a response model using a given request model.
     *
     * @param requestModel a request model containing the user's username and a mazeID
     * @return a response model
     */
    MazeDisplayResponseModel create(MazeDisplayRequestModel requestModel);

}
