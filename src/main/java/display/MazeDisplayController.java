package display;

/**
 * The controller for the maze display use case.
 *
 * @author Oscar Tuvey
 */
public class MazeDisplayController {

    private final MazeDisplayInputBoundary userInput;

    /**
     * The constructor for the MazeDisplayController class.
     *
     * @param userInput the output data for the maze retriever use case
     */
    public MazeDisplayController(MazeDisplayInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * Creates a response model using a given username and mazeID.
     *
     * @param username the user who's logged in
     * @param mazeID the unique identifier for the maze
     * @return the Output Data for the Maze Display Use Case
     */
    public MazeDisplayResponseModel create(String username, Integer mazeID) {
        MazeDisplayRequestModel requestModel = new MazeDisplayRequestModel(username, mazeID);
        return userInput.create(requestModel);
    }
}
