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

    public void placeStart(int row, int col) {
        for (int i = 0; i < this.getNumRow(); i++) {
            for (int j = 0; j < this.getNumCol(); j++) {
                if (this.state[i][j] == 'S'){
                    this.state[i][j] = Maze.ENCODING.get("wall");
                }
            }
        }
        this.state[row][col] = Maze.ENCODING.get("start");
    }
    public void placeEnd(int row, int col) {
        for (int i = 0; i < this.getNumRow(); i++) {
            for (int j = 0; j < this.getNumCol(); j++) {
                if (this.state[i][j] == 'E'){
                    this.state[i][j] = Maze.ENCODING.get("wall");
                }
            }
        }
        this.state[row][col] = Maze.ENCODING.get("end");
    }

    public char getState(int row, int col){
        return this.state[row][col];
    }

    public void fill() {
        for (int i = 0; i < this.getNumRow(); i++) {
            for (int j = 0; j < this.getNumCol(); j++) {
                placeWall(i, j);
            }
        }
    }

    public void emptySetup() {
        for (int i = 0; i < this.getNumRow(); i++) {
            for (int j = 0; j < this.getNumCol(); j++) {
                if(i == 0 || j == 0 || i == getNumRow()-1 || j == getNumCol()-1){
                    placeWall(i, j);
                } else {
                    deleteWall(i,j);
                }
            }
        }
    }

}
