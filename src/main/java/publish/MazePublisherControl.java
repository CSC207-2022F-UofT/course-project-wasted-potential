package publish;

public class MazePublisherControl {
    private MazePublishedInBoundary inBoundary;

    public MazePublisherControl(MazePublishedInBoundary inBoundary) {
        this.inBoundary = inBoundary;
    }

    public void publishMaze(MazePublishedRequestModel mazeInfo) {
        inBoundary.publishMaze(mazeInfo);
    }
}
