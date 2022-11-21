package UserRegistration;
import RegisterAndLoginSharedClasses.RegisterAndLoginViewInterface;

/**
 * The type U register response formatter.
 */
public class URegisterResponseFormatter implements URegPresenter {

    /**
     * The View.
     */
    final RegisterAndLoginViewInterface view;

    /**
     * Instantiates a new U register response formatter.
     *
     * @param view the view
     */
    public URegisterResponseFormatter(RegisterAndLoginViewInterface view) {
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
