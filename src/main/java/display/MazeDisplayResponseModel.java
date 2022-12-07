package display;

import entities.GameState;

/**
 * The output data for the maze display use case.
 *
 * @author Oscar Tuvey
 */
public class MazeDisplayResponseModel {

    private final GameState maze;

    /**
     * The constructor for the MazeDisplayResponseModel class.
     *
     * @param maze a GameState object representing the maze to be played
     */
    public MazeDisplayResponseModel(GameState maze) {
        this.maze = maze;
    }

    /**
     * A getter method which returns the GameState attribute.
     *
     * @return the maze of the response model
     */
    public GameState getMaze() {
        return this.maze;
    }
}
