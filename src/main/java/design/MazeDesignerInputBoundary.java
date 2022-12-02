package design;

import entities.DesignableMaze;

public interface MazeDesignerInputBoundary {
    /**
     * Creates a new DesignableMaze with dimensions 11 x 17
     */
    public void newMaze();

    /**
     * Resets the current maze; having all outer cells as walls and all else be empty
     */
    public void resetMaze();

    /**
     * Builds a wall at the given cell row and column
     * @param row the row at which the wall is to be built
     * @param col the column at which the wall is to be built
     */
    public void buildWall(int row, int col);

    /**
     * Removes a wall at the given cell row and column
     * @param row the row at which the wall is to be removed
     * @param col the column at which the wall is to be removed
     */
    public void removeWall(int row, int col);

    /**
     * Builds a start point at the given cell row and column
     * @param row the row at which the start point is to be built
     * @param col the column at which the start point is to be built
     */
    public void startPoint(int row, int col);

    /**
     * Builds an end point at the given cell row and column
     * @param row the row at which the end point is to be built
     * @param col the column at which the end point is to be built
     */
    public void endPoint(int row, int col);

    /**
     * Creates a Random Maze
     */
    public void randomMaze();

    /**
     * Updates the Maze
     * @return returns a String[][] that represents the current maze state for the UI to manipulate visuals
     */
    public String[][] updateMaze();

    DesignableMaze getDm();
}
