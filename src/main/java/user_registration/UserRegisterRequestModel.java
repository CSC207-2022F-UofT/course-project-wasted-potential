package user_registration;

/**
 * The user request model which stores all the information the user inputs.
 */
public class UserRegisterRequestModel {
    private String username;
    private String password;
    private String repeatPassword;
    private String userType;

    /**
     * Instantiates a new request model.
     *
     * @param username       the username
     * @param password       the password
     * @param repeatPassword the repeat password
     * @param userType       the user type
     */
    public UserRegisterRequestModel(String username, String password, String repeatPassword, String userType){
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.userType = userType;
    }

    /**
     * Returns the username as a string.
     *
     * @return the user's username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Returns the user type as a string.
     *
     * @return the user's user type
     */
    public String getUserType(){
        return this.userType;
    }

    /**
     * Returns the password as a string.
     *
     * @return the user's password
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Returns the repeated password as a string.
     *
     * @return the user's repeated password
     */
    public String getRepeatPassword(){
        return this.repeatPassword;
    }
}
