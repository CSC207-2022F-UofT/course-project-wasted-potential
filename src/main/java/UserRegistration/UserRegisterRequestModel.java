package UserRegistration;

public class UserRegisterRequestModel {
    private String username;
    private String password;
    private String repeatPassword;
    private String userType;

    public UserRegisterRequestModel(String username, String password, String repeatPassword, String userType){
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.userType = userType;
    }

    public String getUsername(){
        return this.username;
    }

    public String getUserType(){
        return this.userType;
    }

    public String getPassword(){
        return this.password;
    }

    public String getRepeatPassword(){
        return this.repeatPassword;
    }
}
