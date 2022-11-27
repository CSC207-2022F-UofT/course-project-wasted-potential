package UserLogin;

public class UserLoginController {
    final ULoginInputBoundary userInput;


    public UserLoginController(ULoginInputBoundary userInput) {
        this.userInput = userInput;
    }

    public UserLoginResponseModel loginUser(String username, String password){
        UserLoginRequestModel requestModel = new UserLoginRequestModel(username, password);
        return userInput.logUserIn(requestModel);
    }
}
