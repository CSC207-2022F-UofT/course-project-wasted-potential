package screens;

import navigation.*;

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
     * Returns a MazeComplete exception back to the controller and subsequently to the view.
     *
     * @param message a message to notify the user that the maze is complete
     * @return an exception to be returned to the controller and subsequently to the view
     */
    @Override
    public MazeNavResponseModel mazeComplete(String message) {

        throw new MazeComplete(message);
    }

    /**
     * Returns an InvalidMove exception back to the controller and subsequently to the view
     *
     * @param error an error message to be returned
     * @return an exception to be returned to the controller and subsequently to the view
     */
    @Override
    public MazeNavResponseModel prepareFailView(String error) {

        throw new InvalidMove(error);
    }
}
