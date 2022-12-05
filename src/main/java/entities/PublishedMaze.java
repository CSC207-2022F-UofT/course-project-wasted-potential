package entities;

import java.time.LocalDate;

/**
 * The type Published maze.
 */
public class PublishedMaze extends Maze{
    private String author;
    private String name;
    private Boolean published;
    private LocalDate publishDate;
    private int id;
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
                         LocalDate date,
                         char[][] state,
                         int[] startPosition,
                         int numRow,
                         int numCol,
                         int id) {
        super(numRow, numCol, state);
        this.author = author;
        this.name = name;
        this.published = published;
        this.publishDate = date;
        this.id = id;
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
    public LocalDate getPublishDate() {
        return publishDate;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
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
            returnString.append(curRow + ":");
        }
        return returnString.toString();
    }
}