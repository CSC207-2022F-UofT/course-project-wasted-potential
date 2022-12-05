package entities;

import java.time.LocalDate;

/**
 * The type Published maze.  This is the type of maze that will be in the database.
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
     * @param name          the name of the maze
     * @param published     whether or not the maze has been published
     * @param date          the date the maze was published
     * @param state         the state of the maze
     * @param startPosition the start position
     * @param numRow        the number of rows in the maze
     * @param numCol        the numof columns in the maze
     * @param id            the id of the maze
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
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the name of the maze.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets whether or not the maze has been published.
     *
     * @return the published
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * Gets the publish date.
     *
     * @return the publish date
     */
    public LocalDate getPublishDate() {
        return publishDate;
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Get the start position in an integer array.
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

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PublishedMaze)) {
            return false;
        }
        PublishedMaze pm = (PublishedMaze) obj;
        return pm.getState() == ((PublishedMaze) obj).getState() && pm.getId() == ((PublishedMaze) obj).getId();
    }
}