package screens;

public class UserLoginError extends RuntimeException{
    public UserLoginError(String error) {
        super(error);
    }
}
