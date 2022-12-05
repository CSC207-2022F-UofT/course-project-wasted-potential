package retrieval;

/**
 * The output boundary for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */
public interface MazeRetrieverOutputBoundary {

    /**
     * Provides the view with a list of mazes to be displayed.
     *
     * @param responseModel a response model containing a list of mazes
     * @return a response model
     */
    MazeRetrieverResponseModel displayMazes(MazeRetrieverResponseModel responseModel);
}
