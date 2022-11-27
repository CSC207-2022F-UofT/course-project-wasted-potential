package UserRegistration;

public interface URegPresenter{
    /**
     * Returns the user response model and changes the view to the user type "Player" view.
     *
     * @param userResponseModel the response model
     * @return the response model
     */
    UserRegisterResponseModel playerSuccessView(UserRegisterResponseModel userResponseModel);

    /**
     * Returns the user response model and changes the view to the user type "Designer" view.
     *
     * @param userRegisterResponseModel the response model
     * @return the response model
     */
    UserRegisterResponseModel designerSuccessView(UserRegisterResponseModel userRegisterResponseModel);

    /**
     * Throws a runtime exception with the given error message.
     *
     * @param errorMessage the error message
     * @return the response model
     */
    UserRegisterResponseModel failView(String errorMessage);
}
