package maze_nav_use_case;

import entities.*;

/**
 * The Input Data for the Maze Navigation Use Case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavRequestModel {

    private char keyStroke;

    private int[] position;

    private int[] requestedPosition;

    private GameState maze;

    /**
     * The constructor for the MazeNavRequestModel class.
     *
     * @param keyStroke the user input
     * @param position the current position of the icon
     * @param maze the maze being played
     */
    public MazeNavRequestModel(char keyStroke, int[] position, GameState maze) {
        this.keyStroke = keyStroke;

        this.position = maze.getPosition();

        if (keyStroke == 'w') { // Check that '==' is okay
            this.requestedPosition = new int[]{position[0], (position[1] + 1)};
        }

        else if (keyStroke == 'a') {
            this.requestedPosition = new int[]{position[0] - 1, position[1]};
        }

        else if (keyStroke == 's') {
            this.requestedPosition = new int[]{position[0], position[1] - 1};
        }

        else if (keyStroke == 'd') {
            this.requestedPosition = new int[]{position[0] + 1, position[1]};
        }

        else {
            this.requestedPosition = null; // This isn't what you want to do
            // need to ignore invalid keystrokes completely
        }

        this.maze = maze;
    }

    /**
     * A getter method which returns the user input.
     *
     * @return keyStroke the user input
     */
    public char getKeyStroke() {
        return this.keyStroke;
    }

    /**
     * A getter method which returns the icon's current position.
     *
     * @return currentPosition an array representing the icon's current position
     */
    public int[] getPosition() {
        return this.position;
    }

    /**
     * A getter method which returns the icon's requested position.
     *
     * @return requestedPosition an array representing the icon's requested position
     */
    public int[] getRequestedPosition() {
        return this.requestedPosition;
    }

    /**
     * A getter method which returns the maze being played.
     *
     * @return maze the maze being played
     */
    public GameState getMaze() {
        return this.maze;
    }
}
