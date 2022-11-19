package entities;

public class DesignableMaze extends Maze{

    public DesignableMaze(int numRow, int numCol) {
        super(numRow, numCol);
    }
    public void placeWall(int row, int col) {
        this.state[row][col] = Maze.ENCODING.get("wall");
    }

    public void deleteWall(int row, int col) {
        this.state[row][col] = Maze.ENCODING.get("empty");
    }
}
