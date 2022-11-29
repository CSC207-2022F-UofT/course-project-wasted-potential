package UserRegistration;

public interface URegPresenter{
    /**
     * Returns the user response model containing username, user type and creation time.
     *
     * @param userResponseModel the response model
     * @return the response model
     */
    UserRegisterResponseModel successView(UserRegisterResponseModel userResponseModel);

    /**
     * Throws a runtime exception with the given error message.
     *
     * @param errorMessage the error message
     * @return the response model
     */
    UserRegisterResponseModel failView(String errorMessage);
}
