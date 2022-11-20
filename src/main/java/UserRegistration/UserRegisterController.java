package UserRegistration;

public class UserRegisterController {
    final URegInputBoundary userInput;

    public UserRegisterController(URegInputBoundary accountGateway){
        this.userInput = accountGateway;
    }

    public UserRegisterResponseModel registerUser(String username, String password, String repeatPassword, String userType){
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(username, password,
                repeatPassword, userType);
        return userInput.createUser(requestModel);
    }
}
