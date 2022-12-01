package entities;

import java.util.Date;

/**
 * The type Published maze.
 */
public class PublishedMaze extends Maze{
    private String author;
    private String name;
    private Boolean published;
    private Date publishDate;
    private String id;
    private int[] startPosition;

    /**
     * Instantiates a new Published maze.
     */
    public PublishedMaze() {
    }

    /**
     * Instantiates a new Published maze.
     *
     * @param author        the author
     * @param name          the name
     * @param published     the published
     * @param date          the date
     * @param state         the state
     * @param startPosition the start position
     */
    public PublishedMaze(String author,
                         String name,
                         Boolean published,
                         Date date,
                         char[][] state,
                         int[] startPosition,
                         int numRow,
                         int numCol) {
        super(numRow, numCol, state);
        this.author = author;
        this.name = name;
        this.published = published;
        this.publishDate = date;
        this.id = this.publishDate.toString() + this.author;
        this.startPosition = startPosition;
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
     * Gets published.
     *
     * @return the published
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * Gets publish date.
     *
     * @return the publish date
     */
    public Date getPublishDate() {
        return publishDate;
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
     * Get start position int [ ].
     *
     * @return the int [ ]
     */
    public int[] getStartPosition() {
        return startPosition;
    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder();
        for (int i = 0; i < this.getNumRow(); i++)  {
            StringBuilder curRow = new StringBuilder();
            for (int j = 0; j < this.getNumCol(); j++) {
                curRow.append(state[i][j]);
            }
            returnString.append(curRow);
        }
        return returnString.toString();
    }
}