package retrieval;

import java.util.ArrayList;

/**
 * The use case interactor for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */

public class MazeRetrieverInteractor implements MazeRetrieverInputBoundary {

    private final MazeRetrieverDsGateway mazeRetrieverDsGateway;
    private final MazeRetrieverOutputBoundary mazeRetrieverOutputBoundary;

    /**
     * The constructor for the MazeRetrieverInteractor class.
     *
     * @param mazeRetrieverDsGateway the data access interface for the maze retriever use case
     * @param mazeRetrieverOutputBoundary the output boundary for the maze retriever use case
     */
    public MazeRetrieverInteractor(MazeRetrieverDsGateway mazeRetrieverDsGateway, MazeRetrieverOutputBoundary mazeRetrieverOutputBoundary) {
        this.mazeRetrieverDsGateway = mazeRetrieverDsGateway;
        this.mazeRetrieverOutputBoundary = mazeRetrieverOutputBoundary;
    }

    /**
     * The implementation of the input boundary method.
     * Retrieves the list of mazes a user has played and not played.
     *
     * @param requestModel a request model containing the user's username
     * @return a response model containing the list of mazes a user has played and not played
     */
    @Override
    public MazeRetrieverResponseModel create(MazeRetrieverRequestModel requestModel) {
        ArrayList<Integer> played = mazeRetrieverDsGateway.retrievePlayed(requestModel.getUsername());
        ArrayList<Integer> notPlayed = mazeRetrieverDsGateway.retrieveNotPlayed(requestModel.getUsername());

        MazeRetrieverResponseModel responseModel = new MazeRetrieverResponseModel(played, notPlayed);


        return mazeRetrieverOutputBoundary.displayMazes(responseModel);
    }

}
