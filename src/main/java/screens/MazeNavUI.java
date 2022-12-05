package screens;

import entities.GameState;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import navigation.InvalidMove;
import navigation.MazeNavResponseModel;

/**
 * The view class for the maze navigation use case.
 */
public class MazeNavUI {

    private final Color[] color;
    private final GraphicsContext g;
    private final GameState maze;


    /**
     * The constructor for the MazeNavView.
     *
     * @param controller the controller for the maze navigation use case
     */
    public MazeNavUI(MazeNavController controller) {

        GridPane root = new GridPane();
        MazeSingleton singleton = MazeSingleton.getInstance();
        this.maze = singleton.getMaze();
        Canvas canvas = new Canvas(maze.getNumCol(), maze.getNumRow());

        char[][] mazeState = maze.getState();

        this.color = new Color[] {
                Color.rgb(200, 0, 0),
                Color.rgb(128, 128, 255),
                Color.rgb(200, 200, 200),
                Color.rgb(0, 200, 0)
        };

        this.g = canvas.getGraphicsContext2D();
        Affine affine = new Affine();
        g.setTransform(affine);

        for (int x = 0; x < maze.getNumRow(); x++) {
            for (int y = 0; y < maze.getNumCol(); y++) {
                if (mazeState[x][y] == '#') {
                    g.setFill(color[0]);
                    g.fillRect(x, y, 1, 1);
                }
                else if (mazeState[x][y] == '.') {
                    g.setFill(color[2]);
                    g.fillRect(x, y, 1, 1);
                }
                else if (mazeState[x][y] == 'S') {
                    g.setFill(color[3]);
                    g.fillRect(x, y, 1, 1);
                }
                else {
                    g.setFill(color[1]);
                    g.fillRect(x, y, 1, 1);
                }
            }
        }

        try {
            canvas.setOnKeyPressed(e -> {
                MazeNavResponseModel responseModel;
                if (e.getCode() == KeyCode.W) {
                    responseModel = controller.create('w', maze.getPosition(), maze);
                } else if (e.getCode() == KeyCode.A) {
                    responseModel = controller.create('a', maze.getPosition(), maze);
                } else if (e.getCode() == KeyCode.S) {
                    responseModel = controller.create('s', maze.getPosition(), maze);
                } else {
                    responseModel = controller.create('d', maze.getPosition(), maze);
                }

                if (responseModel.getIsComplete()) {
                    MazeCompleteAlertBox.display("Maze Complete!", "Maze Complete Window");
                }
                else {
                    updateUI(responseModel);
                }
            });
        }
        catch (InvalidMove e) {
            InvalidMoveAlertBox.display("Invalid Move", e.getMessage());
        }

        root.addRow(1, canvas);
        Scene scene = new Scene(root, 640, 480);
    }

    /**
     * A method to update the GUI to reflect the user's new position in the maze.
     *
     * @param responseModel an object containing the old position and the new position of the user
     */
    public void updateUI(MazeNavResponseModel responseModel) {
        int[] oldPosition = responseModel.getOldPosition();
        int[] newPosition = responseModel.getNewPosition();
        g.setFill(color[2]);
        g.fillRect(oldPosition[0], oldPosition[1], 1, 1);
        g.setFill(color[3]);
        g.fillRect(newPosition[0], newPosition[1], 1, 1);
    }
}
