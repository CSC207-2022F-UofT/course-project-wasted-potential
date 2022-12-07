package design;

import entities.DesignableMaze;

/**
 * The Maze Designer Controller
 */
public class MazeDesignerController {
    private MazeDesignerInputBoundary mazeDesignerInteractor;

    /**
     * Constructor for the Controller
     * @param mazeDesignerInteractor The MazeDesignerInputBoundary; expected to be the MazeDesignerInteractor
     */
    public MazeDesignerController(MazeDesignerInputBoundary mazeDesignerInteractor) {
        this.mazeDesignerInteractor = mazeDesignerInteractor;
    }

    /**
     * Resets the current maze md
     */
    public void resetMaze(){
        mazeDesignerInteractor.resetMaze();
    }

    /**
     * @param action a String describing event to execute
     * @param row the row of the cell to execute the event
     * @param col the column of the cell to execute the event
     */
    public void handleBuild(String action, int row, int col){
        if (action.equals("build")){
            mazeDesignerInteractor.buildWall(row,col);
        } else if (action.equals("remove")){
            mazeDesignerInteractor.removeWall(row, col);
        } else if (action.equals("start")){
            mazeDesignerInteractor.startPoint(row,col);
        } else if (action.equals("end")) {
            mazeDesignerInteractor.endPoint(row,col);
        }
    }

    /**
     * Randomizes the maze md
     */
    public void randoMaze(){
        mazeDesignerInteractor.randomMaze();
    }

    /**
     * Updates the current maze
     */
    public char[][] getMazeState(){
        return mazeDesignerInteractor.getMazeState();
    }

    /**
     * Gets the DesignableMaze
     */
    public DesignableMaze getDesignableMaze() { return mazeDesignerInteractor.getDesignableMaze();}
}
