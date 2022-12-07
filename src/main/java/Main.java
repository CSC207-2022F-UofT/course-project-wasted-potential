import design.*;
import user_login.*;
import user_registration.*;
import display.*;
import entities.UserFactory;
import javafx.stage.Stage;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import retrieval.*;
import screens.*;
import publish.*;
import navigation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import solvability.*;
import java.text.ParseException;
import java.util.zip.DataFormatException;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws FileNotFoundException, DataFormatException {

        UserRegisterAndLoginDsGateway gateway;

        try{
            gateway = new UserDatabase("./users.csv");
        } catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        }

        ULoginOutputBoundary userLoginPresenter = new UserLoginPresenter();
        ULoginInputBoundary userLoginInteractor = new UserLoginInteractor(gateway, userLoginPresenter);
        UserLoginController userLoginController = new UserLoginController(userLoginInteractor);
        Screen loginUI = new LoginUI(userLoginController);

        URegOutputBoundary userRegisterPresenter = new URegisterPresenter();
        UserFactory userFactory = new UserFactory();
        URegInputBoundary userRegisterInteractor = new UserRegisterInteractor(gateway, userRegisterPresenter, userFactory);
        UserRegisterController userRegisterController = new UserRegisterController(userRegisterInteractor);
        Screen registerUI = new RegisterUI(userRegisterController);


        MazeDatabase mazeDatabase;
        PublishMazePresenter publishMazePresenter = new PublishMazePresenter();
        try {
            mazeDatabase = new MazeDatabase("./mazes.csv");
        } catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        } catch (ParseException e) {
            throw new DataFormatException("Creation date is incorrect.");
        }
        PublishMazeInteractor publishMazeInteractor = new PublishMazeInteractor(publishMazePresenter, mazeDatabase);
        PublishMazeController publishMazeController = new PublishMazeController(publishMazeInteractor);
        MazeDesignerOutputBoundary mazeDesignerPresenter = new MazeDesignerPresenter();
        MazeDesignerInputBoundary mazeDesignerInteractor = new MazeDesignerInteractor(mazeDesignerPresenter);
        MazeDesignerController mazeDesignerController = new MazeDesignerController(mazeDesignerInteractor);
        // Solvability use case
        MazeSolvableOutBoundary mazeSolvablePresenter = new MazeSolvablePresenter();
        MazeSolvableInBoundary mazeSolvabilityInteractor = new MazeSolvabilityInteractor(mazeSolvablePresenter);
        MazeSolvabilityControl mazeSolvabilityControl = new MazeSolvabilityControl(mazeSolvabilityInteractor);
        Screen mazeDesignerUI = new MazeDesignerUI(mazeDesignerController, publishMazeController, mazeSolvabilityControl);
        // Retrieval use case
        MazeRetrieverOutputBoundary mazeRetrieverPresenter = new MazeRetrieverPresenter();
        MazeRetrieverDsGateway mazeRetrieverDsGateway = (MazeRetrieverDsGateway) gateway;
        MazeRetrieverInputBoundary mazeRetrieverInteractor = new MazeRetrieverInteractor(mazeRetrieverDsGateway, mazeRetrieverPresenter);
        MazeRetrieverController mazeRetrieverController = new MazeRetrieverController(mazeRetrieverInteractor);
        // Display use case
        MazeDisplayOutputBoundary mazeDisplayPresenter = new MazeDisplayPresenter();
        MazeDsGateway mazeDsGateway = mazeDatabase;
        PlayerDsGateway playerDsGateway = (PlayerDsGateway)gateway;
        MazeDisplayInputBoundary mazeDisplayInteractor = new MazeDisplayInteractor(playerDsGateway, mazeDsGateway, mazeDisplayPresenter);
        MazeDisplayController mazeDisplayController = new MazeDisplayController(mazeDisplayInteractor);
        // Navigation use case
        MazeNavOutputBoundary mazeNavPresenter = new MazeNavPresenter();
        MazeNavInputBoundary mazeNavInteractor = new MazeNavInteractor(mazeNavPresenter);
        MazeNavController mazeNavController = new MazeNavController(mazeNavInteractor);

        MazeNavUI mazeNavUI = new MazeNavUI(mazeNavController);
        MazeRetrieverUI mazeRetrieverUI = new MazeRetrieverUI(mazeRetrieverController, mazeDisplayController);




        ScreenManager.setStage(primaryStage);
        ScreenManager.addScreen("designer", mazeDesignerUI);
        ScreenManager.addScreen("login", loginUI);
        ScreenManager.addScreen("register", registerUI);
        ScreenManager.addScreen("home", mazeRetrieverUI);
        ScreenManager.addScreen("game", mazeNavUI);

        ScreenManager.changeScreen("login");

    }
}
