package screens;

import entities.User;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;

import java.util.HashMap;
import java.util.Map;

/**
 * A Temporary Memory Access Class for the purpose of testing the user login and registration use cases.
 */
public class TemporaryMemoryAccess implements UserRegisterAndLoginDsGateway {

    private final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        System.out.println("Save" + user.getUsername());
        users.put(user.getUsername(), user);
    }

    @Override
    public boolean existsByName(String username) {
        return users.containsKey(username);
    }

    @Override
    public boolean checkValidPassword(String username, String password) {
        User userInfo = users.get(username);
        return userInfo.getPassword().equals(password);
    }

    @Override
    public String getUserType(String username) {
        User userInfo = users.get(username);
        return userInfo.getUserType();
    }
}
