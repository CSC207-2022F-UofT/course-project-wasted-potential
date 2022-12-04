package entities;

import java.util.List;

/**
 * The type Player.
 */
public class Player extends User{

    private List<Integer> mazesPlayed;

    /**
     * Instantiates a new Player.
     *
     * @param username     the username of the Player
     * @param password     the password of the Player
     * @param creationTime the time the account was created
     */
    public Player(String username, String password, String creationTime){
        super(username, password, "Player", creationTime);
    }

    /**
     * Finds all the mazes the user has previously played.
     *
     * @return a list of mazes played by the user
     */
    public List<Integer> getMazesPlayed() {
        return this.mazesPlayed;
    }
}