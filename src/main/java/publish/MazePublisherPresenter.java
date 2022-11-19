package publish;

public class MazePublisherPresenter implements MazePublishedOutBoundary{
    public void reportSuccess() {
        System.out.println("Your maze has been published!");
    }
    public void reportFailure() {
        System.out.println("Your maze was unable to be published");
    }
}
