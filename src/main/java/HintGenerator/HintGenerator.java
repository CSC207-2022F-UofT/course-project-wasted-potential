package HintGenerator;

import entities.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class HintGenerator {

    public static List<int[]> generateHint(GameState maze) {
        // Store the maze's start cell
        int[] startLocation = maze.getPosition();
        // Initialize an arrayList to store the paths to explore
        Queue<List<int[]>> queue = new LinkedList<List<int[]>>();
        // Add a 1 cell path containing the start cell to the queue
        queue.add(new ArrayList<int[]>() {
            {add(startLocation);}
        });
        // Initialize a set to store all visited cells
        Set<int[]> visited = new HashSet<int[]>() {
            {add(startLocation);}
        };

        // Perform breadth first search as long as there are still paths to explore in the queue
        while (queue.size() > 0) {
            // Store the next path to explore and remove it from the queue
            List<int[]> currPath = queue.remove();
            // Store the last cell in current path
            int[] currPosition = currPath.get(currPath.size() - 1);
            // Return true if the last cell in the current path is the end cell
            if (maze.getCell(currPosition[0], currPosition[1]) == Maze.ENCODING.get("end")) {
                return currPath.subList(1, currPath.size()/2 + 1);
            }
            // Get the valid moves from the last cell in the current path
            List<int[]> validMoves = MazeSolver.getValidMoves(maze, currPosition);
            // Add new paths using all valid and unvisited moves to the queue, and mark the cells as visited
            for (int[] move : validMoves) {
                if (!visited.contains(move)) {
                    visited.add(move);
                    List<int[]> newPath = new ArrayList(currPath);
                    newPath.add(move);
                    queue.add(currPath);
                }
            }
        }

        // Return and empty path if the queue was exhausted and the end cell was not reached
        return new ArrayList<int[]>();
    }
}
