package retrieval;

import display.MazeDsGateway;
import entities.PublishedMaze;

import java.util.List;

/**
 * The use case interactor for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */

public class MazeRetrieverInteractor implements MazeRetrieverInputBoundary {

    private final MazeRetrieverDsGateway mazeRetrieverDsGateway;
    private final MazeDsGateway mazeDsGateway;
    private final MazeRetrieverOutputBoundary mazeRetrieverOutputBoundary;

    /**
     * The constructor for the MazeRetrieverInteractor class.
     *
     * @param mazeRetrieverOutputBoundary the output boundary for the maze retriever use case
     */
    public MazeRetrieverInteractor(MazeRetrieverDsGateway mazeRetrieverDsGateway,
                                   MazeRetrieverOutputBoundary mazeRetrieverOutputBoundary,
                                   MazeDsGateway mazeDsGateway) {
        this.mazeRetrieverDsGateway = mazeRetrieverDsGateway;
        this.mazeRetrieverOutputBoundary = mazeRetrieverOutputBoundary;
        this.mazeDsGateway = mazeDsGateway;
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
        // The facade currently is not being tested but could be in the future.
        MazeRetrieverFacade mazeRetrieverFacade = new MazeRetrieverFacade(mazeRetrieverDsGateway, mazeDsGateway);
        List<PublishedMaze> played = mazeRetrieverFacade.retrieveMazesPlayed(requestModel.getUsername());
        List<PublishedMaze> notPlayed = mazeRetrieverFacade.retrieveMazesNotPlayed(requestModel.getUsername());

        MazeRetrieverResponseModel responseModel = new MazeRetrieverResponseModel(played, notPlayed);

        return mazeRetrieverOutputBoundary.displayMazes(responseModel);
    }

}
