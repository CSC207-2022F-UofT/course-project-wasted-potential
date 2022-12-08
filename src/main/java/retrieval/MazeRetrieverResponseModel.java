package retrieval;

import entities.PublishedMaze;

import java.util.List;


/**
 * The output data for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */
public class MazeRetrieverResponseModel {

    private final List<PublishedMaze> played;
    private final List<PublishedMaze> notPlayed;

    /**
     * The constructor for the MazeRetrieverResponseModel class.
     *
     * @param played a list of every maze the user has played
     * @param notPlayed a list of every maze the user has not played
     */
    public MazeRetrieverResponseModel(List<PublishedMaze> played, List<PublishedMaze> notPlayed) {
        this.played = played;
        this.notPlayed = notPlayed;
    }

    /**
     * A getter method which returns the played attribute.
     *
     * @return a list of every maze the user has played
     */
    public List<PublishedMaze> getPlayed() {
        return this.played;
    }

    /**
     * A getter method which returns the notPlayed attribute.
     *
     * @return a list of every maze the user has not played
     */
    public List<PublishedMaze> getNotPlayed() {
        return this.notPlayed;
    }
}
