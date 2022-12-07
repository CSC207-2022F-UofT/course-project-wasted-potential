package screens;

import entities.PublishedMaze;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * The type Published maze singleton. Stores a list of all published mazes.
 */
public class PublishedMazeSingleton { // Need to create a static int object

    private static PublishedMazeSingleton instance;
    private final Map<Integer, PublishedMaze> publishedMazes;

    private static int id = 0;

    /**
     * Instantiates a new Published maze singleton.
     */
    public PublishedMazeSingleton() {
        this.publishedMazes = new HashMap<>();
    }

    /**
     * Gets an instance of PublishedMazeSingleton or creates one if there is no instance.
     *
     * @return the instance of PublishedMazeSingleton
     */
    public static PublishedMazeSingleton getInstance() {
        if (instance == null) {
            instance = new PublishedMazeSingleton();
        }
        return instance;
    }

    /**
     * Gets published maze with the given maze id.
     *
     * @param mazeId the maze id of the requested maze
     * @return the published maze with the given maze id
     */
    public PublishedMaze getPublishedMaze(int mazeId) throws NoSuchElementException {
        if (this.publishedMazes.containsKey(mazeId)) {
            return publishedMazes.get(mazeId);
        }
        else {
            throw new NoSuchElementException("Invalid maze ID");
        }
    }

    /**
     * Gets published mazes.
     *
     * @return the published mazes
     */
    public Map<Integer, PublishedMaze> getPublishedMazes() {
        return publishedMazes;
    }

    /**
     * Update id.
     *
     * @param id the id
     */
    public static void updateId(int id) {
        PublishedMazeSingleton.id = id + 1;
    }

    /**
     * Add maze.
     *
     * @param id   the id
     * @param info the info
     */
    public void addMaze(int id, MazeInformation info) {
        publishedMazes.put(id, new PublishedMaze(info.getAuthor(), info.getName(), true, info.getCreationTime(),
                info.getState(), info.getStartPosition(), 25, 25, id));
        updateId(id);
    }

    /**
     * Add maze.
     *
     * @param info the info
     */
    public void addMaze(MazeInformation info) {
        publishedMazes.put(id, new PublishedMaze(info.getAuthor(), info.getName(), true, info.getCreationTime(),
                info.getState(), info.getStartPosition(), 25, 25, id));
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
