package design;

import entities.DesignableMaze;

public abstract class MazeGenerator {

//    int numRows;
//    int numCols;
    DesignableMaze maze;

    public MazeGenerator(DesignableMaze maze) {
        this.maze = maze;
    }

    public abstract void generate();
}
