package UserRegistration;

public class URegisterPresenter implements URegOutputBoundary {

    @Override
    public UserRegisterResponseModel successView(UserRegisterResponseModel userResponseModel) {
        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);

    }
}
