package publish;

import entities.DesignableMaze;

/**
 * The interface for the publish maze input boundary.
 */
public interface PublishMazeInBoundary {
    /**
     * Publish the maze to the database.
     *
     * @param author the author
     * @param name   the maze name
     * @param designableMaze     the DesignableMaze being published
     * @return the PublishMazeResponseModel.
     */
    PublishMazeResponseModel publishMaze(String author, String name, DesignableMaze designableMaze);
}
