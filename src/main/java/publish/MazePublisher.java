package publish;

import entities.DesignableMaze;
import entities.PublishedMaze;

import java.util.Date;

public class MazePublisher {

    private MazePublishedRequestModel mazeInfo;

    public MazePublisher (MazePublishedRequestModel mazeInfo) {
        this.mazeInfo = mazeInfo;
    }

    public boolean checkSolvable() {
        MazeSolvabilityControl solveCheck = new MazeSolvabilityControl(this.mazeInfo.getDm());
        return solveCheck.checkMazeSolvability(this.mazeInfo.getDm());
    }

    public PublishedMaze publishMaze() {
        if (checkSolvable()) {
            char[][] state = new char[this.mazeInfo.getDm().getNumRow()][this.mazeInfo.getDm().getNumCol()];
            for (int i = 0; i < this.mazeInfo.getDm().getNumRow(); i++) {
                for (int j = 0; j < this.mazeInfo.getDm().getNumCol(); j++) {
                    state[i][j] = this.mazeInfo.getDm().getCell(i, j);
                }
            }
            return new PublishedMaze(this.mazeInfo.getAuthor(),
                                                 this.mazeInfo.getName(),
                                                 true,
                                                 new Date(),
                                                 state);
        }
        else {
            return null;
        }
    }
}
