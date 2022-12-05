import design.*;
import UserLogin.*;
import UserRegistration.*;
import entities.UserFactory;
import javafx.stage.Stage;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import screens.LoginUI;
import screens.RegisterUI;
import screens.UserDatabase;
import publish.MazeDatabase;
import publish.MazePublishInteractor;
import publish.MazePublisherControl;
import publish.MazePublisherPresenter;
import publish.*;
import screens.MazeDatabase;
import screens.MazeDesignerUI;
import java.io.IOException;
import javafx.application.Application;
import screens.Screen;
import screens.ScreenManager;
import solvability.*;

import java.io.IOException;
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


        MazePublisherPresenter mpp = new MazePublisherPresenter();
        MazeDatabase md;
        PublishMazePresenter mpp = new PublishMazePresenter();
        PublishMazeGateway md;
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

        ScreenManager.setStage(primaryStage);
        ScreenManager.addScreen("designer", mdui);
        ScreenManager.addScreen("login", lui);
        ScreenManager.addScreen("register", rui);
        ScreenManager.changeScreen("login");
    }
}
