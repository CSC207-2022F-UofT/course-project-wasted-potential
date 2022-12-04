package publish;

/**
 * The type Maze publisher presenter.
 */
public class MazePublisherPresenter implements MazePublishedOutBoundary{
    public MazePublishedResponseModel reportSuccess(MazePublishedResponseModel mazeInfo) {
        return mazeInfo;
    }
    public void reportFailure() {
        System.out.println("Your maze was unable to be published");
    }
}
