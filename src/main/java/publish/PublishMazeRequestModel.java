package publish;

import entities.DesignableMaze;

/**
 * The request model class for the use case of publishing mazes.
 */
public class PublishMazeRequestModel {
    private String author;
    private String name;

    private DesignableMaze dm;

    /**
     * Instantiates a new PublishedMazeRequestModel.
     *
     * @param author the author
     * @param name   the name of the maze
     * @param dm     the DesignableMaze being published.
     */
    public PublishMazeRequestModel(String author, String name, DesignableMaze dm) {
        this.author = author;
        this.name = name;
        this.dm = dm;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the maze's name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the DesignableMaze.
     *
     * @return the DesignableMaze
     */
    public DesignableMaze getDm() {
        return dm;
    }
}
