package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;

/**
 * The type Maze solver.
 */
public class MazeSolver {

    /**
     * Finds all valid moves in a given maze.
     *
     * @param maze     the maze being navigated
     * @param position the position within the maze
     * @return a list of all the valid moves
     */
    public static List<MazeCell> getValidMoves(Maze maze, MazeCell position) {
        // Intialize an empty arrayList to store the valid moves
        List<MazeCell> validMoves = new ArrayList<MazeCell>();
        // Initialize an array to store the cell representations of moves in all 4 directions
        MazeCell[] possibleMoves = {new MazeCell(position.row + 1, position.col),
                new MazeCell(position.row - 1, position.col),
                new MazeCell(position.row, position.col + 1),
                new MazeCell(position.row, position.col - 1)};

        // Add all valid moves in possibleMoves to the validMoves arrayList
        for (MazeCell move: possibleMoves) {
            if (maze.inBounds(move.row, move.col) && maze.getCell(move.row, move.col) != Maze.ENCODING.get("wall")) {
                validMoves.add(move);
            }
        }

        // Return all valid moves
        return validMoves;
    }

    /**
     * Check whether a maze is solvable.
     *
     * @param maze the maze to be checked
     * @return a boolean value representing whether the maze is solvable
     */
    public static boolean checkMazeSolvability(DesignableMaze maze) {
        // Store the maze's start cell
        int[] startLocation = maze.getStartLocation();
        MazeCell startCell = new MazeCell(startLocation[0], startLocation[1]);
        // Initialize an arrayList to store the cells to visit
        Queue<MazeCell> queue = new LinkedList<MazeCell>() {
            {add(startCell);}
        };
        // Initialize a set to store all visited cells
        Set<MazeCell> visited = new HashSet<MazeCell>() {
            {add(startCell);}
        };

        // Perform breadth first search as long as there are still cells to visit in the queue
        while (queue.size() > 0) {
            // Store the next cell to visit and remove it from the queue
            MazeCell currPosition = queue.remove();
            // Return true if the current cell is the end cell
            if (maze.getCell(currPosition.row, currPosition.col) == Maze.ENCODING.get("end")) {
                return true;
            }
            // Get the valid moves from the current cell
            List<MazeCell> validMoves = MazeSolver.getValidMoves(maze, currPosition);
            // Add all valid and unvisited moves to the queue and mark them as visited
            for (MazeCell move : validMoves) {
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
