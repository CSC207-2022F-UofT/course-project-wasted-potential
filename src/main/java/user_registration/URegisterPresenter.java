package user_registration;

import screens.UserCreationError;

public class URegisterPresenter implements URegOutputBoundary {

    @Override
    public UserRegisterResponseModel successView(UserRegisterResponseModel userResponseModel) {
        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new UserCreationError(errorMessage);

    }
}
