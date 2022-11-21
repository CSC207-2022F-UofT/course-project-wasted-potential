package maze_nav_use_case;

/**
 * The Use Case Interactor for the Maze Naviagation Use Case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavInteractor implements MazeNavInputBoundary {

    MazeNavOutputBoundary outputBoundary;

    /**
     * The constructor for the MazeNavInteractor class.
     *
     * @param outputBoundary the Output Boundary for the Maze Navigation Use Case
     */
    public MazeNavInteractor(MazeNavOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public MazeNavResponseModel create(MazeNavRequestModel requestModel) {

        int[] requestedPosition = requestModel.getRequestedPosition();

        int x = requestedPosition[0];
        int y = requestedPosition[1];

        char[][] mazeState = requestModel.getMaze().getState();

        if (mazeState[x][y] == '#') {
            MazeNavResponseModel responseModel = new MazeNavResponseModel(requestModel.getMaze().getPosition());
            return outputBoundary.prepareFailView(responseModel);
        }

        else if (mazeState[x][y] == 'E') {
            MazeNavResponseModel responseModel = new MazeNavResponseModel(requestModel.getMaze().getPosition());
            return outputBoundary.mazeComplete(responseModel);
        }

        else {
            requestModel.getMaze().updatePosition(x, y);
            int[] newPosition = requestModel.getMaze().getPosition();
            MazeNavResponseModel responseModel = new MazeNavResponseModel(newPosition);
            return outputBoundary.moveIcon(responseModel);
        }
    }
}
