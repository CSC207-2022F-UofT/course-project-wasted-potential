package publish;

public class MazePublishInteractor implements MazePublishedInBoundary{

    private MazePublishedOutBoundary outBoundary;

    public MazePublishInteractor(MazePublishedOutBoundary outBoundary) {
        this.outBoundary = outBoundary;
    }

    public void publishMaze(MazePublishedRequestModel mazeInfo) {
        MazePublisher maze = new MazePublisher(mazeInfo);
        if (maze.publishMaze()) {
            this.outBoundary.reportSuccess();
        }
        else {
            this.outBoundary.reportFailure();
        }
    }
}
