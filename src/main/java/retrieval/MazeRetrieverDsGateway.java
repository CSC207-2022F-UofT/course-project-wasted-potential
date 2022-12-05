package retrieval;

import java.util.ArrayList;

/**
 * The data access interface for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */

public interface MazeRetrieverDsGateway {

    /**
     * Returns a list of the mazes that a user has played.
     *
     * @param username the user who's logged in
     * @return a list of every maze the user has played
     */
    ArrayList<Integer> retrievePlayed(String username);

    /**
     * Returns a list of the mazes that a user has not played.
     *
     * @param username the user who's logged in
     * @return a list of every maze the user has not played
     */
    ArrayList<Integer> retrieveNotPlayed(String username);
}
