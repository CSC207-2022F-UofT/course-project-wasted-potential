package screens;

public class UserCreationError extends RuntimeException{
    public UserCreationError(String error) {
        super(error);
    }
}
