package maze_nav_use_case;

/**
 * The Input Boundary for the Maze Navigation Use Case.
 *
 * @author Oscar Tuvey
 */
public interface MazeNavInputBoundary {

    /**
     * Creates a Response Model using a given Request Model.
     *
     * @param requestModel a Request Model containing the key stroke, the requested position, the current position, and the maze
     * @return a Response Model
     */
    MazeNavResponseModel create(MazeNavRequestModel requestModel);
}
