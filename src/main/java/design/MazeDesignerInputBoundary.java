package design;

import entities.DesignableMaze;

public interface MazeDesignerInputBoundary {
    /**
     * Resets the current maze; having all outer cells as walls and all else be empty
     */
    void resetMaze();

    /**
     * Builds a wall at the given cell row and column
     * @param row the row at which the wall is to be built
     * @param col the column at which the wall is to be built
     */
    void buildWall(int row, int col);

    /**
     * Removes a wall at the given cell row and column
     * @param row the row at which the wall is to be removed
     * @param col the column at which the wall is to be removed
     */
    void removeWall(int row, int col);

    /**
     * Builds a start point at the given cell row and column
     * @param row the row at which the start point is to be built
     * @param col the column at which the start point is to be built
     */
    void startPoint(int row, int col);

    /**
     * Builds an end point at the given cell row and column
     * @param row the row at which the end point is to be built
     * @param col the column at which the end point is to be built
     */
    void endPoint(int row, int col);

    /**
     * Creates a Random Maze
     */
    void randomMaze();

    /**
     * Updates the Maze
     * @return returns a char[][] that represents the current maze state for the UI to manipulate visuals
     */
    char[][] getMazeState();

    /**
     * Gets the Maze.
     *
     * @return returns the DesignableMaze object
     */
    DesignableMaze getDesignableMaze();
}
