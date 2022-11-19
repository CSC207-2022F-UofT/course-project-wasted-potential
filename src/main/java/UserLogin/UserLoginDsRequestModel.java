package UserLogin;

public class UserLoginDsRequestModel {
    private final String username;
    private final String userType;

    public UserLoginDsRequestModel(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUsername(){
        return this.username;
    }

    public String getUserType(){
        return this.userType;
    }

}
