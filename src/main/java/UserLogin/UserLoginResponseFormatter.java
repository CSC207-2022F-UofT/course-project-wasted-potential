package UserLogin;

public class UserLoginResponseFormatter implements ULoginPresenter{
    /* Finish This */
    @Override
    public UserLoginResponseModel successView(UserLoginResponseModel userResponseModel) {
        if(userResponseModel.getUserType().equals("Player")){
            /* change to player view */
        } else {
            /* change to designer view */
        }
        return userResponseModel;
    }

    @Override
    public UserLoginResponseModel failView(String errorMessage) {
        throw new RuntimeException(errorMessage);
    }
}
