package UserRegistration;
import UserRegistration.UserRegisterResponseModel;
import UserRegistration.UserRegisterRequestModel;
import UserRegistration.URegInputBoundary;
public class UserRegisterController {
    final URegInputBoundary userInput;

    public UserRegisterController(URegInputBoundary accountGateway){
        this.userInput = accountGateway;
    }

    UserRegisterResponseModel registerUser(String username, String password, String repeatPassword, String userType){
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(username, password,
                repeatPassword, userType);
        return userInput.createUser(requestModel);
    }
}
