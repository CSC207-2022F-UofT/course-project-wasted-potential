import design.MazeDesignerController;
import entities.DesignableMaze;
import javafx.application.Application;
import javafx.stage.Stage;
import publish.MazeDatabase;
import publish.MazePublishInteractor;
import publish.MazePublisherControl;
import publish.MazePublisherPresenter;
import screens.MazeDesignerUI;

import java.io.IOException;

public class main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {
        MazePublisherPresenter mpp = new MazePublisherPresenter();
        MazeDatabase md;
        try {
            md = new MazeDatabase("./mazes.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        MazePublishInteractor mpi = new MazePublishInteractor(mpp, md);
        MazePublisherControl mpc = new MazePublisherControl(mpi);
        MazeDesignerUI mazeDesignerUI = new MazeDesignerUI(mpc);
        mazeDesignerUI.start(primaryStage);
    }
}
