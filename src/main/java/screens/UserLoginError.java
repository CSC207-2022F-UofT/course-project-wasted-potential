package screens;

/**
 * A subclass of the RuntimeException class when there is an error logging in the user.
 */
public class UserLoginError extends RuntimeException{
    /**
     * Instantiates a new user login error
     *
     * @param error the error message
     */
    public UserLoginError(String error) {
        super(error);
    }
}
