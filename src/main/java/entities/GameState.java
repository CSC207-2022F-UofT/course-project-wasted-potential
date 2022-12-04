package entities;

// Pretty sure this class doesnt run properly but check with team
public class GameState extends PublishedMaze {

    int[] position;

    public GameState(int[] startPosition) {
        super();
        this.position = startPosition;
    }

    public int[] getPosition() {
        return this.position;
    }

    public void updatePosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }



}
