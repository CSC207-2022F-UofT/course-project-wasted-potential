package UserRegistration;

public interface URegPresenter{
    UserRegisterResponseModel playerSuccessView(UserRegisterResponseModel userResponseModel);

    UserRegisterResponseModel designerSuccessView(UserRegisterResponseModel userRegisterResponseModel);

    UserRegisterResponseModel failView(String errorMessage);
}
