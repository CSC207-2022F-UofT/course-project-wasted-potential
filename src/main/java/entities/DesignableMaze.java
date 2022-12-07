package entities;

/**
 * The type Designable maze.
 */
public class DesignableMaze extends Maze{

    private static final String EMPTY = "empty";
    private int[] startLocation = new int[2];
    private int[] endLocation = new int[2];

    /**
     * Instantiates a new Designable maze.
     *
     */
    public DesignableMaze() {
        super();
    }

    /**
     * Instantiates a new Designable maze.
     *
     * @param numRow the number of rows
     * @param numCol the number of columns
     */
    public DesignableMaze(int numRow, int numCol) {
        super(numRow, numCol);
    }

    /**
     * Instantiates a new Designable maze.
     *
     * @param numRow the number of rows
     * @param numCol the number of columns
     * @param state  a 2d array representing the maze layout
     * @param start  the start point of the maze
     * @param end    the end point of the maze
     */
    public DesignableMaze(int numRow, int numCol, char[][] state, int[] start, int[] end) {
        super(numRow, numCol, state);
        this.startLocation = start;
        this.endLocation = end;
    }

    /**
     * Place wall in the specified location.
     *
     * @param row the row of the specified location
     * @param col the column of the specified location
     */
    public void placeWall(int row, int col) {
        this.state[row][col] = Maze.ENCODING.get("wall");
    }

    /**
     * Delete wall in the specified location.
     *
     * @param row the row of the specified location
     * @param col the column of the specified location
     */
    public void deleteWall(int row, int col) {
        this.state[row][col] = Maze.ENCODING.get(EMPTY);
    }

    /**
     * Place start block in the specified location.
     *
     * @param row the row
     * @param col the col
     */
    public void placeStart(int row, int col) {
        for (int i = 0; i < getNumRow(); i++) {
            for (int j = 0; j < getNumCol(); j++) {
                if (this.state[i][j] == Maze.ENCODING.get("start")){
                    this.state[i][j] = Maze.ENCODING.get(EMPTY);
                }
            }
        }
        this.state[row][col] = Maze.ENCODING.get("start");
        startLocation[0] = row;
        startLocation[1] = col;
    }

    /**
     * Place end block in the specified location.
     *
     * @param row the row
     * @param col the col
     */
    public void placeEnd(int row, int col) {
        for (int i = 0; i < getNumRow(); i++) {
            for (int j = 0; j < getNumCol(); j++) {
                if (this.state[i][j] == Maze.ENCODING.get("end")){
                    this.state[i][j] = Maze.ENCODING.get(EMPTY);
                }
            }
        }
        this.state[row][col] = Maze.ENCODING.get("end");
        endLocation[0] = row;
        endLocation[1] = col;
    }

    /**
     * Get start location of the maze.
     *
     * @return an int array representing the co-ordinates of the start position
     */
    public int[] getStartLocation() {
        return startLocation;
    }

    /**
     * Get end location of the maze.
     *
     * @return an int array representing the co-ordinates of the start position.
     */
    public int[] getEndLocation() {
        return endLocation;
    }

    /**
     * Empties the maze of all blocks placed.
     */
    public void emptySetup() {
        for (int i = 0; i < getNumRow(); i++) {
            for (int j = 0; j < getNumCol(); j++) {
                if (i == 0 || j == 0 || i == getNumRow() - 1 || j == getNumCol() - 1) {
                    placeWall(i, j);
                } else {
                    deleteWall(i, j);
                }
            }
        }
        startLocation[0] = 1;
        startLocation[1] = 1;
        endLocation[0] = getNumRow()-2;
        endLocation[1] = getNumCol()-2;

        placeStart(1, 1);
        placeEnd(getNumRow()-2, getNumCol()-2);
    }
}