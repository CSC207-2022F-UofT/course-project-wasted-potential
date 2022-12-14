package user_login;

/**
 * The User login presenter.
 */
public class UserLoginPresenter implements ULoginOutputBoundary {

    @Override
    public UserLoginResponseModel successView(UserLoginResponseModel userResponseModel) {
        return userResponseModel;
    }

    @Override
    public UserLoginResponseModel failView(String errorMessage) {
        throw new UserLoginError(errorMessage);
    }
}
