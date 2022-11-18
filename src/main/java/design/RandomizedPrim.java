package design;

import entities.DesignableMaze;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomizedPrim extends MazeGenerator {

    private static final int[][] DELTA = {
        {2, 0}, {-2, 0}, {0,-2}, {0, 2}
    };

    List<MazeCell> visitedCells = new ArrayList<MazeCell>();
    List<MazeCell> frontierCells = new ArrayList<MazeCell>();
    List<MazeCell> emptyCells = new ArrayList<MazeCell>();

    public RandomizedPrim(DesignableMaze maze) {
        super(maze);
    }

    @Override
    public void generate() {
        fillMaze();

        // start with first empty cell
        addCell(new MazeCell(1, 1));

        // randomly connect the frontiers until there are no frontiers left
        while (!frontierCells.isEmpty()) {
            MazeCell frontier = getRandom(frontierCells);
            frontierCells.remove(frontier);
            addCell(frontier);

            randomlyConnectFrontier(frontier);
        }

        // delete the walls which should be empty
        for (MazeCell e : emptyCells)  {
            maze.deleteWall(e.row, e.col);
        }
    }
    private void fillMaze() {
        for (int i = 0; i < maze.getNumRow(); i++) {
            for (int j = 0; j < maze.getNumCol(); j++) {
                maze.placeWall(i, j);
            }
        }
    }

    private void addCell(MazeCell v) {
        visitedCells.add(v);
        emptyCells.add(v);

        List<MazeCell> neighbors = getNeighbors(v);

        // update frontier cells
        for (MazeCell cell : neighbors) {

            if (visitedCells.contains(cell) || frontierCells.contains(cell)) {
                continue;
            }

            frontierCells.add(cell);
        }
    }

    private List<MazeCell> getNeighbors(MazeCell v) {
        List<MazeCell> neighbors = new ArrayList<MazeCell>();

        for (int[] d : DELTA) {
            int newRow = v.row + d[0];
            int newCol = v.col + d[1];

            if (!maze.inBounds(newRow, newCol)) {
                continue;
            }

            neighbors.add(new MazeCell(newRow, newCol));
        }

        return neighbors;
    }

    private <T> T getRandom(List<T> array) {
        int randIdx = (int)  (Math.random() * array.size());
        return array.get(randIdx);
    }
    private MazeCell getMiddleCell(MazeCell v1, MazeCell v2) {
        int midRow = (v1.row + v2.row) / 2;
        int midCol = (v1.col + v2.col) / 2;
        return new MazeCell(midRow, midCol);
    }

    private void randomlyConnectFrontier(MazeCell frontier) {

        // get a list of visited neighbors of the frontier
        List<MazeCell> visitedNeighbors = new ArrayList<MazeCell>();

        for (MazeCell v : getNeighbors(frontier)) {
            if (visitedCells.contains(v)) {
                visitedNeighbors.add(v);
            }
        }

        MazeCell randomVisitedNeighbor = getRandom(visitedNeighbors);

        // join the randomly visited cell with the frontier
        MazeCell middleCell = getMiddleCell(randomVisitedNeighbor, frontier);
        emptyCells.add(middleCell);
    }


    public static void main(String[] args) {
//        DesignableMaze bruh = new DesignableMaze(25, 25);
//        MazeGenerator gen = new RandomizedPrim(bruh);
//        gen.generate();
//        System.out.println(bruh);
    }

}
