package screens;

import entities.GameState;

/**
 * The type Maze singleton of the maze being played.
 */
public class MazeSingleton {

    private static MazeSingleton instance;
    private GameState maze;

    private MazeSingleton(GameState maze) {
        this.maze = maze;
    }

    /**
     * Gets instance of MazeSingleton or creates one if there is no instance.
     *
     * @param maze the maze to be instantiated
     * @return the instance of MazeSingleton
     */
    public static MazeSingleton getInstance(GameState maze) {
        if (instance == null) {
            instance = new MazeSingleton(maze);
        }
        return instance;
    }

    /**
     * Gets the maze within the MazeSingleton object.
     *
     * @return the maze within the MazeSingleton
     */
    public GameState getMaze() {
        return this.maze;
    }

}
