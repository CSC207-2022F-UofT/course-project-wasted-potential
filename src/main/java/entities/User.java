package entities;

/**
 * The type User.
 */
public abstract class User {

    /**
     * The username of the user.
     */
    protected String username;
    /**
     * The password of the user.
     */
    protected String password;
    /**
     * The type of user.
     */
    protected String userType;
    /**
     * The creation time of the account.
     */
    protected String creationTime;

    /**
     * Instantiates a new User.
     *
     * @param username     the username of the user.
     * @param password     the password of the user.
     * @param userType     the user type.
     * @param creationTime the creation time of the account.
     */
    protected User(String username, String password, String userType, String creationTime){
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.creationTime = creationTime;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Gets the type of the user.
     *
     * @return the user type
     */
    public String getUserType(){
        return this.userType;
    }

    /**
     * Get the password of the user.
     *
     * @return the password of the user
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Get the creation time of the account.
     *
     * @return the creation time of the account
     */
    public String getCreationTime(){
        return this.creationTime;
    }

}