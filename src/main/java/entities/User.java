package entities;

public abstract class User {

    private String username;
    private String password;
    private User userType;

    public User(String username, String password, User userType){
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public abstract void userLogin();

    public abstract void userLogout();


    public String getUsername(){
        return this.username;
    }

    public User getUserType(){
        return this.userType;
    }



}