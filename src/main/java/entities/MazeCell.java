package entities;

import java.util.Objects;

/**
 * The type Maze cell.
 */
public class MazeCell {
    /**
     * The row co-ordinate.
     */
    public int row;
    /**
     * The column co-ordinate.
     */
    public int col;

    /**
     * Instantiates a new Maze cell.
     *
     * @param row the row co-ordinate.
     * @param col the column co-ordinate.
     */
    public MazeCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Checks whether an object is an instance of MazeCell.
     *
     * @param o the object to be checked
     * @return a boolean value representing whether the object is an instance of MazeCell
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof MazeCell)) {
            return false;
        }

        MazeCell v = (MazeCell) o;

        return v.row == this.row && v.col == this.col;
    }

    /**
     * Returns the hashcode of the cell.
     *
     * @return the hashcode of the cell
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.col);
    }
}