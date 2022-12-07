package navigation;

/**
 * An exception for the maze navigation use case.
 * Informs the user that their attempted move is invalid.
 *
 * @author Oscar Tuvey
 */
public class InvalidMove extends RuntimeException {

    /**
     * The constructor for the InvalidMove exception.
     *
     * @param message the message to be displayed to the user
     */
    public InvalidMove(String message) {
        super(message);
    }
}
