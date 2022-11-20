package UserRegistration;
import entities.User;

public interface UserRegisterDsGateway {

    public void save(User user);

    public boolean existsByName(String username);

    public boolean checkValidPassword(String username, String password);
    public String getUserType(String username);


}
