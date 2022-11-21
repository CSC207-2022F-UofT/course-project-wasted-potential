package UserRegistration;

/**
 * The interface U reg presenter.
 */
public interface URegPresenter{
    /**
     * Player success view user register response model.
     *
     * @param userResponseModel the user response model
     * @return the user register response model
     */
    UserRegisterResponseModel playerSuccessView(UserRegisterResponseModel userResponseModel);

    /**
     * Designer success view user register response model.
     *
     * @param userRegisterResponseModel the user register response model
     * @return the user register response model
     */
    UserRegisterResponseModel designerSuccessView(UserRegisterResponseModel userRegisterResponseModel);

    /**
     * Fail view user register response model.
     *
     * @param errorMessage the error message
     * @return the user register response model
     */
    UserRegisterResponseModel failView(String errorMessage);
}
