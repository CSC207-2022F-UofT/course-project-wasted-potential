package retrieval;

import display.MazeDsGateway;
import entities.PublishedMaze;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MazeRetrieverFacade {

    private final MazeRetrieverDsGateway mazeRetrieverDsGateway;
    private final MazeDsGateway mazeDsGateway;

    public MazeRetrieverFacade(MazeRetrieverDsGateway mazeRetrieverDsGateway, MazeDsGateway mazeDsGateway) {
        this.mazeRetrieverDsGateway = mazeRetrieverDsGateway;
        this.mazeDsGateway = mazeDsGateway;
    }

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
