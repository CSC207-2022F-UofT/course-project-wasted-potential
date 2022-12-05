package retrieval;

import java.util.List;


/**
 * The output data for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */
public class MazeRetrieverResponseModel {

    private final List<Integer> played;
    private final List<Integer> notPlayed;

    /**
     * The constructor for the MazeRetrieverResponseModel class.
     *
     * @param played a list of every maze the user has played
     * @param notPlayed a list of every maze the user has not played
     */
    public MazeRetrieverResponseModel(List<Integer> played, List<Integer> notPlayed) {
        this.played = played;
        this.notPlayed = notPlayed;
    }

    /**
     * A getter method which returns the played attribute.
     *
     * @return a list of every maze the user has played
     */
    public List<Integer> getPlayed() {
        return this.played;
    }

    /**
     * A getter method which returns the notPlayed attribute.
     *
     * @return a list of every maze the user has not played
     */
    public List<Integer> getNotPlayed() {
        return this.notPlayed;
    }
}
