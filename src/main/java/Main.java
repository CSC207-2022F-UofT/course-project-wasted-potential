import design.*;
import UserLogin.*;
import UserRegistration.*;
import display.*;
import entities.UserFactory;
import javafx.stage.Stage;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import retrieval.*;
import screens.*;
import publish.*;
import navigation.*;

import java.io.IOException;
import javafx.application.Application;
import solvability.*;
import java.text.ParseException;
import java.util.NoSuchElementException;

public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage){

        UserRegisterAndLoginDsGateway gateway;

        try{
            gateway = new UserDatabase("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        ULoginOutputBoundary logPresenter = new UserLoginPresenter();
        ULoginInputBoundary logInteractor = new UserLoginInteractor(gateway, logPresenter);
        UserLoginController logController = new UserLoginController(logInteractor);
        Screen lui = new LoginUI(logController);

        URegOutputBoundary regPresenter = new URegisterPresenter();
        UserFactory userFactory = new UserFactory();
        URegInputBoundary regInteractor = new UserRegisterInteractor(gateway, regPresenter, userFactory);
        UserRegisterController regController = new UserRegisterController(regInteractor);
        Screen rui = new RegisterUI(regController);


        MazeDatabase md;
        PublishMazePresenter mpp = new PublishMazePresenter();
        try {
            md = new MazeDatabase("./mazes.csv");
        } catch (IOException e) {
            throw new IndexOutOfBoundsException("Could not create file.");
        } catch (ParseException e) {
            throw new NoSuchElementException("Creation date is incorrect.");
        }
        PublishMazeInteractor mpi = new PublishMazeInteractor(mpp, md);
        PublishMazeController mpc = new PublishMazeController(mpi);
        MazeDesignerOutputBoundary mdp = new MazeDesignerPresenter();
        MazeDesignerInputBoundary mdi = new MazeDesignerInteractor(mdp);
        MazeDesignerController mdc = new MazeDesignerController(mdi);
        // Solvability use case
        MazeSolvableOutBoundary msp = new MazeSolvablePresenter();
        MazeSolvableInBoundary msi = new MazeSolvabilityInteractor(msp);
        MazeSolvabilityControl msc = new MazeSolvabilityControl(msi);
        Screen mdui = new MazeDesignerUI(mdc, mpc, msc);
        // Retrieval use case
        MazeRetrieverOutputBoundary mob = new MazeRetrieverPresenter();
        MazeRetrieverDsGateway mdg = (MazeRetrieverDsGateway) gateway;
        MazeRetrieverInputBoundary mib = new MazeRetrieverInteractor(mdg, mob);
        MazeRetrieverController mrc = new MazeRetrieverController(mib);
        // Display use case
        MazeDisplayOutputBoundary mdb = new MazeDisplayPresenter();
        MazeDsGateway mazeDsGateway = (MazeDsGateway)md;
        PlayerDsGateway playerDsGateway = (PlayerDsGateway)gateway;
        MazeDisplayInputBoundary mdib = new MazeDisplayInteractor(playerDsGateway, mazeDsGateway, mdb);
        MazeDisplayController mdcr = new MazeDisplayController(mdib);
        // Navigation use case
        MazeNavOutputBoundary mnob = new MazeNavPresenter();
        MazeNavInputBoundary mnib = new MazeNavInteractor(mnob);
        MazeNavController mnc = new MazeNavController(mnib);

        MazeNavUI mazeNavUI = new MazeNavUI(mnc);
        MazeRetrieverUI mazeRetrieverUI = new MazeRetrieverUI(mrc, mdcr);




        ScreenManager.setStage(primaryStage);
        ScreenManager.addScreen("designer", mdui);
        ScreenManager.addScreen("login", lui);
        ScreenManager.addScreen("register", rui);
        ScreenManager.addScreen("home", mazeRetrieverUI);
        ScreenManager.addScreen("game", mazeNavUI);

        ScreenManager.changeScreen("login");

    }
}
