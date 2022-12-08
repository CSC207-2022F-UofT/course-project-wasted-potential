package screens;

import entities.GameState;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import navigation.InvalidMove;
import navigation.MazeNavController;
import navigation.MazeNavResponseModel;
import javafx.application.Application;

/**
 * The view class for the maze navigation use case.
 */
public class MazeNavUI extends Application implements Screen {
    String css = this.getClass().getResource("/stylesheet.css").toExternalForm();

    private final MazeNavController controller;

    /**
     * The constructor for the MazeNavView.
     *
     * @param controller the controller for the maze navigation use case
     */
    public MazeNavUI(MazeNavController controller) {
        this.controller = controller;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String args[]) {
        launch(args);
    }

    /**
     * Update the UI.
     *
     * @param mazeState the state of the maze
     * @param buttonarray the buttonarray
     * @param userPosition the position of the player
     */
    public void updateMazeUI(char[][] mazeState, Button[][] buttonarray, int[] userPosition){
        // Translate each cell in the mazeState to a renderable button
        for (int i = 0; i < buttonarray.length; i++) {
            for (int j = 0; j < buttonarray[0].length; j++) {

                if (buttonarray[i][j] == null){
                    buttonarray[i][j] = new Button();
                }

                Button button = buttonarray[i][j];

                button.getStyleClass().clear();
                button.getStyleClass().add("maze-button-play");

                char state = mazeState[i][j];

                if (state == '#'){
                    button.getStyleClass().add("maze-wall");
                } else if (state == '.'){
                    button.getStyleClass().add("maze-empty");
                } else if (state == 'S'){
                    button.getStyleClass().add("maze-start");
                } else if (state == 'E'){
                    button.getStyleClass().add("maze-end");
                }
            }
        }
        // Change the styles of the cell at the player's current position
        buttonarray[userPosition[0]][userPosition[1]].getStyleClass().add("maze-player");

    }

    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 1234, 750);
        scene.getStylesheets().add(css);
        MazeSingleton singleton = MazeSingleton.getInstance();
        // Get current maze instance
        GameState maze = singleton.getMaze();
        // Button array to render cells
        Button[][] buttonarray = new Button[maze.getNumRow()][maze.getNumCol()];
        updateMazeUI(maze.getState(), buttonarray, maze.getPosition());

        // Render contents of buttonarray
        GridPane mazeRender = new GridPane();
        for (int i = 0; i < buttonarray.length; i++) {
            mazeRender.addRow(i, buttonarray[i]);
        }
        root.addRow(1, mazeRender);

        // Move handler
        scene.setOnKeyPressed((KeyEvent event) -> {
            try {
                MazeNavResponseModel responseModel;
                if (event.getCode() == KeyCode.W) {
                    responseModel = controller.create('w', maze.getPosition(), maze);
                }
                else if (event.getCode() == KeyCode.A) {
                    responseModel = controller.create('a', maze.getPosition(), maze);
                }
                else if (event.getCode() == KeyCode.S) {
                    responseModel = controller.create('s', maze.getPosition(), maze);
                }
                else {
                    responseModel = controller.create('d', maze.getPosition(), maze);
                }
                updateMazeUI(maze.getState(), buttonarray, maze.getPosition());
                if (responseModel.getIsComplete()) {
                    MazeCompleteAlertBox.display("Maze Complete!", "Congrats, you just solved this maze. " +
                            "You will now be redirected to the home screen.");
                }
            }
            // Handle invalid moves
            catch (InvalidMove e) {
                int[] requestedPosition = e.getRequestedPosition();
                buttonarray[requestedPosition[0]][requestedPosition[1]].getStyleClass().add("error-wall");
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
