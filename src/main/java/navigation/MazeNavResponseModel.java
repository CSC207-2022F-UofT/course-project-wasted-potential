package navigation;

/**
 * The output data for the maze navigation use case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavResponseModel {

    private final int[] oldPosition;
    private final int[] newPosition;
    private final boolean isComplete;

    /**
     * The constructor for the MazeNavResponseModel.
     *
     * @param oldPosition the previous position of the icon
     * @param newPosition the new position of the icon
     * @param isComplete a boolean representing whether the maze has been completed
     */
    public MazeNavResponseModel(int[] oldPosition, int[] newPosition, boolean isComplete) {
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
        this.isComplete = isComplete;

    }

    /**
     * A getter method which returns the icon's old position.
     *
     * @return an array representing the icon's requested position
     */
    public int[] getOldPosition() {
        return this.oldPosition;
    }

    /**
     * A getter method which returns the icon's new position.
     *
     * @return an array representing the icon's requested position
     */
    public int[] getNewPosition() {
        return this.newPosition;
    }

    /**
     * A getter method which returns the icon's new position.
     *
     * @return an array representing the icon's requested position
     */
    public boolean getIsComplete() {
        return this.isComplete;
    }

}


