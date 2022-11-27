package RegisterAndLoginSharedClasses;
import entities.User;

public interface UserRegisterAndLoginDsGateway {

    /**
     * Saves user into the csv file with their username, user type, password and creation time.
     *
     * @param user the user
     */
    public void save(User user);

    /**
     * Returns a boolean indicating whether the username already exists in the database.
     *
     * @param username the username
     * @return a boolean indicating whether the username already exists in the database
     */
    public boolean existsByName(String username);

    /**
     * Returns a boolean indicating if the password matches the username
     * stored in the database, assuming the user exists in the database.
     *
     * @param username the user's username
     * @param password the user's password
     * @return the boolean indicating if the password matches the username.
     */
    public boolean checkValidPassword(String username, String password);

    /**
     * Returns the user's user type as a string.
     *
     * @param username the user's username
     * @return the user's user type
     */
    public String getUserType(String username);

}
