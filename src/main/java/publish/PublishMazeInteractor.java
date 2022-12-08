package publish;

import entities.DesignableMaze;
import entities.SavedMaze;

/**
 * The interactor class for the use case of publishing mazes.
 */
public class PublishMazeInteractor implements PublishMazeInBoundary {

    private final PublishMazeOutBoundary outBoundary;

    /**
     * An attribute containing the gateway, generally the database.
     */
    final PublishMazeGateway gateway;

    /**
     * Instantiates a new PublishMazeInteractor.
     *
     * @param outBoundary the output boundary
     * @param gateway     the gateway
     */
    public PublishMazeInteractor(PublishMazeOutBoundary outBoundary, PublishMazeGateway gateway) {
        this.outBoundary = outBoundary;
        this.gateway = gateway;
    }

    /**
     * Publish the maze to the database.
     *
     * @param author the author
     * @param name   the maze name
     * @param designableMaze     the DesignableMaze being published
     * @return the PublishMazeResponseModel.
     */
    public PublishMazeResponseModel publishMaze(String author, String name, DesignableMaze designableMaze) {
        PublishMazeRequestModel mazeInfo = new PublishMazeRequestModel(author, name, designableMaze);
        MazePublisher maze = new MazePublisher(mazeInfo);
        SavedMaze savedMaze = maze.publishMaze();
        if (savedMaze != null) {
            gateway.storeMaze(savedMaze);
            PublishMazeResponseModel info = new PublishMazeResponseModel(savedMaze.getName(),
                                                                             savedMaze.getPublishDate());
            return this.outBoundary.reportSuccess(info);
        }
        else {
            this.outBoundary.reportFailure();
            return null;
        }
    }
}
