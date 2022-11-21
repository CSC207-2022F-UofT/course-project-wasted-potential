package design;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public interface MazeDesignerOutputBoundary {
    void updateMazeUI(Button[][] buttonarray);

    void outerWallEdit(Stage primaryStage);
}
