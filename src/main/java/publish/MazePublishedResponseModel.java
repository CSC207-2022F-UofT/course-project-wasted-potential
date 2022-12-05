package publish;

import java.time.LocalDate;

/**
 * The type Maze published response model.
 */
public class MazePublishedResponseModel {
    private String name;
    private LocalDate publishDate;


    /**
     * Instantiates a new Maze published response model.
     *
     * @param name        the name
     * @param publishDate the publish date
     */
    public MazePublishedResponseModel(String name, LocalDate publishDate) {
        this.name = name;
        this.publishDate = publishDate;
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
     * Gets publish date.
     *
     * @return the publish date
     */
    public LocalDate getPublishDate() {
        return publishDate;
    }
}
