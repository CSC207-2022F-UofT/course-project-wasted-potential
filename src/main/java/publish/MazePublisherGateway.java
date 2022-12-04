package publish;

import entities.SavedMaze;

/**
 * The interface Maze publisher gateway.
 */
public interface MazePublisherGateway {
    /**
     * Store maze.
     *
     * @param maze the maze
     */
    public void storeMaze(SavedMaze maze);
}
