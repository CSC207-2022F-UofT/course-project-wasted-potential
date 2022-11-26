package entities;

import java.util.Objects;

public class MazeCell {
    public int row;
    public int col;

    public MazeCell(int row, int col) {
        this.row = row;
        this.col = col;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(this.row, this.col);
    }
}
