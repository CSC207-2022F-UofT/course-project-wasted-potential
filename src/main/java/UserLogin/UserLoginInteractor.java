package UserLogin;
import RegisterAndLoginSharedClasses.UserRegisterAndLoginDsGateway;

public class UserLoginInteractor implements ULoginInputBoundary{

    final UserRegisterAndLoginDsGateway dsGateway;
    final ULoginPresenter presenter;

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
                if(userResponseModel.getUserType().equals("Player")){
                    System.out.println("lol");
                    /* change to player view */
                } else {
                    presenter.designerSuccessView(userResponseModel);
                }

            } else {
                presenter.failView("Incorrect password. Try again.");
            }
        } else {
            presenter.failView("No such user exists.");
        }
        return new UserLoginResponseModel(null, null);
    }

}
