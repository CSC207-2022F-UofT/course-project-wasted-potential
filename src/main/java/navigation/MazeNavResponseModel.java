package navigation;

/**
 * The output data for the maze navigation use case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavResponseModel {

    private final int[] oldPosition;
    private final int[] newPosition;

    /**
     * The constructor for the MazeNavResponseModel.
     *
     * @param oldPosition the previous position of the icon
     * @param newPosition the new position of the icon
     */
    public MazeNavResponseModel(int[] oldPosition, int[] newPosition) {
        this.oldPosition = oldPosition;
        this.newPosition = newPosition;
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

}


