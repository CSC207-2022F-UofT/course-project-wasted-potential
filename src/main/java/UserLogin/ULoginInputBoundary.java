package UserLogin;

public interface ULoginInputBoundary {
    /**
     * Returns a response model, logs the user into the program.
     * @param userRequestModel the user request model
     * @return the user response model
     */
    public UserLoginResponseModel logUserIn(UserLoginRequestModel userRequestModel);
}
