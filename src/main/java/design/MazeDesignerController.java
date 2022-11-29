package design;

import entities.DesignableMaze;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MazeDesignerController {
    MazeDesignerInteractor md = new MazeDesignerInteractor();

    public void start(){
        md.newMaze();
        md.resetMaze();
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

    public int getRows(){
        return md.getRows();
    }
    public int getCols(){
        return md.getCols();
    }
    public char cellChar(int row, int col){
        return md.cellChar(row, col);
    }

    public void outWallAttempt(Stage primaryStage){
        md.outWallAttempt(primaryStage);
    }
    public void updateMaze(Button[][] buttonarr){
        md.updateMaze(this, buttonarr);
    }

    public DesignableMaze getDm() { return md.getDm(); }
}
