package user_registration;

public class URegisterPresenter implements URegOutputBoundary {

    @Override
    public UserRegisterResponseModel successView(UserRegisterResponseModel userResponseModel) {
        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new IllegalArgumentException(errorMessage);

    }
}
