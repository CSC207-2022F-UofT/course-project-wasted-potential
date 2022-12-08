package design;

import entities.DesignableMaze;

/**
 * The Maze Designer Controller
 */
public class MazeDesignerController {
    private final MazeDesignerInputBoundary mazeDesignerInteractor;

    /**
     * Constructor for the Controller.
     * @param mazeDesignerInteractor the MazeDesignerInputBoundary
     */
    public MazeDesignerController(MazeDesignerInputBoundary mazeDesignerInteractor) {
        this.mazeDesignerInteractor = mazeDesignerInteractor;
    }

    /**
     * Resets the current maze back to an empty maze.
     */
    public void resetMaze(){
        mazeDesignerInteractor.resetMaze();
    }

    /**
     * Adds the specified block to the cell with the given co-ordinates.
     *
     * @param action a String describing the block to be placed
     * @param row the row of the cell to place the block
     * @param col the column of the cell to place the block
     */
    public void handleBuild(String action, int row, int col){

        // Not all versions of Java support an enhanced switch case, so the switch case
        // was not changed despite the warning
        switch (action) {
            case "build":
                mazeDesignerInteractor.buildWall(row, col);
                break;
            case "remove":
                mazeDesignerInteractor.removeWall(row, col);
                break;
            case "start":
                mazeDesignerInteractor.startPoint(row, col);
                break;
            default:
                mazeDesignerInteractor.endPoint(row, col);
                break;
        }
    }

    /**
     * Randomizes the maze layout.
     */
    public void randomizeMaze(){
        mazeDesignerInteractor.randomMaze();
    }

    /**
     * Updates the current maze.
     */
    public char[][] getMazeState(){
        return mazeDesignerInteractor.getMazeState();
    }

    /**
     * Gets the DesignableMaze.
     */
    public DesignableMaze getDesignableMaze() { return mazeDesignerInteractor.getDesignableMaze();}
}
