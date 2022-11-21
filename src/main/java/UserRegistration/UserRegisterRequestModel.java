package UserRegistration;

/**
 * The type User register request model.
 */
public class UserRegisterRequestModel {
    private String username;
    private String password;
    private String repeatPassword;
    private String userType;

    /**
     * Instantiates a new User register request model.
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
     * Get username string.
     *
     * @return the string
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Get user type string.
     *
     * @return the string
     */
    public String getUserType(){
        return this.userType;
    }

    /**
     * Get password string.
     *
     * @return the string
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Get repeat password string.
     *
     * @return the string
     */
    public String getRepeatPassword(){
        return this.repeatPassword;
    }
}
