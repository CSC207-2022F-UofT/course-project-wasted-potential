package UserLogin;

public class UserLoginResponseModel {
    private String username;
    private String userType;

    public UserLoginResponseModel(String username, String userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUserType(){
        return this.userType;
    }
}
