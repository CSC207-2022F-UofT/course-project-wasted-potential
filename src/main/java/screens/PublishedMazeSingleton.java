package screens;

import entities.PublishedMaze;

import java.util.HashMap;
import java.util.Map;

public class PublishedMazeSingleton { // Need to create a static int object

    private static PublishedMazeSingleton instance;
    private final Map<Integer, PublishedMaze> publishedMazes;

    private static int id = 0;

    public PublishedMazeSingleton() {
        this.publishedMazes = new HashMap<>();
    }

    public static PublishedMazeSingleton getInstance() {
        if (instance == null) {
            instance = new PublishedMazeSingleton();
        }
        return instance;
    }

    public PublishedMaze getPublishedMaze(int mazeId) {
        if (this.publishedMazes.containsKey(mazeId)) {
            return publishedMazes.get(mazeId);
        }

        else {
            return null;
        } // Redo this
    }
    public Map<Integer, PublishedMaze> getPublishedMazes() {
        return publishedMazes;
    }
    public static void updateId(int id) {
        PublishedMazeSingleton.id = id + 1;
    }

    public void addMaze(int id, MazeInformation info) {
        publishedMazes.put(id, new PublishedMaze(info.getAuthor(), info.getName(), true, info.getCreationTime(),
                info.getState(), info.getStartPosition(), 11, 17, id));
        updateId(id);
    }

    public void addMaze(MazeInformation info) {
        publishedMazes.put(id, new PublishedMaze(info.getAuthor(), info.getName(), true, info.getCreationTime(),
                info.getState(), info.getStartPosition(), 11, 17, id));
        updateId(id);
    }

}
