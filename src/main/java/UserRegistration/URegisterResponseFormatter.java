package UserRegistration;

/**
 * The type U register response formatter.
 */
public class URegisterResponseFormatter implements URegPresenter {

    /**
     * The View.
     */
    final UserRegisterViewInterface view;

    /**
     * Instantiates a new U register response formatter.
     *
     * @param view the view
     */
    public URegisterResponseFormatter(UserRegisterViewInterface view) {
        this.view = view;
    }

    @Override
    public UserRegisterResponseModel playerSuccessView(UserRegisterResponseModel userResponseModel) {

        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel designerSuccessView(UserRegisterResponseModel userResponseModel){

        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);

    }
}
