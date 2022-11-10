package UserRegistration;
import entities.User;

public class UserRegisterDsRequestModel {
    private String username;
    private String password;
    private User userType;
    /* Not sure what type creationTime is stored as */
    private Object creationTime;

    public UserRegisterDsRequestModel(String username, User userType, String password, Object creationTime) {
        this.username = username;
        this.userType = userType;
        this.password = password;
        this.creationTime = creationTime;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public User getUserType(){
        return this.userType;
    }

    public Object getCreationTime(){
        return this.creationTime;
    }


}
