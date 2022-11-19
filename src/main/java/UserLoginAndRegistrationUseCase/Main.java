package UserLoginAndRegistrationUseCase;
import UserRegistration.*;
import entities.UserFactory;
import screens.*;
import javafx.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        try{
            UserDatabase user = new UserDatabase("./users.csv");
            } catch (IOException e){
            throw new RuntimeException("File could not be created");
        }
        /* Make separate for login and register */
        URegPresenter regPresenter = new URegisterResponseFormatter();
        UserFactory userFactory = new UserFactory();
        URegInputBoundary regInteractor = new UserRegisterInteractor();
        UserRegisterController regController = new UserRegisterController();
    }
}
