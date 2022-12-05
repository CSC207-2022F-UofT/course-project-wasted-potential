import design.*;
import javafx.application.Application;
import javafx.stage.Stage;
import publish.*;
import screens.MazeDatabase;
import screens.MazeDesignerUI;
import screens.Screen;
import screens.ScreenManager;

import java.io.IOException;
import java.text.ParseException;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage){
        PublishMazePresenter mpp = new PublishMazePresenter();
        PublishMazeGateway md;
        try {
            md = new MazeDatabase("./mazes.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        } catch (ParseException e) {
            throw new RuntimeException("Creation date is incorrect.");
        }
        PublishMazeInteractor mpi = new PublishMazeInteractor(mpp, md);
        PublishMazeController mpc = new PublishMazeController(mpi);
        MazeDesignerOutputBoundary mdp = new MazeDesignerPresenter();
        MazeDesignerInputBoundary mdi = new MazeDesignerInteractor(mdp);
        MazeDesignerController mdc = new MazeDesignerController(mdi);
        Screen mdui = new MazeDesignerUI(mdc, mpc);

        ScreenManager.setStage(primaryStage);
        ScreenManager.addScreen("designer", mdui);
        ScreenManager.changeScreen("designer");
    }
}
