package display;

/**
 * The output boundary for the maze display use case.
 *
 * @author Oscar Tuvey
 */
public interface MazeDisplayOutputBoundary {

    /**
     * Provides the view with the list of played mazes and not played mazes.
     *
     * @param responseModel a response model containing the maze to be played
     * @return a response model
     */
    MazeDisplayResponseModel displayMaze(MazeDisplayResponseModel responseModel);
}
