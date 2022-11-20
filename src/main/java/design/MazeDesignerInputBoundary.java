package design;

public interface MazeDesignerInputBoundary {
    void newMaze();

    void resetMaze();

    void buildWall(int row, int col);

    void removeWall(int row, int col);

    void startPoint(int row, int col);

    void endPoint(int row, int col);

    void randomMaze();

}
