package design;

import entities.DesignableMaze;

public abstract class MazeGenerator {

//    int numRows;
//    int numCols;
    DesignableMaze maze;
    public abstract void generate(DesignableMaze maze);

}
