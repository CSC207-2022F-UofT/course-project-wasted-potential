package entities;

/**
 * The type Designer.
 */
public class Designer extends User{

    /**
     * Instantiates a new Designer.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param creationTime the time when the account was created
     */
    public Designer(String username, String password, String creationTime){
        super(username, password, "Designer", creationTime);
    }

}