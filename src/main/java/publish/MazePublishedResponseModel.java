package publish;

import java.util.Date;

/**
 * The type Maze published response model.
 */
public class MazePublishedResponseModel {
    private String id;
    private String name;
    private Date publishDate;


    /**
     * Instantiates a new Maze published response model.
     *
     * @param id          the id
     * @param name        the name
     * @param publishDate the publish date
     */
    public MazePublishedResponseModel(String id, String name, Date publishDate) {
        this.id = id;
        this.name = name;
        this.publishDate = publishDate;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
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
    public Date getPublishDate() {
        return publishDate;
    }
}
