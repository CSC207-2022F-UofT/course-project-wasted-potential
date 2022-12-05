package retrieval;

/**
 * The input boundary for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */

public interface MazeRetrieverInputBoundary {

    /**
     * Creates a response model using a given request model.
     *
     * @param requestModel a request model containing the user's username
     * @return a response model
     */
    MazeRetrieverResponseModel create(MazeRetrieverRequestModel requestModel);

}
