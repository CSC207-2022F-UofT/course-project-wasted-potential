package UserLogin;

import RegisterAndLoginSharedClasses.RegisterAndLoginViewInterface;

public class UserLoginResponseFormatter implements ULoginPresenter{
    final RegisterAndLoginViewInterface view;

    public UserLoginResponseFormatter(RegisterAndLoginViewInterface view) {
        this.view = view;
    }

    /* Implement playerSuccessView when player view finished */

    @Override
    public UserLoginResponseModel designerSuccessView(UserLoginResponseModel userResponseModel) {
        view.updateDesignerView();
        return userResponseModel;
    }

    @Override
    public UserLoginResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);
    }
}
