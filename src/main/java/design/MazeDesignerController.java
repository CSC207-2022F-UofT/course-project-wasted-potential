package design;

import javafx.scene.control.Button;
import javafx.stage.Stage;


public class MazeDesignerController {
    MazeDesignerInteractor md = new MazeDesignerInteractor();
    MazeDesignerPresenter mdp = new MazeDesignerPresenter();

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
        mdp.outerWallEdit(primaryStage);
    }
    public void updateMaze(Button[][] buttonarr){
        mdp.updateMazeUI(this, buttonarr);
    }
}
