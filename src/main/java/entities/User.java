package entities;

public abstract class User {

    protected String username;
    protected String password;
    protected String userType;
    protected String creationTime;

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