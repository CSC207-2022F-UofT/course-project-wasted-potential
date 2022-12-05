package navigation;

/**
 * The input boundary for the maze navigation use case.
 *
 * @author Oscar Tuvey
 */
public interface MazeNavInputBoundary {

    /**
     * Creates a response model using a given request model.
     *
     * @param requestModel a request model containing the keystroke, the requested position, the current position, and the maze
     * @return a response model
     */
    MazeNavResponseModel create(MazeNavRequestModel requestModel);
}
