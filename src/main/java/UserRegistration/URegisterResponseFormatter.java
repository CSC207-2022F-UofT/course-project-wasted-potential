package UserRegistration;
import RegisterAndLoginSharedClasses.RegisterAndLoginViewInterface;

public class URegisterResponseFormatter implements URegPresenter {

    final RegisterAndLoginViewInterface view;

    public URegisterResponseFormatter(RegisterAndLoginViewInterface view) {
        this.view = view;
    }

    @Override
    public UserRegisterResponseModel playerSuccessView(UserRegisterResponseModel userResponseModel) {

        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel designerSuccessView(UserRegisterResponseModel userResponseModel){

        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);

    }
}
