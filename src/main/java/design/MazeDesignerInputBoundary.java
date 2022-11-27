package design;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public interface MazeDesignerInputBoundary {
    public void newMaze();

    public void resetMaze();

    public void buildWall(int row, int col);

    public void removeWall(int row, int col);

    public void startPoint(int row, int col);

    public void endPoint(int row, int col);

    public void randomMaze();

    public void outWallAttempt(Stage primaryStage);

    public void updateMaze(Button[][] buttonarr);

}
