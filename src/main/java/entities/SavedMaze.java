package entities;

import java.time.LocalDate;

/**
 * The type Saved maze.
 */
public class SavedMaze extends Maze{
    private String author;
    private String name;
    private Boolean published;
    private LocalDate publishDate;
    private int[] startPosition;

    /**
     * Instantiates a new Saved maze.
     *
     * @param author        the author of the maze
     * @param name          the name of the maze
     * @param published     a boolean value representing whether the maze has been published
     * @param date          the date the maze was saved
     * @param state         the layout of the maze
     * @param startPosition the start position of the maze
     * @param numRow        the number of rows
     * @param numCol        the number of columns
     */
    public SavedMaze(String author,
                     String name,
                     Boolean published,
                     LocalDate date,
                     char[][] state,
                     int[] startPosition,
                     int numRow,
                     int numCol) {
        super(numRow, numCol, state);
        this.author = author;
        this.name = name;
        this.published = published;
        this.publishDate = date;
        this.startPosition = startPosition;
    }

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
     * Gets the boolean value representing whether the maze is published.
     *
     * @return the published value
     */
    public Boolean getPublished() {
        return published;
    }

    /**
     * Gets the date the maze was saved.
     *
     * @return the save date
     */
    public LocalDate getPublishDate() {
        return publishDate;
    }

    /**
     * Gets the start position of the maze.
     *
     * @return an integer array representing the start position
     */
    public int[] getStartPosition() {
        return startPosition;
    }

    /**
     * A string representation of the published maze.
     * This string representation is slightly different to the Maze toString() method.
     * This is because saved mazes must be stored in a csv file.
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
}
