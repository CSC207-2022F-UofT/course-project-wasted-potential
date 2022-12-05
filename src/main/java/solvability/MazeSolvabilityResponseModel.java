package solvability;

/**
 * The type Maze solvability response model.
 */
public class MazeSolvabilityResponseModel {
    private boolean isSolvable;
    private String message;
    private String messageColor;

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
