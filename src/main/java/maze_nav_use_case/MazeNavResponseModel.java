package maze_nav_use_case;

/**
 * The Output Data for the Maze Navigation Use Case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavResponseModel {

    int[] requestedPosition;

    /**
     * The constructor for the MazeNavResponseModel.
     *
     * @param requestedPosition the requested position of the icon
     */
    public MazeNavResponseModel(int[] requestedPosition) {
        this.requestedPosition = requestedPosition;
    }

    /**
     * A getter method which returns the icon's requested position.
     *
     * @return requestedPosition an array representing the icon's requested position
     */
    public int[] getRequestedPosition() {
        return this.requestedPosition;
    }

}


