package entities;

import java.time.LocalDate;

public class GameState extends PublishedMaze {

    private int[] position;

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

    public int[] getPosition() {
        return this.position;
    }

    public void updatePosition(int x, int y) {
        this.position[0] = x;
        this.position[1] = y;
    }
}