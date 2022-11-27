package UserRegistration;

public class URegisterResponseFormatter implements URegPresenter {
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
        view.updatePlayerView();
        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel designerSuccessView(UserRegisterResponseModel userResponseModel){
        view.updateDesignerView();
        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);

    }
}
