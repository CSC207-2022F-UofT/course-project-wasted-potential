package UserLogin;

public class UserLoginController {
    final ULoginInputBoundary userInput;

    /**
     * The constructor that instantiates a new UserLoginController.
     *
     * @param userInput the input boundary
     */
    public UserLoginController(ULoginInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * Returns a response model containing the user's username and user type.
     *
     * @param username the user's username
     * @param password the user's password
     * @return the user response model
     */
    public UserLoginResponseModel loginUser(String username, String password){
        UserLoginRequestModel requestModel = new UserLoginRequestModel(username, password);
        return userInput.logUserIn(requestModel);
    }
}
