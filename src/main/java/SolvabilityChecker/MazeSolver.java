package SolvabilityChecker;

import entities.DesignableMaze;
import entities.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
public class MazeSolver {

    private static List<int[]> getValidMoves(DesignableMaze maze, int position[]) {
        // Intialize an empty arrayList to store the valid moves
        List<int[]> valid_moves = new ArrayList<int[]>();
        // Initialize an array to store the cell representations of moves in all 4 directions
        int[][] possible_moves = {{position[0] + 1, position[1]}, {position[0] - 1, position[1]},
                {position[0], position[1] + 1}, {position[0], position[1] - 1}};

        // Add all valid moves in possible_moves to the valid_moves arrayList
        for (int[] move: possible_moves) {
            if (maze.inBounds(move[0], move[1]) && maze.getCell(move[0], move[1]) != Maze.ENCODING.get("wall")) {
                valid_moves.add(move);
            }
        }

        // Return all valid moves
        return valid_moves;
    }

    public static boolean checkMazeSolvability(DesignableMaze maze) {
        // Store the maze's start cell
        int[] startLocation = maze.getStartLocation();
        // Store the maze's end cell
        int[] endLocation = maze.getEndLocation();
        // Initialize an arrayList to store the cells to visit
        List<int[]> queue = new ArrayList<int[]>() {
            {add(startLocation);}
        };
        // Initialize a set to store all visited cells
        Set<int[]> visited = new HashSet<int[]>() {
            {add(startLocation);}
        };

        // Perform breadth first search as long as there are still cells to visit in the queue
        while (queue.size() > 0) {
            // Store the next cell to visit and remove it from the queue
            int[] curr_position = queue.get(0);
            queue.remove(0);
            // Return true if the current cell is the end cell
            if (curr_position == endLocation) {
                return true;
            }
            // Get the valid moves from the current cell
            List<int[]> valid_moves = MazeSolver.getValidMoves(maze, curr_position);
            // Add all valid and unvisited moves to the queue and mark them as visited
            for (int[] move : valid_moves) {
                if (!visited.contains(move)) {
                    visited.add(move);
                    queue.add(move);
                }
            }
        }

        // Return false if the queue was exhausted and the end cell was not reached
        return false;
    }
}
