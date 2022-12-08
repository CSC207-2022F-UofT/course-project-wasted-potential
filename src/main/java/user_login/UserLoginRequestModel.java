package user_login;

/**
 * The user request model which stores all the information the user inputs in the login screen.
 */
public class UserLoginRequestModel {
    private final String username;
    private final String password;

    /**
     * The constructor that instantiates a new UserLoginRequestModel.
     *
     * @param username the user's username
     * @param password the user's password
     */
    public UserLoginRequestModel(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the user's username as a string.
     *
     * @return the user's username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Returns the user's password as a string.
     *
     * @return the user's password
     */

    public String getPassword(){
        return this.password;
    }

}
