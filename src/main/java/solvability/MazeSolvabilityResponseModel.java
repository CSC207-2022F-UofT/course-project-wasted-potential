package solvability;

/**
 * The type Maze solvability response model.
 */
public class MazeSolvabilityResponseModel {
    private final boolean isSolvable;
    private final String message;
    private final String messageColor;

    /**
     * Instantiates a new Maze solvability response model.
     *
     * @param isSolvable   the is solvable
     * @param message      the message
     * @param messageColor the message color
     */
    public MazeSolvabilityResponseModel(boolean isSolvable, String message, String messageColor) {
        this.isSolvable = isSolvable;
        this.message = message;
        this.messageColor = messageColor;
    }

    /**
     * Gets is solvable.
     *
     * @return the is solvable
     */
    public boolean getIsSolvable() {
        return isSolvable;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets message color.
     *
     * @return the message color
     */
    public String getMessageColor() {
        return messageColor;
    }
}
