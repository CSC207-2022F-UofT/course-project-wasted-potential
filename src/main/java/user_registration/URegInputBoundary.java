package user_registration;

public interface URegInputBoundary {
    /**
     * Returns a response model, creates the user in the database and logs them in automatically.
     *
     * @param userRequestModel the user request model
     * @return the user response model
     */
    UserRegisterResponseModel createUser(UserRegisterRequestModel userRequestModel);
}
