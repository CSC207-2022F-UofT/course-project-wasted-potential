package UserLogin;

public interface ULoginPresenter {
    public UserLoginResponseModel successView(UserLoginResponseModel userResponseModel);

    public UserLoginResponseModel failView(String errorMessage);
}
