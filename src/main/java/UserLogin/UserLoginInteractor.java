package UserLogin;
import UserRegistration.UserRegisterDsGateway;

public class UserLoginInteractor implements ULoginInputBoundary{
    /* Change gateway so login and register share a gateway cus they share database which implements the same gateway*/
    final UserRegisterDsGateway dsGateway;
    final ULoginPresenter presenter;

    public UserLoginInteractor(UserRegisterDsGateway dsGateway, ULoginPresenter presenter){
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public void logUserIn(UserLoginRequestModel user) {
        if (dsGateway.existsByName(user.getUsername())){
            if (dsGateway.checkValidPassword(user.getUsername(), user.getPassword())){
                String userType = dsGateway.getUserType(user.getUsername());

                UserLoginResponseModel userResponseModel = new UserLoginResponseModel(user.getUsername(), userType);
                presenter.successView(userResponseModel);
            } else {
                presenter.failView("Incorrect password. Try again.");
            }
        } else {
            presenter.failView("No such user exists.");
        }
    }

}
