package display;

import entities.PublishedMaze;

/**
 * The data access interface for retrieving a maze from the database.
 *
 * @author Oscar Tuvey
 */
public interface MazeDsGateway {

    /**
     * A method for retrieving a maze from the database.
     *
     * @param mazeId the unique identifier for the maze to be retrieved
     * @return the maze with the given mazeId
     */
    public PublishedMaze retrieveMaze(int mazeId);

}
