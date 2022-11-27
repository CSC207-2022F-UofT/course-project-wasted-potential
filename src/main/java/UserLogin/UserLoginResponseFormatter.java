package UserLogin;

public class UserLoginResponseFormatter implements ULoginPresenter{
    /**
     * The instance variable view which stores an instance of the UserLoginViewInterface class.
     */
    final UserLoginViewInterface view;

    /**
     * The constructor that instantiates a new UserLoginResponseFormatter.
     * @param view the view interface
     */
    public UserLoginResponseFormatter(UserLoginViewInterface view) {
        this.view = view;
    }


    @Override
    public UserLoginResponseModel designerSuccessView(UserLoginResponseModel userResponseModel) {
        view.updateDesignerView();
        return userResponseModel;
    }

    @Override
    public UserLoginResponseModel playerSuccessView(UserLoginResponseModel userResponseModel) {
        view.updatePlayerView();
        return userResponseModel;
    }

    @Override
    public UserLoginResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);
    }
}
