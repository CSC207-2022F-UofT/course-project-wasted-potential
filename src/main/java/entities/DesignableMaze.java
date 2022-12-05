package entities;

import com.sun.javafx.runtime.VersionInfo;

public class DesignableMaze extends Maze{

    private int startLocation[] = new int[2];
    private int endLocation[] = new int[2];

    public DesignableMaze(int numRow, int numCol) {
        super(numRow, numCol);
    }

    public DesignableMaze(int numRow, int numCol, char[][] state, int[] start, int[] end) {
        super(numRow, numCol, state);
        this.startLocation = start;
        this.endLocation = end;
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
                if (this.state[i][j] == Maze.ENCODING.get("start")){
                    this.state[i][j] = Maze.ENCODING.get("empty");
                }
            }
        }
        this.state[row][col] = Maze.ENCODING.get("start");
        startLocation[0] = row;
        startLocation[1] = col;
    }

    public void placeEnd(int row, int col) {
        for (int i = 0; i < this.getNumRow(); i++) {
            for (int j = 0; j < this.getNumCol(); j++) {
                if (this.state[i][j] == Maze.ENCODING.get("end")){
                    this.state[i][j] = Maze.ENCODING.get("empty");
                }
            }
        }
        this.state[row][col] = Maze.ENCODING.get("end");
        endLocation[0] = row;
        endLocation[1] = col;
    }

    public char getCell(int row, int col){
        return this.state[row][col];
    }

    public int[] getStartLocation() {
        return startLocation;
    }

    public int[] getEndLocation() {
        return endLocation;
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
                if (i == 0 || j == 0 || i == getNumRow() - 1 || j == getNumCol() - 1) {
                    placeWall(i, j);
                } else {
                    deleteWall(i, j);
                }
            }
        }
        startLocation[0] = 1;
        startLocation[1] = 1;
        endLocation[0] = this.getNumRow()-2;
        endLocation[1] = this.getNumCol()-2;

        placeStart(1, 1);
        placeEnd(this.getNumRow()-2, this.getNumCol()-2);
    }
}