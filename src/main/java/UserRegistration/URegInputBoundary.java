package UserRegistration;

/**
 * The interface U reg input boundary.
 */
public interface URegInputBoundary {
    /**
     * Create user user register response model.
     *
     * @param userRequestModel the user request model
     * @return the user register response model
     */
    public UserRegisterResponseModel createUser(UserRegisterRequestModel userRequestModel);
}
