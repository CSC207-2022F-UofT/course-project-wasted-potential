package design;

/**
 * The Maze Designer Controller
 */
public class MazeDesignerController {
    private MazeDesignerInputBoundary md;

    /**
     * Constructor for the Controller
     * @param md The MazeDesignerInputBoundary; expected to be the MazeDesignerInteractor
     */
    public MazeDesignerController(MazeDesignerInputBoundary md) {
        this.md = md;
    }

    /**
     * Resets the current maze md
     */
    public void resetMaze(){
        md.resetMaze();
    }

    /**
     * @param h an int describing which event to execute; 0 to build, 1 to remove, 2 to place a Start, 3 to place an End
     * @param row the row of the cell to execute the event
     * @param col the column of the cell to execute the event
     */
    public void handleBuild(int h, int row, int col){
        if (h == 0){
            md.buildWall(row,col);
        } else if (h == 1){
            md.removeWall(row, col);
        } else if (h == 2){
            md.startPoint(row,col);
        } else if (h == 3) {
            md.endPoint(row,col);
        }
    }

    /**
     * Randomizes the maze md
     */
    public void randoMaze(){
        md.randomMaze();
    }

    /**
     * Updates the current maze
     */
    public String[][] updateMaze(){
        return md.updateMaze();
    }
}
