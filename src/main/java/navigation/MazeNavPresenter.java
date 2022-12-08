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
     * @param responseModel a response model containing the old position of the icon and the new position of the icon
     * @return the response model to be returned to the controller and subsequently to the view
     */
    @Override
    public MazeNavResponseModel moveIcon(MazeNavResponseModel responseModel) {

        return responseModel;
    }

    /**
     * Returns an InvalidMove exception back to the controller and subsequently to the view
     *
     * @param error an error message to be returned
     * @param requestedPosition the attempted cell to enter
     * @return an exception to be returned to the controller and subsequently to the view
     */
    @Override
    public MazeNavResponseModel prepareFailView(String error, int[] requestedPosition) {
        throw new InvalidMove(error, requestedPosition);
    }
}
