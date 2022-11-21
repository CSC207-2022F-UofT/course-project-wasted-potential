package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

public class MazeSolver {

    public static List<int[]> getValidMoves(Maze maze, int position[]) {
        // Intialize an empty arrayList to store the valid moves
        List<int[]> validMoves = new ArrayList<int[]>();
        // Initialize an array to store the cell representations of moves in all 4 directions
        int[][] possibleMoves = {{position[0] + 1, position[1]}, {position[0] - 1, position[1]},
                {position[0], position[1] + 1}, {position[0], position[1] - 1}};

        // Add all valid moves in possibleMoves to the validMoves arrayList
        for (int[] move: possibleMoves) {
            if (maze.inBounds(move[0], move[1]) && maze.getCell(move[0], move[1]) != Maze.ENCODING.get("wall")) {
                validMoves.add(move);
            }
        }

        // Return all valid moves
        return validMoves;
    }

    public static boolean checkMazeSolvability(DesignableMaze maze) {
        // Store the maze's start cell
        int[] startLocation = maze.getStartLocation();
        // Initialize an arrayList to store the cells to visit
        Queue<int[]> queue = new LinkedList<int[]>() {
            {add(startLocation);}
        };
        // Initialize a set to store all visited cells
        Set<int[]> visited = new HashSet<int[]>() {
            {add(startLocation);}
        };

        // Perform breadth first search as long as there are still cells to visit in the queue
        while (queue.size() > 0) {
            // Store the next cell to visit and remove it from the queue
            int[] currPosition = queue.remove();
            // Return true if the current cell is the end cell
            if (maze.getCell(currPosition[0], currPosition[1]) == Maze.ENCODING.get("end")) {
                return true;
            }
            // Get the valid moves from the current cell
            List<int[]> validMoves = MazeSolver.getValidMoves(maze, currPosition);
            // Add all valid and unvisited moves to the queue and mark them as visited
            for (int[] move : validMoves) {
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
