package UserLogin;

public interface ULoginPresenter {
    public UserLoginResponseModel designerSuccessView(UserLoginResponseModel userResponseModel);

    public UserLoginResponseModel playerSuccessView(UserLoginResponseModel userResponseModel);

    public UserLoginResponseModel failView(String errorMessage);
}
