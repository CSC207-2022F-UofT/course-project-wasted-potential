package publish;

import entities.MazeSolver;
import entities.SavedMaze;

import java.time.LocalDate;

/**
 * The type Maze publisher.
 */
public class MazePublisher {

    private MazePublishedRequestModel mazeInfo;

    /**
     * Instantiates a new Maze publisher.
     *
     * @param mazeInfo the maze info
     */
    public MazePublisher (MazePublishedRequestModel mazeInfo) {
        this.mazeInfo = mazeInfo;
    }

    /**
     * Check solvable boolean.
     *
     * @return the boolean
     */

    public boolean checkSolvable() {
        return MazeSolver.checkMazeSolvability(this.mazeInfo.getDm());
    }

    /**
     * Publish maze published maze.
     *
     * @return the published maze
     */
    public SavedMaze publishMaze() {
        if (checkSolvable()) {
            int[] startPosition = new int[2];
            for (int i = 0; i < this.mazeInfo.getDm().getNumRow(); i++) {
                for (int j = 0; j < this.mazeInfo.getDm().getNumCol(); j++) {
                    if (this.mazeInfo.getDm().getState()[i][j] == 'S') {
                        startPosition[0] = i;
                        startPosition[1] = j;
                    }
                }
            }
            return new SavedMaze(this.mazeInfo.getAuthor(),
                    this.mazeInfo.getName(),
                    true,
                    LocalDate.now(),
                    this.mazeInfo.getDm().getState(),
                    startPosition,
                    this.mazeInfo.getDm().getNumRow(),
                    this.mazeInfo.getDm().getNumCol());
        }
        else {
            return null;
        }
    }
}
