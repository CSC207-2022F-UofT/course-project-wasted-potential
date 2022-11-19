package UserLogin;
import screens.UserDatabase;

public class UserLoginInteractor implements ULoginInputBoundary{
    final UserLoginDsGateway dsGateway;
    final ULoginPresenter presenter;
    final UserDatabase database;

    public UserLoginInteractor(UserLoginDsGateway dsGateway, ULoginPresenter presenter, UserDatabase database){
        this.dsGateway = dsGateway;
        this.presenter = presenter;
        this.database = database;
    }

    @Override
    public void logUserIn(UserLoginRequestModel user) {
        if (database.existsByName(user.getUsername())){
            if (database.checkValidPassword(user.getUsername(), user.getPassword())){
                String userType = database.getUserType(user.getUsername());
                UserLoginDsRequestModel userRequestModel = new UserLoginDsRequestModel(user.getUsername(), userType);
                dsGateway.logUserIn(userRequestModel);
            } else {
                presenter.failView("Incorrect password. Try again.");
            }
        } else {
            presenter.failView("No such user exists.");
        }
    }

}
