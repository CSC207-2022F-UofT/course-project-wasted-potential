package design;

import entities.DesignableMaze;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MazeDesignerInteractor implements MazeDesignerInputBoundary {

    DesignableMaze dm;
    RandomizedPrim mg;
    private MazeDesignerOutputBoundary mdp;


    public MazeDesignerInteractor(MazeDesignerOutputBoundary mdp) {
        // update designablemaze instance attribute
        newMaze();
        resetMaze();
        // update the randomizedprim instance attribute
        this.mg = new RandomizedPrim();
        // update the output boundary instance attribute
        this.mdp = mdp;
    }

    public void newMaze(){
        dm = new DesignableMaze(11, 17);
    }

    public void resetMaze(){
        dm.emptySetup();
    }

    public void buildWall(int row, int col){
        dm.placeWall(row, col);
    }
    public void removeWall(int row, int col){
        if (row != 0 && col != 0 && row != dm.getNumRow()-1 && col != dm.getNumCol()-1) {
            dm.deleteWall(row, col);
        }
    }
    public void startPoint(int row, int col){
        dm.placeStart(row, col);
    }
    public void endPoint(int row, int col){
        dm.placeEnd(row, col);
    }
    public void randomMaze(){
        mg = new RandomizedPrim();
        mg.generate(dm);
        startPoint(1,1);
        endPoint(getRows()-2, getCols()-2);
    }
    public int getRows(){
        return dm.getNumRow();
    }
    public int getCols(){
        return dm.getNumCol();
    }

    public void outWallAttempt(Stage primaryStage){
        mdp.outerWallEdit(primaryStage);
    }
    public void updateMaze(Button[][] buttonarr){
        dm.setButtonArray(buttonarr);
        mdp.updateMazeUI(buttonarr);
    }

}
