package HintGenerator;

import entities.DesignableMaze;
import entities.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class HintGenerator {

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

    public static List<int[]> generateHint(DesignableMaze maze) {
        // Store the maze's start cell
        int[] startLocation = maze.getStartLocation();
        // Store the maze's end cell
        int[] endLocation = maze.getEndLocation();
        // Initialize an arrayList to store the paths to explore
        List<List<int[]>> queue = new ArrayList<List<int[]>>();
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
            List<int[]> curr_path = queue.get(0);
            queue.remove(0);
            // Store the last cell in current path
            int[] curr_position = curr_path.get(curr_path.size() - 1);
            // Return true if the last cell in the current path is the end cell
            if (curr_position == endLocation) {
                return curr_path.subList(1, curr_path.size()/2 + 1);
            }
            // Get the valid moves from the last cell in the current path
            List<int[]> valid_moves = HintGenerator.getValidMoves(maze, curr_position);
            // Add new paths using all valid and unvisited moves to the queue, and mark the cells as visited
            for (int[] move : valid_moves) {
                if (!visited.contains(move)) {
                    visited.add(move);
                    curr_path.add(move);
                    queue.add(curr_path);
                }
            }
        }

        // Return and empty path if the queue was exhausted and the end cell was not reached
        return new ArrayList<int[]>();
    }
}
