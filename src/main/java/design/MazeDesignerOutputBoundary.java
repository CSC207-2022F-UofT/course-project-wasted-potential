package design;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public interface MazeDesignerOutputBoundary {
    public void updateMazeUI(Button[][] buttonarray);

    public void outerWallEdit(Stage primaryStage);
}
