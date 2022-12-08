package display;

/**
 * The presenter for the maze display use case.
 *
 * @author Oscar Tuvey
 */
public class MazeDisplayPresenter implements MazeDisplayOutputBoundary {


    /**
     * Returns a response model back to the controller
     *
     * @param responseModel a response model containing the maze to be played
     * @return the response model to be returned to the controller and subsequently to the view
     */
    @Override
    public MazeDisplayResponseModel displayMaze(MazeDisplayResponseModel responseModel) {
        return responseModel;
    }
}
