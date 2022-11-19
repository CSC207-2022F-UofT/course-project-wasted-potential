package entities;

public abstract class User {

    private String username;
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

    public String getCreationTime(){
        return this.creationTime;
    }



}