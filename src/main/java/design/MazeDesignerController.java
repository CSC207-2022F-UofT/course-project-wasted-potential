package design;

import entities.DesignableMaze;

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
     * @param action a String describing event to execute
     * @param row the row of the cell to execute the event
     * @param col the column of the cell to execute the event
     */
    public void handleBuild(String action, int row, int col){
        if (action.equals("build")){
            md.buildWall(row,col);
        } else if (action.equals("remove")){
            md.removeWall(row, col);
        } else if (action.equals("start")){
            md.startPoint(row,col);
        } else if (action.equals("end")) {
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
    public char[][] getMazeState(){
        return md.getMazeState();
    }

    /**
     * Gets the DesignableMaze
     */
    public DesignableMaze getDm() { return md.getDesignableMaze();}
}
