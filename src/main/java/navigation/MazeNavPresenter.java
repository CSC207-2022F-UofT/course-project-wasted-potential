package navigation;

/**
 * The presenter for the maze navigation use case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavPresenter implements MazeNavOutputBoundary {

    /**
     * Returns a response model back to the controller.
     *
     * @param isComplete boolean which indicates if the maze is complete
     * @return isComplete
     */
    @Override
    public boolean moveIcon(boolean isComplete) {

        return isComplete;
    }

    /**
     * Returns an InvalidMove exception back to the controller and subsequently to the view
     *
     * @param error an error message to be returned
     * @param requestedPosition the attempted cell to enter
     * @return an exception to be returned to the controller and subsequently to the view
     */
    @Override
    public boolean prepareFailView(String error, int[] requestedPosition) {
        throw new InvalidMove(error, requestedPosition);
    }
}
