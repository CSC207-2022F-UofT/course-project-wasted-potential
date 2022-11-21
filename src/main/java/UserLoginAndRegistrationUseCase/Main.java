package UserLoginAndRegistrationUseCase;
import RegisterAndLoginSharedClasses.UserRegisterAndLoginDsGateway;
import RegisterAndLoginSharedClasses.RegisterAndLoginViewInterface;
import RegisterAndLoginSharedClasses.RegisterAndLoginView;
import UserRegistration.*;
import entities.UserFactory;
import screens.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args){

        UserRegisterAndLoginDsGateway user;

        try{
            user = new UserDatabase("./users.csv");
            } catch (IOException e){
            throw new RuntimeException("File could not be created");
        }

        /* Make separate for login and register */
        RegisterAndLoginViewInterface view = new RegisterAndLoginView();
        URegPresenter presenter = new URegisterResponseFormatter(view);
        UserFactory userFactory = new UserFactory();
        URegInputBoundary registerInteractor = new UserRegisterInteractor(user, presenter, userFactory);
        UserRegisterController registerController = new UserRegisterController(registerInteractor);


    }
}
