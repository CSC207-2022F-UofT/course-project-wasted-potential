package register_and_login_shared_classes;
import entities.User;

public interface UserRegisterAndLoginDsGateway {

    public void save(User user);

    public boolean existsByName(String username);

    public boolean checkValidPassword(String username, String password);

    public String getUserType(String username);

}
