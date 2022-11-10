package entities;

public abstract class User {

    private String user;
    private String password;

    public User(String username, String password){
        this.user = username;
        this.password = password;
    }

    public abstract void loginUser();

    public abstract void logoutUser();


    public String getUser(){
        return this.user;
    }



}