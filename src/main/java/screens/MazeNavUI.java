package screens;

import entities.GameState;
import entities.MazeCell;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import navigation.InvalidMove;
import navigation.MazeNavController;
import hints.HintGeneratorControl;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * The view class for the maze navigation use case.
 */
public class MazeNavUI extends Application implements Screen {
    String css = this.getClass().getResource("/stylesheet.css").toExternalForm();

    private final MazeNavController controller;
    private final HintGeneratorControl hintController;

    private GameState maze;

    private List<MazeCell> hint;

    private Button[][] buttonarray;

    /**
     * The constructor for the MazeNavView.
     *
     * @param controller the controller for the maze navigation use case
     */
    public MazeNavUI(MazeNavController controller, HintGeneratorControl hintController) {
        this.controller = controller;
        this.hintController = hintController;
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
     * @param userPosition the position of the player
     */
    public void updateMazeUI(char[][] mazeState, int[] userPosition){
        // Translate each cell in the mazeState to a renderable button
        for (int i = 0; i < this.buttonarray.length; i++) {
            for (int j = 0; j < this.buttonarray[0].length; j++) {

                if (this.buttonarray[i][j] == null){
                    this.buttonarray[i][j] = new Button();
                }

                Button button = this.buttonarray[i][j];

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
        // Change the styles of hint cells
        for (MazeCell cell : this.hint) {
            this.buttonarray[cell.getRow()][cell.getCol()].getStyleClass().add("maze-hint");
        }
        // Change the styles of the cell at the player's current position
        this.buttonarray[userPosition[0]][userPosition[1]].getStyleClass().add("maze-player");

        MazeCell currentPositionCell = new MazeCell(userPosition[0], userPosition[1]);
        if (this.hint.contains(currentPositionCell)) {
            this.hint.remove(currentPositionCell);
        }
    }

    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setVgap(10);
        Scene scene = new Scene(root, 1234, 750);
        scene.getStylesheets().add(css);
        MazeSingleton singleton = MazeSingleton.getInstance();
        // Get current maze instance
        this.maze = singleton.getMaze();
        // Button array to render cells
        this.buttonarray = new Button[maze.getNumRow()][maze.getNumCol()];
        // Initialize empty hint
        this.hint = new ArrayList<>();
        updateMazeUI(this.maze.getState(), this.maze.getPosition());

        // quit button
        Button quitButton = new Button("Quit");
        quitButton.getStyleClass().add("log-out-button");
        quitButton.setLayoutX(680);

        // hint button
        Button hintButton = new Button("Hint");
        hintButton.getStyleClass().add("hint-button");
        hintButton.setLayoutX(600);

        // maze name
        Text mazeName = new Text(this.maze.getName());
        mazeName.getStyleClass().add("maze-name");
        mazeName.setLayoutY(15);

        AnchorPane topRow = new AnchorPane(mazeName, hintButton, quitButton);
        root.addRow(0, topRow);

        // Render contents of buttonarray
        GridPane mazeRender = new GridPane();
        for (int i = 0; i < this.buttonarray.length; i++) {
            mazeRender.addRow(i, this.buttonarray[i]);
        }
        root.addRow(1, mazeRender);


        // Move handler
        scene.setOnKeyPressed((KeyEvent event) -> {
            try {
                boolean isComplete;
                if (event.getCode() == KeyCode.W) {
                    isComplete = controller.create('w', this.maze.getPosition(), this.maze);
                }
                else if (event.getCode() == KeyCode.A) {
                    isComplete = controller.create('a', this.maze.getPosition(), this.maze);
                }
                else if (event.getCode() == KeyCode.S) {
                    isComplete = controller.create('s', this.maze.getPosition(), this.maze);
                }
                else {
                    isComplete = controller.create('d', this.maze.getPosition(), this.maze);
                }
                updateMazeUI(maze.getState(), maze.getPosition());
                if (isComplete) {
                    MazeCompleteAlertBox.display("Maze Complete!", "Congrats, you just solved this maze. " +
                            "You will now be redirected to the home screen.");
                }
            }
            // Handle invalid moves
            catch (InvalidMove e) {
                int[] requestedPosition = e.getRequestedPosition();
                this.buttonarray[requestedPosition[0]][requestedPosition[1]].getStyleClass().add("error-wall");
            }
        });

        quitButton.setOnAction(actionEvent -> {
            ScreenManager.changeScreen("home");
        });

        hintButton.setOnAction(actionEvent -> {
            this.hint = hintController.generateHint(maze).getHint();
            updateMazeUI(this.maze.getState(), this.maze.getPosition());
        });

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
