package screens;

public class UserSingleton {

    private static UserSingleton instance;
    private String username;

    private UserSingleton(String username) {
        this.username = username;
    }

    public UserSingleton getInstance(String username) {
        if (instance == null) {
            instance = new UserSingleton(username);
        }
        return instance;
    }

    public String getUsername() {
        return this.username;
    }

}
