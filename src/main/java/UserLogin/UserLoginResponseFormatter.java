package UserLogin;

public class UserLoginResponseFormatter implements ULoginPresenter{

    @Override
    public UserLoginResponseModel successView(UserLoginResponseModel userResponseModel) {
        return userResponseModel;
    }

    @Override
    public UserLoginResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);
    }
}
