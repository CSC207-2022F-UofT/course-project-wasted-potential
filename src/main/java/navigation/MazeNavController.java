package navigation;

import entities.GameState;

/**
 * The controller for the maze navigation use case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavController {

    private final MazeNavInputBoundary userInput;

    /**
     * The constructor for the MazeNavController class.
     *
     * @param userInput the input boundary for the maze navigation use case
     */
    public MazeNavController(MazeNavInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * Creates a response Model using a given keyStroke, currentPosition, and maze.
     *
     * @param keyStroke the user input
     * @param maze the maze being played
     * @return a response model for the maze navigation use case which is returned to the view
     */
    public MazeNavResponseModel create(char keyStroke, int[] position, GameState maze) {
        MazeNavRequestModel requestModel = new MazeNavRequestModel(keyStroke, position, maze);

        return userInput.create(requestModel);
    }
}
