package entities;

import java.time.LocalDate;

public class SavedMaze extends Maze{
    private String author;
    private String name;
    private Boolean published;
    private LocalDate publishDate;
    private int[] startPosition;

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
