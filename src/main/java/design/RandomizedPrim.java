package design;

import entities.DesignableMaze;

import java.util.ArrayList;
//import java.util.Collections;
import java.util.List;

public class RandomizedPrim extends MazeGenerator {

    private static final int[][] DELTA = {
        {2, 0}, {-2, 0}, {0,-2}, {0, 2}
    };

    List<Vertex> visited = new ArrayList<Vertex>();
    List<Vertex> frontierVertices = new ArrayList<Vertex>();
    List<Vertex> emptyCells = new ArrayList<Vertex>();
//    List<Edge> edges = new ArrayList<Edge>();

    public void addVertex(Vertex v) {
        visited.add(v);
        emptyCells.add(v);

        List<Vertex> neighbors = getNeighbors(v);

        for (Vertex potFrontier : neighbors) {

            if (visited.contains(potFrontier) || frontierVertices.contains(potFrontier)) {
                continue;
            }

            frontierVertices.add(potFrontier);

        }
    }

    public List<Vertex> getNeighbors(Vertex v) {
        List<Vertex> neighbors = new ArrayList<Vertex>();

        for (int[] d : DELTA) {
            int newRow = v.row + d[0];
            int newCol = v.col + d[1];

            if (!maze.inBounds(newRow, newCol)) {
                continue;
            }

            neighbors.add(new Vertex(newRow, newCol));
        }

        return neighbors;
    }

    public <T> T getRandom(List<T> array) {
        int randIdx = (int)  (Math.random() * array.size());
        return array.get(randIdx);
    }
    public Vertex getMiddleCell(Vertex v1, Vertex v2) {
        int midRow = (v1.row + v2.row) / 2;
        int midCol = (v1.col + v2.col) / 2;
        return new Vertex(midRow, midCol);
    }

    @Override
    public void generate(DesignableMaze maze) {
        this.maze = maze;

        maze.fill();

        Vertex startVertex = new Vertex(1, 1);
        addVertex(startVertex);

        while (!frontierVertices.isEmpty()) {
            Vertex frontier =  getRandom(frontierVertices);
            frontierVertices.remove(frontier);
            addVertex(frontier);

            List<Vertex> frontierNeighbors = new ArrayList<Vertex>();

            for (Vertex v : getNeighbors(frontier)) {
                if (visited.contains(v)) {
                    frontierNeighbors.add(v);
                }
            }

            Vertex randVisited = getRandom(frontierNeighbors);
            Vertex middleCell = getMiddleCell(randVisited, frontier);

            emptyCells.add(middleCell);
        }

        for (Vertex e : emptyCells)  {
            maze.deleteWall(e.row, e.col);
        }

        System.out.println(maze);
    }

    public static void main(String[] args) {
        DesignableMaze bruh = new DesignableMaze(9, 35);
        MazeGenerator mg = new RandomizedPrim();
        mg.generate(bruh);
    }

}
