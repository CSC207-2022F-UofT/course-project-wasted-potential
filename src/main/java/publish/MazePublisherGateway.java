package publish;

import entities.PublishedMaze;

/**
 * The interface Maze publisher gateway.
 */
public interface MazePublisherGateway {
    /**
     * Store maze.
     *
     * @param maze the maze
     */
    public void storeMaze(PublishedMaze maze);
}
