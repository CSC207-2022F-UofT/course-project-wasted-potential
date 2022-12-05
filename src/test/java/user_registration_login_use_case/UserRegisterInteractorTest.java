package user_registration_login_use_case;

import UserLogin.*;
import UserRegistration.*;
import entities.Designer;
import entities.User;
import entities.UserFactory;
import org.junit.jupiter.api.Test;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;
import screens.TemporaryMemoryAccess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class UserRegisterInteractorTest {
    @Test
    void usernameExists(){

        UserRegisterAndLoginDsGateway gateway = new TemporaryMemoryAccess();
        URegOutputBoundary outputBoundary = new URegisterPresenter();
        UserFactory userFactory = new UserFactory();
        UserRegisterInteractor interactor = new UserRegisterInteractor(gateway, outputBoundary, userFactory);
        UserRegisterRequestModel inputData = new UserRegisterRequestModel("bartholomew", "cool",
                "cool", "Designer");

        User user = new Designer("bartholomew", "pwd987", "2022-12-02 18:05");
        gateway.save(user);


        try{
            UserRegisterResponseModel responseModel = interactor.createUser(inputData);
        } catch (RuntimeException e){
            assertEquals("This username is already in use.", e.getMessage());
        }

    }

    @Test
    void passwordsDoNotMatch(){
        UserRegisterAndLoginDsGateway gateway = new TemporaryMemoryAccess();
        URegOutputBoundary outputBoundary = new URegisterPresenter();
        UserFactory userFactory = new UserFactory();
        UserRegisterInteractor interactor = new UserRegisterInteractor(gateway, outputBoundary, userFactory);
        UserRegisterRequestModel inputData = new UserRegisterRequestModel("bartholomew", "cool",
                "notcool", "Designer");

        try{
            UserRegisterResponseModel responseModel = interactor.createUser(inputData);
        } catch (RuntimeException e){
            assertEquals("Passwords do not match.", e.getMessage());
        }
    }

    @Test
    void createPlayer(){
        UserRegisterAndLoginDsGateway gateway = new TemporaryMemoryAccess();
        URegOutputBoundary outputBoundary = new URegisterPresenter();
        UserFactory userFactory = new UserFactory();
        UserRegisterInteractor interactor = new UserRegisterInteractor(gateway, outputBoundary, userFactory);
        UserRegisterRequestModel inputData = new UserRegisterRequestModel("harry", "jeep",
                "jeep", "Player");

        UserRegisterResponseModel responseModel = interactor.createUser(inputData);

        assertEquals("harry", responseModel.getUsername());
        assertEquals("Player", responseModel.getUserType());
        assertNotNull(responseModel.getCreationTime());

        // Checks the data in the CSV File
        assertEquals(true, gateway.existsByName("harry"));
        assertEquals("Player", gateway.getUserType("harry"));
        assertEquals(true, gateway.checkValidPassword("harry", "jeep"));
    }

    @Test
    void createDesigner(){
        UserRegisterAndLoginDsGateway gateway = new TemporaryMemoryAccess();
        URegOutputBoundary outputBoundary = new URegisterPresenter();
        UserFactory userFactory = new UserFactory();
        UserRegisterInteractor interactor = new UserRegisterInteractor(gateway, outputBoundary, userFactory);
        UserRegisterRequestModel inputData = new UserRegisterRequestModel("carl",
                "verystrongpassword123", "verystrongpassword123", "Designer");

        UserRegisterResponseModel responseModel = interactor.createUser(inputData);

        assertEquals("carl", responseModel.getUsername());
        assertEquals("Designer", responseModel.getUserType());
        assertNotNull(responseModel.getCreationTime());

        // Checks the data in the CSV File
        assertEquals(true, gateway.existsByName("carl"));
        assertEquals("Designer", gateway.getUserType("carl"));
        assertEquals(true, gateway.checkValidPassword("carl", "verystrongpassword123"));
    }
}
