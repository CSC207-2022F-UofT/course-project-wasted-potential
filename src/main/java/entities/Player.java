package entities;

public class Player extends User{
    private String username;
    private String password;
    private String creationTime;

    public Player(String username, String password, String creationTime){
        super(username, password, "Player", creationTime);
    }

}

