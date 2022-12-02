import UserLogin.*;
import UserRegistration.*;
import entities.UserFactory;
import javafx.stage.Stage;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import screens.LoginUI;
import screens.RegisterUI;
import screens.UserDatabase;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import screens.Screen;
import screens.ScreenManager;

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

        ULoginPresenter logPresenter = new UserLoginResponseFormatter();
        ULoginInputBoundary logInteractor = new UserLoginInteractor(gateway, logPresenter);
        UserLoginController logController = new UserLoginController(logInteractor);
        Screen lui = new LoginUI(logController);

        URegPresenter regPresenter = new URegisterResponseFormatter();
        UserFactory userFactory = new UserFactory();
        URegInputBoundary regInteractor = new UserRegisterInteractor(gateway, regPresenter, userFactory);
        UserRegisterController regController = new UserRegisterController(regInteractor);
        Screen rui = new RegisterUI(regController);


        ScreenManager.setStage(primaryStage);
        ScreenManager.addScreen("login", lui);
        ScreenManager.addScreen("register", rui);
        ScreenManager.changeScreen("login");

    }
}
