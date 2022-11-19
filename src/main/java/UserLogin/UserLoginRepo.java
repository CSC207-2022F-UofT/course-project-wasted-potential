package UserLogin;

public class UserLoginRepo implements UserLoginDsGateway {
    final ULoginPresenter presenter;

    public UserLoginRepo(ULoginPresenter presenter) {
        this.presenter = presenter;
    }


    @Override
    public void logUserIn(UserLoginDsRequestModel user) {
        UserLoginResponseModel userResponseModel = new UserLoginResponseModel(user.getUsername(), user.getUserType());
        presenter.successView(userResponseModel);
    }
}
