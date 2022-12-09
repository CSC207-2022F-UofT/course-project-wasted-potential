package screens;

/**
 * The type User singleton.
 */
public class UserSingleton {

    private static UserSingleton instance;
    private String username;

    private UserSingleton() {
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
