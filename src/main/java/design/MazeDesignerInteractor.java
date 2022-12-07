package design;

import entities.DesignableMaze;

/**
 * The Maze Designer Interactor
 */
public class MazeDesignerInteractor implements MazeDesignerInputBoundary {

    private DesignableMaze designableMaze;
    private MazeGenerator mazeGenerator;
    private MazeDesignerOutputBoundary mazeDesignerPresenter;

    private static final int numRows = 17;
    private static final int numCols = 25;


    /**
     * Constructor for the Maze Designer Interactor
     * @param mazeDesignerPresenter A MazeDesignerOutputBoundary, expected to be a MazeDesignerPresenter
     */
    public MazeDesignerInteractor(MazeDesignerOutputBoundary mazeDesignerPresenter) {
        // update designablemaze instance attribute
        this.designableMaze = new DesignableMaze(numRows, numCols);
        resetMaze();
        // update the randomizedprim instance attribute
        this.mazeGenerator = new RandomizedPrim(this.designableMaze);
        // update the output boundary instance attribute
        this.mazeDesignerPresenter = mazeDesignerPresenter;
    }

    public void resetMaze(){
        designableMaze.emptySetup();
    }


    public void buildWall(int row, int col){
        designableMaze.placeWall(row, col);
    }


    public void removeWall(int row, int col){
        if (row != 0 && col != 0 && row != designableMaze.getNumRow()-1 && col != designableMaze.getNumCol()-1) {
            designableMaze.deleteWall(row, col);
        }
    }


    public void startPoint(int row, int col){
        designableMaze.placeStart(row, col);
    }


    public void endPoint(int row, int col){
        designableMaze.placeEnd(row, col);
    }
    public void randomMaze(){
        mazeGenerator = new RandomizedPrim(this.designableMaze);
        mazeGenerator.generate();
        startPoint(1,1);
        endPoint(getRows()-2, getCols()-2);
    }
    public int getRows(){
        return designableMaze.getNumRow();
    }
    public int getCols(){
        return designableMaze.getNumCol();
    }

    public char[][] getMazeState(){
        return mazeDesignerPresenter.presentMazeState(designableMaze.getState());
    }

    public DesignableMaze getDesignableMaze() {
        return designableMaze;
    }
}
