package design;

import entities.DesignableMaze;

public abstract class MazeGenerator {

    DesignableMaze maze;

    protected MazeGenerator(DesignableMaze maze) {
        this.maze = maze;
    }

    public abstract void generate();
}
