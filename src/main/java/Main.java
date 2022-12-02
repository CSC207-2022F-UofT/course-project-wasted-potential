import design.*;
import javafx.application.Application;
import javafx.stage.Stage;
import publish.MazeDatabase;
import publish.MazePublishInteractor;
import publish.MazePublisherControl;
import publish.MazePublisherPresenter;
import screens.MazeDesignerUI;
import screens.Screen;
import screens.ScreenManager;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage){
        MazePublisherPresenter mpp = new MazePublisherPresenter();
        MazeDatabase md;
        try {
            md = new MazeDatabase("./mazes.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        MazePublishInteractor mpi = new MazePublishInteractor(mpp, md);
        MazePublisherControl mpc = new MazePublisherControl(mpi);
        MazeDesignerOutputBoundary mdp = new MazeDesignerPresenter();
        MazeDesignerInputBoundary mdi = new MazeDesignerInteractor(mdp);
        MazeDesignerController mdc = new MazeDesignerController(mdi);
        Screen mdui = new MazeDesignerUI(mdc, mpc);

        ScreenManager.setStage(primaryStage);
        ScreenManager.addScreen("designer", mdui);
        ScreenManager.changeScreen("designer");
    }
}
