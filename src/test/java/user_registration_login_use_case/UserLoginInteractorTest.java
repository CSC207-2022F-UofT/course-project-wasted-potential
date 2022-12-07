package user_registration_login_use_case;

import user_login.*;
import entities.Player;
import entities.User;
import org.junit.jupiter.api.Test;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import screens.TemporaryMemoryAccess;

import java.util.ArrayList;

import static org.junit.Assert.*;

 class UserLoginInteractorTest {
    @Test
     void nameExistsPasswordInvalid(){

        UserRegisterAndLoginDsGateway gateway = new TemporaryMemoryAccess();
        ULoginOutputBoundary outputBoundary = new UserLoginPresenter();
        UserLoginInteractor interactor = new UserLoginInteractor(gateway, outputBoundary);
        UserLoginRequestModel inputData = new UserLoginRequestModel("rick", "rick123");

        User user = new Player("rick", "123", "2022-12-04 17:19", new ArrayList<>());
        gateway.save(user);

        try{
            UserLoginResponseModel responseModel = interactor.logUserIn(inputData);
        } catch (RuntimeException e){
            assertEquals("Incorrect password. Try again.", e.getMessage());
        }

    }

    @Test
     void nameExistsPasswordValid(){

        UserRegisterAndLoginDsGateway gateway = new TemporaryMemoryAccess();
        ULoginOutputBoundary outputBoundary = new UserLoginPresenter();
        UserLoginInteractor interactor = new UserLoginInteractor(gateway, outputBoundary);
        UserLoginRequestModel inputData = new UserLoginRequestModel("nick", "yeah");

        User user = new Player("nick", "yeah", "2022-12-04 17:19", new ArrayList<>());
        gateway.save(user);


        UserLoginResponseModel responseModel = interactor.logUserIn(inputData);

        assertEquals("nick", responseModel.getUsername());
        assertNotNull(responseModel.getUserType());

    }

    @Test
     void usernameDoesNotExist(){

        UserRegisterAndLoginDsGateway gateway = new TemporaryMemoryAccess();
        ULoginOutputBoundary outputBoundary = new UserLoginPresenter();
        UserLoginInteractor interactor = new UserLoginInteractor(gateway, outputBoundary);
        UserLoginRequestModel inputData = new UserLoginRequestModel("bob", "securepassword");


        try{
            UserLoginResponseModel responseModel = interactor.logUserIn(inputData);
        } catch (RuntimeException e){
            assertEquals("No such user exists.", e.getMessage());
        }

    }
}
