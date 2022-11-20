package publish;

public interface MazePublishedOutBoundary {
    void reportSuccess(MazePublishedResponseModel mazeInfo);
    void reportFailure();
}
