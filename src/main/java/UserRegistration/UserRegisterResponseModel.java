package UserRegistration;

/**
 * The type User register response model.
 */
public class UserRegisterResponseModel {
    private String username;
    private String userType;
    private String creationTime;

    /**
     * Instantiates a new User register response model.
     *
     * @param username     the username
     * @param userType     the user type
     * @param creationTime the creation time
     */
    public UserRegisterResponseModel(String username, String userType, String creationTime){
        this.username = username;
        this.userType = userType;
        this.creationTime = creationTime;
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

}
