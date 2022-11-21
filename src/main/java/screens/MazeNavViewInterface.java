package screens;

public interface MazeNavViewInterface {

    public void moveIcon(int[] requestedMove);

    public void mazeComplete(String message);

    public void prepareFailView(String error);
}
