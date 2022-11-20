package UserRegistration;

public class URegisterResponseFormatter implements URegPresenter {

    @Override
    public UserRegisterResponseModel successView(UserRegisterResponseModel userResponseModel) {
        if(userResponseModel.getUserType().equals("Player")){
            /* change to designer view */
        } else {
            /* change view */
        }
        return userResponseModel;
    }

    @Override
    public UserRegisterResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);

    }
}
