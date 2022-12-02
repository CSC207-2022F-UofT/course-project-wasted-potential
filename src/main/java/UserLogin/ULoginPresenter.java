package UserLogin;

public interface ULoginPresenter {
    /**
     * Returns the user response model containing username and user type.
     *
     * @param userResponseModel the response model
     * @return the response model
     */
    public UserLoginResponseModel successView(UserLoginResponseModel userResponseModel);

    /**
     * Throws a runtime exception with the given error message.
     *
     * @param errorMessage the error message
     * @return the response model
     */
    public UserLoginResponseModel failView(String errorMessage);
}
