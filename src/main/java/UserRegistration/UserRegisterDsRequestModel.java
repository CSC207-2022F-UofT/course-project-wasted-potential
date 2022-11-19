package UserRegistration;

public class UserRegisterDsRequestModel {
    private final String username;
    private String password;
    private final String userType;
    private final String creationTime;

    public UserRegisterDsRequestModel(String username, String userType, String password, String creationTime) {
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

    public String getUserType(){
        return this.userType;
    }

    public String getCreationTime(){
        return this.creationTime;
    }


}
