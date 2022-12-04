package entities;

import java.util.List;

public class Player extends User{

    private List<Integer> mazesPlayed;

    public Player(String username, String password, String creationTime){
        super(username, password, "Player", creationTime);
    }

    public List<Integer> getMazesPlayed() {
        return this.mazesPlayed;
    }
}