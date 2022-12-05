package screens;

import entities.GameState;

public class MazeSingleton {

    private static MazeSingleton instance;
    private GameState maze; // Should this be final?

    private MazeSingleton(GameState maze) {
        this.maze = maze;
    }

    public static MazeSingleton getInstance(GameState maze) {
        if (instance == null) {
            instance = new MazeSingleton(maze);
        }
        return instance;
    }

    public GameState getMaze() {
        return this.maze;
    }

}
