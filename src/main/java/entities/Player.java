package entities;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

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
     * @param mazesPlayed the mazes played by the user
     */
    public Player(String username, String password, String creationTime, List<Integer> mazesPlayed){
        super(username, password, "Player", creationTime);
        this.mazesPlayed = mazesPlayed;
    }

    /**
     * Finds all the mazes the user has previously played.
     *
     * @return a list of mazes played by the user
     */
    public List<Integer> getMazesPlayed() {
        return Objects.requireNonNullElse(this.mazesPlayed, Collections.<Integer>emptyList());
    }
}