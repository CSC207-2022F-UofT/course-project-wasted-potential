package user_registration;

public class UserRegisterController {
    final URegInputBoundary userInput;

    /**
     * The constructor that instantiates the UserRegisterController class.
     *
     * @param accountGateway the input boundary
     */
    public UserRegisterController(URegInputBoundary accountGateway){
        this.userInput = accountGateway;
    }

    /**
     * Returns a response model containing the username, password and creation time of the registered user.
     *
     * @param username       the user's username
     * @param password       the user's password
     * @param repeatPassword the user's repeated password
     * @param userType       the user's user type
     * @return a user response model
     */
    public UserRegisterResponseModel registerUser(String username, String password, String repeatPassword, String userType){
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(username, password,
                repeatPassword, userType);
        return userInput.createUser(requestModel);
    }
}
