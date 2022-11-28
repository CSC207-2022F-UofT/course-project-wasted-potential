package design;

import javafx.scene.control.Button;
import javafx.stage.Stage;


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
     * Handles the event where the user tries to edit an outer wall
     * @param primaryStage the Stage which needs to display the response to the event
     */
    public void outWallAttempt(Stage primaryStage){
        md.outWallAttempt(primaryStage);
    }

    /**
     * Updates the current maze
     * @param buttonarr a JavaFX Button array representing the current maze
     */
    public void updateMaze(Button[][] buttonarr){
        md.updateMaze(buttonarr);
    }
}
