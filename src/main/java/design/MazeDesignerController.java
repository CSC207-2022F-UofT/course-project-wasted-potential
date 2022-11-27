package design;

import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MazeDesignerController {
    private MazeDesignerInputBoundary md;

    public MazeDesignerController(MazeDesignerInputBoundary md) {
        this.md = md;
    }

    public void resetMaze(){
        md.resetMaze();
    }

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

    public void randoMaze(){
        md.randomMaze();
    }

    public void outWallAttempt(Stage primaryStage){
        md.outWallAttempt(primaryStage);
    }
    public void updateMaze(Button[][] buttonarr){
        md.updateMaze(buttonarr);
    }
}
