package entities;

public abstract class User {

    private String user;
    private String password;
    private String userType;
    private String creationTime;

    public User(String username, String password, String userType, String creationTime){
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.creationTime = creationTime;
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

    public User(String username, String password){
        this.user = username;
        this.password = password;
    }

    public abstract void userLogin();

    public abstract void userLogout();


    public String getUser(){
        return this.user;
    }



}