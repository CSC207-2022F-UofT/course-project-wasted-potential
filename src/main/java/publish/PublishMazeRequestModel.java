package publish;

import entities.DesignableMaze;

/**
 * The request model class for the use case of publishing mazes.
 */
public class PublishMazeRequestModel {
    private final String author;
    private final String name;

    private final DesignableMaze designableMaze;

    /**
     * Instantiates a new PublishedMazeRequestModel.
     *
     * @param author the author
     * @param name   the name of the maze
     * @param designableMaze     the DesignableMaze being published.
     */
    public PublishMazeRequestModel(String author, String name, DesignableMaze designableMaze) {
        this.author = author;
        this.name = name;
        this.designableMaze = designableMaze;
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
    public DesignableMaze getDesignableMaze() {
        return designableMaze;
    }
}
