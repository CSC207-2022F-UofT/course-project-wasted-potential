package register_and_login_shared_classes;
import entities.User;

public interface    UserRegisterAndLoginDsGateway {

    void save(User user);

    boolean existsByName(String username);

    boolean checkValidPassword(String username, String password);

    String getUserType(String username);

}