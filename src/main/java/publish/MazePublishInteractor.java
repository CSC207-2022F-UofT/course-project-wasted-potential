package publish;

import entities.DesignableMaze;
import entities.PublishedMaze;

/**
 * The type Maze publish interactor.
 */
public class MazePublishInteractor implements MazePublishedInBoundary{

    private MazePublishedOutBoundary outBoundary;

    /**
     * The Gateway.
     */
    final MazePublisherGateway gateway;

    /**
     * Instantiates a new Maze publish interactor.
     *
     * @param outBoundary the out boundary
     * @param gateway     the gateway
     */
    public MazePublishInteractor(MazePublishedOutBoundary outBoundary, MazePublisherGateway gateway) {
        this.outBoundary = outBoundary;
        this.gateway = gateway;
    }

    public MazePublishedResponseModel publishMaze(String author, String name, DesignableMaze dm) {
        MazePublishedRequestModel mazeInfo = new MazePublishedRequestModel(author, name, dm);
        MazePublisher maze = new MazePublisher(mazeInfo);
        PublishedMaze pm = maze.publishMaze();
        if (pm != null) {
            gateway.storeMaze(pm);
            MazePublishedResponseModel info = new MazePublishedResponseModel(pm.getId(),
                                                                             pm.getName(),
                                                                             pm.getPublishDate());
            return this.outBoundary.reportSuccess(info);
        }
        else {
            this.outBoundary.reportFailure();
            return null;
        }
    }
}
