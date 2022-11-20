package design;

public class MazeCell {
    int row;
    int col;

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


    // can prolly delete this later
    @Override
    public int hashCode() {
        return this.col + this.row;
    }
}
