package entities;

import java.util.List;

/**
 * The type User factory.
 */
public class UserFactory {
    /**
     * Create a new player instance.
     *
     * @param name         the name of the player
     * @param password     the password of the player
     * @param creationTime the creation time of the account
     * @return a player instance
     */
    public Player createPlayer(String name, String password, String creationTime, List<Integer> mazesPlayed) {
        return new Player(name, password, creationTime, mazesPlayed);
    }

    /**
     * Create designer designer.
     *
     * @param name         the name of the designer
     * @param password     the password of the designer
     * @param creationTime the creation time of the account
     * @return a designer instance
     */
    public Designer createDesigner(String name, String password, String creationTime) {
        return new Designer(name, password, creationTime);
    }
}