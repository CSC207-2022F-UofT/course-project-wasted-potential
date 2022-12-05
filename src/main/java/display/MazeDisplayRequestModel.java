package display;

/**
 * The input data for the maze display use case.
 *
 * @author Oscar Tuvey
 */
public class MazeDisplayRequestModel {

    private final String username;
    private final Integer mazeID;

    /**
     * The constructor for the MazeDisplayRequestModel class.
     *
     * @param username the user who's logged in
     * @param mazeID the unique identifier for the maze
     */
    public MazeDisplayRequestModel(String username, Integer mazeID) {
        this.username = username;
        this.mazeID = mazeID;
    }

    /**
     * A getter method which returns the username attribute.
     *
     * @return the username of the request model
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * A getter method which returns the mazeID attribute.
     *
     * @return the mazeID of the request model
     */
    public Integer getMazeID() {
        return this.mazeID;
    }


}
