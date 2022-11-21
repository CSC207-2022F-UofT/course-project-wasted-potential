package screens;

import entities.GameState;
import maze_nav_use_case.MazeNavInputBoundary;
import maze_nav_use_case.MazeNavRequestModel;
import maze_nav_use_case.MazeNavResponseModel;

/**
 * The Controller for the Maze Navigation Use Case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavController {

    final MazeNavInputBoundary userInput;

    /**
     * The constructor for the MazeNavController class.
     *
     * @param userInput the Output Data for the Maze Navigation Use Case
     */
    public MazeNavController(MazeNavInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * Creates a Response Model using a given keyStroke, currentPosition, and maze.
     *
     * @param keyStroke the user input
     * @param maze the maze being played
     * @return the Output Data for the Maze Navigation Use Case
     */
    MazeNavResponseModel create(char keyStroke, int[] position, GameState maze) {
        MazeNavRequestModel requestModel = new MazeNavRequestModel(keyStroke, position, maze);

        return userInput.create(requestModel);
    }
}
