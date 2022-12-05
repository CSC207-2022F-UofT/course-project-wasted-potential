package publish;

import entities.DesignableMaze;
import entities.SavedMaze;

/**
 * The interactor class for the use case of publishing mazes.
 */
public class PublishMazeInteractor implements PublishMazeInBoundary {

    private PublishMazeOutBoundary outBoundary;

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
     * @param dm     the DesignableMaze being published
     * @return the PublishMazeResponseModel.
     */
    public PublishMazeResponseModel publishMaze(String author, String name, DesignableMaze dm) {
        PublishMazeRequestModel mazeInfo = new PublishMazeRequestModel(author, name, dm);
        MazePublisher maze = new MazePublisher(mazeInfo);
        SavedMaze sm = maze.publishMaze();
        if (sm != null) {
            gateway.storeMaze(sm);
            PublishMazeResponseModel info = new PublishMazeResponseModel(sm.getName(),
                                                                             sm.getPublishDate());
            return this.outBoundary.reportSuccess(info);
        }
        else {
            this.outBoundary.reportFailure();
            return null;
        }
    }
}
