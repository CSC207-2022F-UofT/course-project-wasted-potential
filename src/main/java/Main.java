import UserLogin.*;
import UserRegistration.*;
import entities.UserFactory;
import javafx.stage.Stage;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import screens.LoginUI;
import screens.UserDatabase;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        UserRegisterAndLoginDsGateway gateway;

        UserRegisterAndLoginDsGateway user;
        try{
            user = new UserDatabase("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        // Initializing User Registration Classes
        URegPresenter regPresenter = new URegisterResponseFormatter();
        UserFactory userFactory = new UserFactory();
        URegInputBoundary regInteractor = new UserRegisterInteractor(gateway, regPresenter, userFactory);
        UserRegisterController regController = new UserRegisterController(regInteractor);

        // Initializing User Login Classes
        ULoginPresenter logPresenter = new UserLoginResponseFormatter();
        ULoginInputBoundary logInteractor = new UserLoginInteractor(gateway, logPresenter);
        UserLoginController logController = new UserLoginController(logInteractor);

        // Initialize screens
        Stage stage = new Stage();
        LoginUI loginUI = new LoginUI(logController);
        loginUI.start(stage);
    }
}
