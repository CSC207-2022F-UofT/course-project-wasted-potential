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
     * @param isComplete a boolean indicating if the maze is complete
     * @return boolean indiciating if the maze is complete
     */
    boolean moveIcon(boolean isComplete);

    /**
     * Notifies the user that the requested move is invalid.
     *
     * @param error an error message to be returned
     * @param requestedPosition the attempted cell to enter
     * @return a response model
     */
    boolean prepareFailView(String error, int[] requestedPosition);

}
