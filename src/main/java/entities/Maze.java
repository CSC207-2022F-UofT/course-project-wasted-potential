package entities;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class Maze {
    private int numRow;
    private int numCol;
    protected char[][] state;
    final public static Map<String, Character> ENCODING = new HashMap<String, Character>() {{
        put("empty", '.');
        put("wall", '#');
        put("start", 'S');
        put("end", 'E');
    }};

    public Maze() {

    }

    public Maze(int numRow, int numCol) {
        this.numRow = numRow;
        this.numCol = numCol;
        this.state = new char[numRow][numCol];
    }

    public Maze(int numRow, int numCol, char[][] state) {
        this.numRow = numRow;
        this.numCol = numCol;
        this.state = state;
    }

    public int getNumRow() {
        return numRow;
    }

    public int getNumCol() {
        return numCol;
    }

    public char[][] getState() {
        return state;
    }

    public char getCell(int row, int col){
        return this.state[row][col];
    }

    public boolean inBounds(int row, int col) {
        if (row >= numRow || row < 0) return false;
        return col < numCol && col >= 0;
    }

    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < this.numRow; i++)  {
            StringBuilder curRow = new StringBuilder();
            for (int j = 0; j < this.numCol; j++) {
                curRow.append(state[i][j]);
            }
            returnString.append(curRow + "\r\n");
        }

        return returnString.toString();
    }

}