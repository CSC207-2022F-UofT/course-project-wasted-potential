package publish;

import entities.SavedMaze;

/**
 * The interface of the gateway for the use case of publishing mazes.
 */
public interface PublishMazeGateway {
    /**
     * Store the maze in the database.
     *
     * @param maze a SavedMaze representing the maze that is to be published.
     */
    void storeMaze(SavedMaze maze);
}
