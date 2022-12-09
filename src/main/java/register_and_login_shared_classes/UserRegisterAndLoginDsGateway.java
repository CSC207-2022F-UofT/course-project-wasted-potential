package register_and_login_shared_classes;
import entities.User;

/**
 * The interface User register and login ds gateway.
 */
public interface    UserRegisterAndLoginDsGateway {

    /**
     * Save.
     *
     * @param user the user
     */
    void save(User user);

    /**
     * Exists by name boolean.
     *
     * @param username the username
     * @return the boolean
     */
    boolean existsByName(String username);

    /**
     * Check valid password boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    boolean checkValidPassword(String username, String password);

    /**
     * Gets user type.
     *
     * @param username the username
     * @return the user type
     */
    String getUserType(String username);

}