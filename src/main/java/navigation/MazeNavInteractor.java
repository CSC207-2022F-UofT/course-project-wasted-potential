package navigation;

import entities.Maze;

/**
 * The use case interactor for the maze navigation use case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavInteractor implements MazeNavInputBoundary {

    private final MazeNavOutputBoundary outputBoundary;

    /**
     * The constructor for the MazeNavInteractor class.
     *
     * @param outputBoundary the output boundary for the maze navigation use case
     */
    public MazeNavInteractor(MazeNavOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * The implementation of the input boundary method.
     * Creates a response Model to return to the controller in the view.
     * It also checks whether a move is valid and whether the move completes the maze.
     *
     * @param requestModel a request model containing the keystroke, the requested position, the current position, and the maze
     * @return a response model containing the previous position and the new position of the icon
     */
    @Override
    public MazeNavResponseModel create(MazeNavRequestModel requestModel) {

        int[] position = requestModel.getPosition();
        char keyStroke = requestModel.getKeyStroke();
        int[] requestedPosition;

        if (keyStroke == 'w') {
            requestedPosition = new int[]{position[0], (position[1] + 1)};
        }

        else if (keyStroke == 'a') {
            requestedPosition = new int[]{position[0] - 1, position[1]};
        }

        else if (keyStroke == 's') {
            requestedPosition = new int[]{position[0], position[1] - 1};
        }

        else {
            requestedPosition = new int[]{position[0] + 1, position[1]};
        }

        int x = requestedPosition[0];
        int y = requestedPosition[1];

        char[][] mazeState = requestModel.getMaze().getState();

        if (mazeState[x][y] == Maze.getEncoding("wall")) {
            return outputBoundary.prepareFailView("Invalid move. Please try again.");
        }

        else {
            requestModel.getMaze().updatePosition(x, y);
            MazeNavResponseModel responseModel = new MazeNavResponseModel(requestModel.getPosition(),
                    requestedPosition, mazeState[x][y] == Maze.getEncoding("end"));
            requestModel.getMaze().updatePosition(x, y);
            return outputBoundary.moveIcon(responseModel);
        }
    }
}
