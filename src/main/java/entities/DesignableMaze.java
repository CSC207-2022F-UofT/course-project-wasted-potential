package entities;

import com.sun.javafx.runtime.VersionInfo;
import javafx.scene.control.Button;

public class DesignableMaze extends Maze{

    int startLocation[] = new int[2];
    int endLocation[] = new int[2];


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
        this.state[startLocation[0]][startLocation[1]] = Maze.ENCODING.get("empty");

        this.state[row][col] = Maze.ENCODING.get("start");
        startLocation[0] = row;
        startLocation[1] = col;
    }
    public void placeEnd(int row, int col) {
        this.state[endLocation[0]][endLocation[1]] = Maze.ENCODING.get("empty");

        this.state[row][col] = Maze.ENCODING.get("end");
        endLocation[0] = row;
        endLocation[1] = col;
    }

    public char getCell(int row, int col){
        return this.state[row][col];
    }

    public void fill() {
        for (int i = 0; i < this.getNumRow(); i++) {
            for (int j = 0; j < this.getNumCol(); j++) {
                placeWall(i, j);
            }
        }
    }

    public void setButtonArray(Button[][] buttonarray){
        for (int i = 0; i < buttonarray.length; i++) {
            for (int j = 0; j < buttonarray[0].length; j++) {
                if(buttonarray[i][j] == null){
                    buttonarray[i][j] = new Button();
                }
                if(getCell(i, j) == '#'){
                    buttonarray[i][j].setText("#");
                } else if (getCell(i, j) == '.'){
                    buttonarray[i][j].setText(".");
                } else if (getCell(i, j) == 'S'){
                    buttonarray[i][j].setText("S");
                } else {
                    buttonarray[i][j].setText("E");
                }
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
