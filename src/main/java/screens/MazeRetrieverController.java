package screens;

import retrieval.*;

/**
 * The controller for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */
public class MazeRetrieverController {

    final MazeRetrieverInputBoundary userInput;

    /**
     * The constructor for the MazeRetrieverController class.
     *
     * @param userInput the use case interactor for the maze retriever use case
     */
    public MazeRetrieverController(MazeRetrieverInputBoundary userInput) {

        this.userInput = userInput;
    }

    /**
     * Creates a response model using a given username.
     *
     * @param username the user who's logged in
     * @return the output data for the maze retriever use case
     */
    MazeRetrieverResponseModel create(String username) {
        MazeRetrieverRequestModel requestModel = new MazeRetrieverRequestModel(username);

        return userInput.create(requestModel);
    }
}
