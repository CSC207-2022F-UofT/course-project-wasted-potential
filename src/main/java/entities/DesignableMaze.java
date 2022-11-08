package entities;

public class DesignableMaze extends Maze{
    public void placeWall(int row, int col) {
        this.state[row][col] = Maze.ENCODING.get("wall");
    }
}
