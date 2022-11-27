package UserLogin;

/**
 * The presenter interface.
 */

public interface ULoginPresenter {
    /**
     * Returns the user response model and changes the view to the user type "Designer" view.
     *
     * @param userResponseModel the response model
     * @return the response model
     */
    public UserLoginResponseModel designerSuccessView(UserLoginResponseModel userResponseModel);

    /**
     * Returns the user response model and changes the view to the user type "Player" view.
     *
     * @param userResponseModel the response model
     * @return the response model
     */
    public UserLoginResponseModel playerSuccessView(UserLoginResponseModel userResponseModel);

    /**
     * Throws a runtime exception with the given error message.
     *
     * @param errorMessage the error message
     * @return the response model
     */
    public UserLoginResponseModel failView(String errorMessage);
}
