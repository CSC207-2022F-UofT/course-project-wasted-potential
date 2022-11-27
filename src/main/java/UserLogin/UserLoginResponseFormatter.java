package UserLogin;


public class UserLoginResponseFormatter implements ULoginPresenter{
    final UserLoginViewInterface view;

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
