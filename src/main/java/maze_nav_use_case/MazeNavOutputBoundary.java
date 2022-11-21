package maze_nav_use_case;

/**
 * The Output Boundary for the Maze Navigation Use Case.
 *
 * @author Oscar Tuvey
 */
public interface MazeNavOutputBoundary {

    /**
     * Moves the icon to the requested position.
     *
     * @param responseModel a Response Model containing the maze state
     * @return a Response Model
     */
    MazeNavResponseModel moveIcon(MazeNavResponseModel responseModel);

    /**
     * Notifies the user that the maze has been completed.
     *
     * @param responseModel a Response Model containing the maze state
     * @return a Response Model
     */
    MazeNavResponseModel mazeComplete(MazeNavResponseModel responseModel);

    /**
     * Notifies the user that the requested move is invalid.
     *
     * @param responseModel a Response Model containing the maze state
     * @return a Response Model
     */
    MazeNavResponseModel prepareFailView(MazeNavResponseModel responseModel);

    // This doesn't actually make any sense. How could a response model be
    // returned from a string
    // Unless you construct a bullshit response model just from a string with random information,
    // but that wouldnt make sense

    // For clarification, before the changes, mazeComplete and prepareFailView both had Strings as params
    // rather than response models
}
