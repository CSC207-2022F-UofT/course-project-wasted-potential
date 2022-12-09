package retrieval;

import display.MazeDsGateway;
import entities.PublishedMaze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The facade for the Maze Retriever use case.
 */
public class MazeRetrieverFacade {

    private final MazeRetrieverDsGateway mazeRetrieverDsGateway;
    private final MazeDsGateway mazeDsGateway;

    /**
     * Instantiates a new Maze retriever facade.
     *
     * @param mazeRetrieverDsGateway the maze retriever ds gateway to the user database
     * @param mazeDsGateway          the maze ds gateway to the maze database
     */
    public MazeRetrieverFacade(MazeRetrieverDsGateway mazeRetrieverDsGateway, MazeDsGateway mazeDsGateway) {
        this.mazeRetrieverDsGateway = mazeRetrieverDsGateway;
        this.mazeDsGateway = mazeDsGateway;
    }

    /**
     * Retrieve two lists of played mazes: one of mazes played and one of mazes not yet plated.
     *
     * @param username the username
     * @return the list
     */
    public List<PublishedMaze> retrieveMazesPlayed(String username) {
        List<PublishedMaze> played = new ArrayList<>();
        List<Integer> mazeIdList = mazeRetrieverDsGateway.retrievePlayed(username);
        MazeIDRepository mazeIDRepository = new MazeIDRepository(mazeIdList);
        MazeRetrieverIterator iter = mazeIDRepository.getIterator();
        if (!iter.hasNext()) {
            return Collections.emptyList();
        }
        for (iter = mazeIDRepository.getIterator(); iter.hasNext();) {
            Integer mazeId = (Integer)iter.next();
            played.add(mazeDsGateway.retrieveMaze(mazeId));
        }
        return played;

    }

    /**
     * Retrieve mazes not played list.
     *
     * @param username the username
     * @return the list
     */
    public List<PublishedMaze> retrieveMazesNotPlayed(String username) {
        List<PublishedMaze> notPlayed = new ArrayList<>();
        List<Integer> mazeIdList = mazeRetrieverDsGateway.retrieveNotPlayed(username);
        MazeIDRepository mazeIDRepository = new MazeIDRepository(mazeIdList);
        for (MazeRetrieverIterator iter = mazeIDRepository.getIterator(); iter.hasNext();) {
            Integer mazeId = (Integer)iter.next();
            notPlayed.add(mazeDsGateway.retrieveMaze(mazeId));
        }
        return notPlayed;

    }

}
