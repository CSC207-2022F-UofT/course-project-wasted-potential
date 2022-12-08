package hints;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class HintGenerator {

    private HintGenerator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static List<MazeCell> generateHint(GameState maze) {
        // Store the maze's start cell
        int[] startLocation = maze.getPosition();
        MazeCell startCell = new MazeCell(startLocation[0], startLocation[1]);
        // Initialize an arrayList to store the paths to explore
        Queue<List<MazeCell>> queue = new LinkedList<>();
        // Add a 1 cell path containing the start cell to the queue
        List<MazeCell> initialPath = new ArrayList<>();
        initialPath.add(startCell);
        queue.add(initialPath);
        // Initialize a set to store all visited cells
        Set<MazeCell> visited = new HashSet<>();
        visited.add(startCell);

        // Perform breadth first search as long as there are still paths to explore in the queue
        while (!queue.isEmpty()) {
            // Store the next path to explore and remove it from the queue
            List<MazeCell> currPath = queue.remove();
            // Store the last cell in current path
            MazeCell currPosition = currPath.get(currPath.size() - 1);
            // Return true if the last cell in the current path is the end cell
            if (maze.getCell(currPosition.getRow(), currPosition.getCol()) == Maze.getEncoding("end")) {
                return currPath.subList(1, currPath.size()/2 + 1);
            }
            // Get the valid moves from the last cell in the current path
            List<MazeCell> validMoves = MazeSolver.getValidMoves(maze, currPosition);
            // Add new paths using all valid and unvisited moves to the queue, and mark the cells as visited
            for (MazeCell move : validMoves) {
                if (!visited.contains(move)) {
                    visited.add(move);
                    List<MazeCell> newPath = new ArrayList<>(currPath);
                    newPath.add(move);
                    queue.add(currPath);
                }
            }
        }

        // Return and empty path if the queue was exhausted and the end cell was not reached
        return new ArrayList<>();
    }
}
