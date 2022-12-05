package retrieval;

/**
 * The input data for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */
public class MazeRetrieverRequestModel {

    private final String username;

    /**
     * The constructor for the MazeRetrieverRequestModel class.
     *
     * @param username the user who's logged in
     */
    public MazeRetrieverRequestModel(String username) {
        this.username = username;
    }

    /**
     * A getter method which returns the username attribute.
     *
     * @return the username of the Request Model
     */
    public String getUsername() {
        return this.username;
    }
}
