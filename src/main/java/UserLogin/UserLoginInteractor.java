package UserLogin;
import RegisterAndLoginSharedClasses.UserRegisterAndLoginDsGateway;

/**
 * The interactor which implements the input boundary and logs
 * the user in and calling methods in the presenter to update the view correspondingly.
 */

public class UserLoginInteractor implements ULoginInputBoundary{

    final UserRegisterAndLoginDsGateway dsGateway;
    final ULoginPresenter presenter;

    /**
     * The constructor that instantiates a new UserLoginInteractor.
     *
     * @param dsGateway the gateway
     * @param presenter the presenter
     */

    public UserLoginInteractor(UserRegisterAndLoginDsGateway dsGateway, ULoginPresenter presenter){
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public UserLoginResponseModel logUserIn(UserLoginRequestModel user) {
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
        return new UserLoginResponseModel(null, null);
    }

}
