package screens;

import entities.PublishedMaze;

import java.util.HashMap;
import java.util.Map;

/**
 * The Singleton containing published mazes and their IDs.
 */
public class PublishedMazeSingleton { // Need to create a static int object

    private static PublishedMazeSingleton instance;
    private final Map<Integer, PublishedMaze> publishedMazes;

    private static int id = 0;

    /**
     * Instantiates a new PublishedMazeSingleton.
     */
    public PublishedMazeSingleton() {
        this.publishedMazes = new HashMap<>();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static PublishedMazeSingleton getInstance() {
        if (instance == null) {
            instance = new PublishedMazeSingleton();
        }
        return instance;
    }

    /**
     * Gets the published maze at the given ID.
     *
     * @param mazeId the maze id
     * @return the published maze at the given ID
     */
    public PublishedMaze getPublishedMaze(int mazeId) {
        if (this.publishedMazes.containsKey(mazeId)) {
            return publishedMazes.get(mazeId);
        }

        else {
            return null;
        } // Redo this
    }

    /**
     * Gets all the published mazes.
     *
     * @return the published mazes
     */
    public Map<Integer, PublishedMaze> getPublishedMazes() {
        return publishedMazes;
    }

    /**
     * Update id.
     *
     * @param id the id to update to
     */
    public static void updateId(int id) {
        PublishedMazeSingleton.id = id + 1;
    }

    /**
     * Add maze to the map.
     *
     * @param id   the id of the maze
     * @param info the maze information
     */
    public void addMaze(int id, MazeInformation info) {
        publishedMazes.put(id, new PublishedMaze(info.getAuthor(), info.getName(), true, info.getCreationTime(),
                info.getState(), info.getStartPosition(), 11, 17, id));
        updateId(id);
    }

    /**
     * Add maze to the map.
     *
     * @param info the maze information
     */
    public void addMaze(MazeInformation info) {
        publishedMazes.put(id, new PublishedMaze(info.getAuthor(), info.getName(), true, info.getCreationTime(),
                info.getState(), info.getStartPosition(), 11, 17, id));
        updateId(id);
    }

    /**
     * Gets the current id. Only used in testing.
     *
     * @return the id
     */
    public static int getId() {
        return id;
    }
}
