package user_registration;

/**
 * A subclass of the RuntimeException class when there is an error creating the user.
 */
public class UserCreationError extends RuntimeException{
    /**
     * Instantiates a new user creation error.
     *
     * @param error the error message
     */
    public UserCreationError(String error) {
        super(error);
    }
}
