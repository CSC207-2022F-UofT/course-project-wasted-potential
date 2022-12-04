package navigation;

/**
 * An exception for the maze navigation use case.
 * Informs the user that they have completed the maze.
 *
 * @author Oscar Tuvey
 */
public class MazeComplete extends RuntimeException {

    /**
     * The constructor for the InvalidMove exception.
     *
     * @param message the message to be displayed to the user
     */
    public MazeComplete(String message) {
        super(message);
    }
}
