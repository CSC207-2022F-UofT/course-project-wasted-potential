package entities;

import java.time.LocalDate;

/**
 * The type Published maze.
 */
public class PublishedMaze extends Maze{
    protected String author;
    protected String name;
    protected Boolean published;
    protected LocalDate publishDate;
    protected int id;
    protected int[] startPosition;

    /**
     * Instantiates a new Published maze.
     *
     * @param author        the author of the maze
     * @param name          the name of the maze
     * @param published     a boolean value representing whether the maze has been published
     * @param date          the date the maze was published
     * @param state         the layout of the maze
     * @param startPosition the start position of the maze
     */
    // This constructor needs many parameters because it is a class that needs a significant amount of information.
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
     * Instantiates a new Published maze. This is a default constructor.
     */

    /**
     * Gets the author of the maze
     *
     * @return the author of the maze
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the name of the maze.
     *
     * @return the name of the maze
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the boolean value published.
     *
     * @return the boolean value published
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
     * Gets the unique identifier for the maze.
     *
     * @return the unique identifier for the maze
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the start position of the maze.
     *
     * @return an integer array representing the co-ordinates of the start position
     */
    public int[] getStartPosition() {
        return startPosition;
    }

    /**
     * A string representation of the published maze.
     * This string representation is slightly different to the Maze toString() method.
     * This is because published mazes must be stored in a csv file.
     * Therefore, toString() returns a representation which makes this easier.
     *
     * @return
     */
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