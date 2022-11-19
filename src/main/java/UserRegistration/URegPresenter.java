package UserRegistration;

public interface URegPresenter{
    UserRegisterResponseModel successView(UserRegisterResponseModel userResponseModel);

    UserRegisterResponseModel failView(String errorMessage);
}
