package UserRegistration;

public class UserRegisterResponseModel {
    private String username;
    private String userType;
    private String creationTime;

    public UserRegisterResponseModel(String username, String userType, String creationTime){
        this.username = username;
        this.userType = userType;
        this.creationTime = creationTime;
    }

    public String getUsername(){
        return this.username;
    }

    public String getUserType(){
        return this.userType;
    }

}
