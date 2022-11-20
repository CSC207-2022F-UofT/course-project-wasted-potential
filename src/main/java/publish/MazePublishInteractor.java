package publish;

import entities.PublishedMaze;

public class MazePublishInteractor implements MazePublishedInBoundary{

    private MazePublishedOutBoundary outBoundary;

    final MazePublisherGateway gateway;

    public MazePublishInteractor(MazePublishedOutBoundary outBoundary, MazePublisherGateway gateway) {
        this.outBoundary = outBoundary;
        this.gateway = gateway;
    }

    public void publishMaze(MazePublishedRequestModel mazeInfo) {
        MazePublisher maze = new MazePublisher(mazeInfo);
        PublishedMaze pm = maze.publishMaze();
        if (maze.publishMaze() != null) {
            gateway.storeMaze(pm);
            MazePublishedResponseModel info = new MazePublishedResponseModel(pm.getId(),
                                                                             pm.getName(),
                                                                             pm.getPublishDate());
            this.outBoundary.reportSuccess(info);
        }
        else {
            this.outBoundary.reportFailure();
        }
    }
}
