package navigation;

/**
 * An exception for the maze navigation use case.
 * Informs the user that their attempted move is invalid.
 *
 * @author Oscar Tuvey
 */
public class InvalidMove extends RuntimeException {

    private final int[] requestedPosition;

    /**
     * The constructor for the InvalidMove exception.
     *
     * @param message           the message to be displayed to the user
     * @param requestedPosition the attempted cell to enter
     */
    public InvalidMove(String message, int[] requestedPosition) {
        super(message);
        this.requestedPosition = requestedPosition;
    }

    /**
     * Get requested position.
     *
     * @return the requested position
     */
    public int[] getRequestedPosition() {
        return this.requestedPosition;
    }
}
