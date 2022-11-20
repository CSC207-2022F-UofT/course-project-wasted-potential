package publish;

public class MazePublisherPresenter implements MazePublishedOutBoundary{
    public void reportSuccess(MazePublishedResponseModel mazeInfo) {
        System.out.println("Your maze " + mazeInfo.getName() + " has been published!");
        System.out.println("Your maze has ID: " + mazeInfo.getId() + "and was published on " +
                mazeInfo.getPublishDate().toString());
    }
    public void reportFailure() {
        System.out.println("Your maze was unable to be published");
    }
}
