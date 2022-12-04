package entities;

import java.time.LocalDate;

/**
 * The type Game state.
 */
public class GameState extends PublishedMaze {

    private final int[] position;

    /**
     * Instantiates a new Game state.
     *
     * @param author        the author of the maze
     * @param name          the name of the maze
     * @param published     a boolean signalling that the maze has been published
     * @param date          the date the maze was published
     * @param state         the layout of the maze
     * @param startPosition the start position of the maze
     * @param numRow        the number of columns
     * @param numCol        the number of rows
     * @param id            the unique identifier for the maze
     * @param position      the position of the icon navigating the maze
     */
    public GameState(String author,
                     String name,
                     Boolean published,
                     LocalDate date,
                     char[][] state,
                     int[] startPosition,
                     int numRow,
                     int numCol,
                     int id, int[] position) {
        super(author, name, published, date,
        state, startPosition, numRow, numCol, id);
        this.position = startPosition;
    }

    /**
     * Get position int [ ].
     *
     * @return the int [ ]
     */
    public int[] getPosition() {
        return this.position;
    }

    /**
     * Update position.
     *
     * @param x the x
     * @param y the y
     */
    public void updatePosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }
}