package retrieval;

import retrieval.*;

/**
 * The Presenter for the Maze Retriever Use Case.
 *
 * @author Oscar Tuvey
 */
public class MazeRetrieverPresenter implements MazeRetrieverOutputBoundary {

    /**
     * Returns a response model back to the controller.
     *
     * @param responseModel a response model containing a list of mazes
     * @return the response model to be returned to the controller and subsequently to the view
     */
    @Override
    public MazeRetrieverResponseModel displayMazes(MazeRetrieverResponseModel responseModel) {
        return responseModel;
    }

}
