package SolvabilityChecker;

import entities.DesignableMaze;
import entities.Maze;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
public class MazeSolver {

    private static List<int[]> getValidMoves(DesignableMaze maze, int position[]) {
        List<int[]> valid_moves = new ArrayList<int[]>();
        int[][] possible_moves = {{position[0] + 1, position[1]}, {position[0]- 1, position[1]},
                {position[0], position[1] + 1}, {position[0], position[1] - 1}};

        for (int[] move: possible_moves) {
            if (maze.inBounds(move[0], move[1]) && maze.getCell(move[0], move[1]) != Maze.ENCODING.get("wall")) {
                valid_moves.add(move);
            }
        }

        return valid_moves;
    }
    public static boolean checkMazeSolvability(DesignableMaze maze) {
        int[] startLocation = maze.getStartLocation();
        int[] endLocation = maze.getEndLocation();
        List<int[]> queue = new ArrayList<int[]>();
        queue.add(startLocation);
        Set<int[]> visited = new HashSet<int[]>();
        visited.add(startLocation);

        while (queue.size() > 0) {
            int[] curr_position = queue.get(0);
            queue.remove(0);
            if (curr_position == endLocation) {
                return true;
            }
            List<int[]> valid_moves = MazeSolver.getValidMoves(maze, curr_position);
            for (int[] move : valid_moves) {
                if (!visited.contains(move)) {
                    visited.add(move);
                    queue.add(move);
                }
            }
        }

        return false;
    }
}
