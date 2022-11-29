package UserRegistration;

public class URegisterResponseFormatter implements URegPresenter {

    @Override
    public UserRegisterResponseModel successView(UserRegisterResponseModel userResponseModel) {
        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);

    }
}
