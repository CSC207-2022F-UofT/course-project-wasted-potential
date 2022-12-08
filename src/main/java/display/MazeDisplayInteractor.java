package display;

import entities.GameState;
import entities.PublishedMaze;

/**
 * The use case interactor for the maze display use case.
 *
 * @author Oscar Tuvey
 */
public class MazeDisplayInteractor implements MazeDisplayInputBoundary {

    final PlayerDsGateway playerDsGateway;
    final MazeDsGateway mazeDsGateway;
    final MazeDisplayOutputBoundary outputBoundary;

    /**
     * The constructor for the MazeDisplayInteractor class.
     *
     * @param mazeDsGateway the data Access interface to retrieve the maze
     * @param playerDsGateway the data access interface to add the maze to the list of played mazes
     * @param outputBoundary the output boundary for the maze display use case
     */
    public MazeDisplayInteractor(PlayerDsGateway playerDsGateway, MazeDsGateway mazeDsGateway,
                                 MazeDisplayOutputBoundary outputBoundary) {

        this.playerDsGateway = playerDsGateway;
        this.mazeDsGateway = mazeDsGateway;
        this.outputBoundary = outputBoundary;
    }

    /**
     * The implementation of the input boundary method.
     * Creates a response Model to return to the controller in the view.
     * It also checks whether a move is valid and whether the move completes the maze.
     *
     * @param requestModel a request model containing the user's username and a mazeID
     * @return a response model containing the list of played mazes and the list of not played mazes
     */
    @Override
    public MazeDisplayResponseModel create(MazeDisplayRequestModel requestModel) {
        playerDsGateway.addToPlayed(requestModel.getMazeID(), requestModel.getUsername());

        PublishedMaze publishedMaze = mazeDsGateway.retrieveMaze(requestModel.getMazeID());
        GameState maze = new GameState(publishedMaze.getAuthor(), publishedMaze.getName(), publishedMaze.getPublished(), publishedMaze.getPublishDate(), publishedMaze.getState(), publishedMaze.getStartPosition(), publishedMaze.getNumRow(), publishedMaze.getNumCol(), requestModel.getMazeID(), publishedMaze.getStartPosition());

        MazeDisplayResponseModel responseModel = new MazeDisplayResponseModel(maze);

        return outputBoundary.displayMaze(responseModel);
    }
}
