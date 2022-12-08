package publish;

import entities.MazeSolver;
import entities.SavedMaze;

import java.time.LocalDate;

/**
 * The use case class for publishing mazes.
 */
public class MazePublisher {

    private final PublishMazeRequestModel mazeInfo;

    /**
     * Instantiates a new Maze publisher.
     *
     * @param mazeInfo the maze information in the form of a PublishMazeRequestModel.
     */
    public MazePublisher (PublishMazeRequestModel mazeInfo) {
        this.mazeInfo = mazeInfo;
    }

    /**
     * Check whether the maze is solvable.
     *
     * @return the boolean of whether the maze is solvable or not.
     */
    public boolean checkSolvable() {
        return MazeSolver.checkMazeSolvability(this.mazeInfo.getDesignableMaze());
    }

    /**
     * Return a SavedMaze containing the maze that is to be published.
     *
     * @return the SavedMaze that is about to be published.
     */
    public SavedMaze publishMaze() {
        if (checkSolvable()) {
            int[] startPosition = new int[2];
            for (int i = 0; i < this.mazeInfo.getDesignableMaze().getNumRow(); i++) {
                for (int j = 0; j < this.mazeInfo.getDesignableMaze().getNumCol(); j++) {
                    if (this.mazeInfo.getDesignableMaze().getState()[i][j] == 'S') {
                        startPosition[0] = i;
                        startPosition[1] = j;
                    }
                }
            }
            return new SavedMaze(this.mazeInfo.getAuthor(),
                    this.mazeInfo.getName(),
                    true,
                    LocalDate.now(),
                    this.mazeInfo.getDesignableMaze().getState(),
                    startPosition,
                    this.mazeInfo.getDesignableMaze().getNumRow(),
                    this.mazeInfo.getDesignableMaze().getNumCol());
        }
        else {
            return null;
        }
    }
}
