package user_login;

public interface ULoginOutputBoundary {
    /**
     * Returns the user response model containing username and user type.
     *
     * @param userResponseModel the response model
     * @return the response model
     */
    UserLoginResponseModel successView(UserLoginResponseModel userResponseModel);

    /**
     * Throws a runtime exception with the given error message.
     *
     * @param errorMessage the error message
     * @return the response model
     */
    UserLoginResponseModel failView(String errorMessage);
}
