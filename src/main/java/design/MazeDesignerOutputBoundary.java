package design;

public interface MazeDesignerOutputBoundary {
    /**
     * Algorithm to return UI representation
     * @param buttonarray the String[][] to be manipulated
     * @return the String[][] that is the representation of the maze
     */
    public String[][] updateMazeUI(String[][] buttonarray);

}
