package design;

public interface MazeDesignerOutputBoundary {
    /**
     * Algorithm to return UI representation
     * @param mazeState the char[][] to be manipulated
     * @return the char[][] that is the representation of the maze
     */
    public char[][] presentMazeState(char[][] mazeState);

}
