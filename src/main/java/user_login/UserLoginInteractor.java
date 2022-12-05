package user_login;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;

/**
 * The interactor which implements the input boundary and logs
 * the user in and calling methods in the presenter to update the view correspondingly.
 */

public class UserLoginInteractor implements ULoginInputBoundary{

    final UserRegisterAndLoginDsGateway dsGateway;
    final ULoginOutputBoundary presenter;

    /**
     * The constructor that instantiates a new UserLoginInteractor.
     *
     * @param dsGateway the gateway
     * @param presenter the presenter
     */

    public UserLoginInteractor(UserRegisterAndLoginDsGateway dsGateway, ULoginOutputBoundary presenter){
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public UserLoginResponseModel logUserIn(UserLoginRequestModel user) {
        if (dsGateway.existsByName(user.getUsername())){
            if (dsGateway.checkValidPassword(user.getUsername(), user.getPassword())){
                String userType = dsGateway.getUserType(user.getUsername());

                UserLoginResponseModel userResponseModel = new UserLoginResponseModel(user.getUsername(), userType);
                return presenter.successView(userResponseModel);

            } else {
                return presenter.failView("Incorrect password. Try again.");
            }
        } else {
            return presenter.failView("No such user exists.");
        }

    }

}
