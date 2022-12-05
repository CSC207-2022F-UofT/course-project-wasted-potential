package publish;

import entities.DesignableMaze;

/**
 * The interface Maze published in boundary.
 */
public interface MazePublishedInBoundary {
    /**
     * Publish maze.
     *
     * @param author the author
     * @param name   the name
     * @param dm     the dm
     */
    public MazePublishedResponseModel publishMaze(String author, String name, DesignableMaze dm);
}
