import design.*;
import javafx.application.Application;
import javafx.stage.Stage;
import screens.LoginUI;
import screens.MazeDesignerUI;
import screens.Screen;
import screens.ScreenManager;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage){

        MazeDesignerOutputBoundary mdp = new MazeDesignerPresenter();
        MazeDesignerInputBoundary mdi = new MazeDesignerInteractor(mdp);
        MazeDesignerController mdc = new MazeDesignerController(mdi);
        Screen mdui = new MazeDesignerUI(mdc);

        Screen lui = new LoginUI();

        ScreenManager.setStage(primaryStage);
        ScreenManager.addScreen("designer", mdui);
        ScreenManager.changeScreen("designer");

    }
}
