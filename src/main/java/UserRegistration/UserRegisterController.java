package UserRegistration;

/**
 * The type User register controller.
 */
public class UserRegisterController {
    /**
     * The User input.
     */
    final URegInputBoundary userInput;

    /**
     * Instantiates a new User register controller.
     *
     * @param accountGateway the account gateway
     */
    public UserRegisterController(URegInputBoundary accountGateway){
        this.userInput = accountGateway;
    }

    /**
     * Register user user register response model.
     *
     * @param username       the username
     * @param password       the password
     * @param repeatPassword the repeat password
     * @param userType       the user type
     * @return the user register response model
     */
    public UserRegisterResponseModel registerUser(String username, String password, String repeatPassword, String userType){
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(username, password,
                repeatPassword, userType);
        return userInput.createUser(requestModel);
    }
}
