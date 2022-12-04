package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Maze.
 */
public abstract class Maze {
    /**
     * The Number of rows.
     */
    protected int numRow;
    /**
     * The Number of columns.
     */
    protected int numCol;
    /**
     * The layout of the maze.
     */
    protected char[][] state;
    /**
     * The encoding for the different types of blocks in a maze.
     */
    final public static Map<String, Character> ENCODING = new HashMap<String, Character>() {{
        put("empty", '.');
        put("wall", '#');
        put("start", 'S');
        put("end", 'E');
    }};

    /**
     * Instantiates a new Maze. This is a default constructor.
     */
    public Maze() {

    }

    /**
     * Instantiates a new Maze.
     *
     * @param numRow the number of rows
     * @param numCol the number of columns
     */
    public Maze(int numRow, int numCol) {
        this.numRow = numRow;
        this.numCol = numCol;
        this.state = new char[numRow][numCol];
    }

    /**
     * Instantiates a new Maze.
     *
     * @param numRow the number of rows
     * @param numCol the number of columns
     * @param state  the layout of the maze
     */
    public Maze(int numRow, int numCol, char[][] state) {
        this.numRow = numRow;
        this.numCol = numCol;
        this.state = state;
    }

    /**
     * Gets num row.
     *
     * @return the number of rows
     */
    public int getNumRow() {
        return numRow;
    }

    /**
     * Gets num col.
     *
     * @return the number of columns
     */
    public int getNumCol() {
        return numCol;
    }

    /**
     * Get the layout of the maze
     *
     * @return the character array representing the maze
     */
    public char[][] getState() {
        return state;
    }

    /**
     * Get the character in the specified cell.
     *
     * @param row the row co-ordinate of the cell
     * @param col the column co-ordinate of the cell
     * @return the character in the specified cell
     */
    public char getCell(int row, int col){
        return this.state[row][col];
    }

    /**
     * Checks whether a given set of co-ordinates are within the bounds of the maze.
     *
     * @param row the row co-ordinate of the cell
     * @param col the column co-ordinate of the cell
     * @return a boolean representing whether a given set of co-ordinates are within the bounds of the maze.
     */
    public boolean inBounds(int row, int col) {
        if (row >= numRow || row < 0) return false;
        return col < numCol && col >= 0;
    }

    /**
     * A string representation of the maze.
     *
     * @return a string representation of the maze
     */
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