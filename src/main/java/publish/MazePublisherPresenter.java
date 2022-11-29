package publish;

/**
 * The type Maze publisher presenter.
 */
public class MazePublisherPresenter implements MazePublishedOutBoundary{
    public MazePublishedResponseModel reportSuccess(MazePublishedResponseModel mazeInfo) {
        System.out.println(mazeInfo.getId() + " " + mazeInfo.getName() + " " + mazeInfo.getPublishDate());
        return mazeInfo;
    }
    public void reportFailure() {
        System.out.println("Your maze was unable to be published");
    }
}
