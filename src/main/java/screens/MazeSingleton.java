package screens;

import entities.GameState;

/**
 * The type Maze singleton of the maze being played.
 */
public class MazeSingleton {

    private static MazeSingleton instance;
    private GameState maze;

    private MazeSingleton() {
    }

    /**
     * Gets instance of MazeSingleton or creates one if there is no instance.
     *
     * @return the instance of MazeSingleton
     */
    public static MazeSingleton getInstance() {
        if (instance == null) {
            instance = new MazeSingleton();
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

    /**
     * Sets the maze to be the maze within the parameter.
     *
     * @param maze the maze to be set
     */
    public void setMaze(GameState maze) {
        this.maze = maze;
    }

}
