package user_login;

/**
 * The response model which stores the user's username and user type.
 */

public class UserLoginResponseModel {
    private final String username;
    private final String userType;

    /**
     * The constructor that instantiates a new response model
     *
     * @param username the user's username
     * @param userType the user's user type
     */

    public UserLoginResponseModel(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }

    /**
     * Returns the user's user type as a string.
     *
     * @return the user's user type
     */

    public String getUserType(){
        return this.userType;
    }

    public String getUsername(){
        return this.username;
    }
}
