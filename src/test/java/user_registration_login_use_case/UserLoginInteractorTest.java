package user_registration_login_use_case;

import user_login.*;
import entities.Player;
import entities.User;
import org.junit.jupiter.api.Test;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import databases.TemporaryMemoryAccess;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests for the UserLoginInteractor class.
 */
class UserLoginInteractorTest {
    /**
     * Tests the case the user exists in the database but their password does not match the one in the database.
     */
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

    /**
     * Tests the case the user exists in the database and their password matches
     * the one associated to their user in the database.
     */
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

    /**
     * Tests the case the username does not exist in the database
     */
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
