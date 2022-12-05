package display;

/**
 * The data access interface for accessing the database containing player information.
 *
 * @author Oscar Tuvey
 */
public interface PlayerDsGateway {

    /**
     * A method for adding a maze to a player's list of played mazes.
     *
     * @param mazeID the maze which has been played
     * @param username the username of the user who has played it
     */
    void addToPlayed(int mazeID, String username);
}
