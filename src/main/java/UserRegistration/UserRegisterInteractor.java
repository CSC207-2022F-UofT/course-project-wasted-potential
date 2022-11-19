package UserRegistration;

public class UserRegisterInteractor implements URegInputBoundary{

    final UserRegisterDsGateway dsGateway;
    final URegPresenter presenter;

    public UserRegisterInteractor(UserRegisterDsGateway dsGateway, URegPresenter presenter){
        this.dsGateway = dsGateway;
        this.presenter = presenter;
    }

    @Override
    public void createUser(UserRegisterRequestModel userRequestModel) {
        boolean validPassword = userRequestModel.getPassword().equals(userRequestModel.getRepeatPassword());
        if (validPassword){
            dsGateway.storeUser(userRequestModel);
        } else {
            presenter.failView("Passwords do not match.");
        }
    }
}
