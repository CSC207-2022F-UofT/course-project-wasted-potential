package publish;

import java.time.LocalDate;

/**
 * The response model class for the use case of publishing mazes.
 */
public class PublishMazeResponseModel {
    private String name;
    private LocalDate publishDate;


    /**
     * Instantiates a new PublishedMazeResponseModel.
     *
     * @param name        the name of the maze.
     * @param publishDate the publish date
     */
    public PublishMazeResponseModel(String name, LocalDate publishDate) {
        this.name = name;
        this.publishDate = publishDate;
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
     * Gets the publish date.
     *
     * @return the publish date
     */
    public LocalDate getPublishDate() {
        return publishDate;
    }
}
