package publish;

import entities.DesignableMaze;

/**
 * The type Maze published request model.
 */
public class MazePublishedRequestModel {
    private String author;
    private String name;

    private DesignableMaze dm;

    /**
     * Instantiates a new Maze published request model.
     *
     * @param author the author
     * @param name   the name
     * @param dm     the dm
     */
    public MazePublishedRequestModel(String author, String name, DesignableMaze dm) {
        this.author = author;
        this.name = name;
        this.dm = dm;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets dm.
     *
     * @return the dm
     */
    public DesignableMaze getDm() {
        return dm;
    }
}
