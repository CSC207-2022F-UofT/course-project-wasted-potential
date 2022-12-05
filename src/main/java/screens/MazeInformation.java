package screens;


import java.time.LocalDate;

/**
 * An object containing Maze information.
 */
public class MazeInformation {
    /**
     * The name of the maze.
     */
    String name;
    /**
     * The author.
     */
    String author;
    /**
     * The creation time for the maze.
     */
    LocalDate creationTime;
    /**
     * The state of the maze.
     */
    char[][] state;
    /**
     * The start position of the maze.
     */
    int[] startPosition;

    /**
     * Instantiates a new MazeInformation object.
     *
     * @param name          the name of the maze
     * @param author        the author
     * @param creationTime  the creation time
     * @param state         the state
     * @param startPosition the start position
     */
    public MazeInformation(String name, String author, LocalDate creationTime, char[][] state, int[] startPosition) {
        this.name = name;
        this.author = author;
        this.creationTime = creationTime;
        this.state = state;
        this.startPosition = startPosition;
    }

    /**
     * Gets the maze's name.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
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
     * Gets the creation time.
     *
     * @return the creation time
     */
    public LocalDate getCreationTime() {
        return this.creationTime;
    }

    /**
     * Gets the state in a character array.
     *
     * @return a character array
     */
    public char[][] getState() {
        return this.state;
    }

    /**
     * Gets the start position of the maze in an integer array.
     *
     * @return an integer array
     */
    public int[] getStartPosition() {
        return this.startPosition;
    }
}
