package screens;

import display.MazeDisplayController;
import display.MazeDisplayResponseModel;
import entities.PublishedMaze;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import retrieval.MazeRetrieverController;
import retrieval.MazeRetrieverResponseModel;
import singletons.MazeSingleton;
import singletons.UserSingleton;

import java.util.Collections;
import java.util.List;

/**
 * The view for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */
public class MazeRetrieverUI extends Application implements Screen {
    String css = this.getClass().getResource("/stylesheet.css").toExternalForm();

    private final MazeRetrieverController retrieverController;
    private final MazeDisplayController displayController;

    /**
     * The constructor for the MazeRetrieverView class.
     *
     * @param retrieverController the controller for the maze retriever use case.
     * @param displayController the controller for the maze display use case.
     */
    public MazeRetrieverUI(MazeRetrieverController retrieverController, MazeDisplayController displayController) {
        this.retrieverController = retrieverController;
        this.displayController = displayController;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Menu");
        UserSingleton singleton = UserSingleton.getInstance();
        MazeSingleton maze = MazeSingleton.getInstance();


        MazeRetrieverResponseModel retrieverRespModel = retrieverController.create(singleton.getUsername());
        List<PublishedMaze> played;
        List<PublishedMaze> notPlayed;
        try {
            played = retrieverRespModel.getPlayed();
        } catch (ClassCastException e) {
            played = Collections.emptyList();
        }
        try {
            notPlayed = retrieverRespModel.getNotPlayed();
        } catch (ClassCastException e) {
            notPlayed = Collections.emptyList();
        }

        HBox playedHBox = new HBox();
        HBox notPlayedHBox = new HBox();

        // log out button
        Button logOutButton = new Button("Log Out");
        logOutButton.getStyleClass().add("log-out-button");
        logOutButton.setLayoutX(100);
        logOutButton.setLayoutX(680);

        Button[] buttonsPlayed;
        try {
            buttonsPlayed = new Button[played.size()];
        } catch (NullPointerException e){
            buttonsPlayed = new Button[0];
        }
        Button[] buttonsNotPlayed = new Button[notPlayed.size()];

        for (int i = 0; i < played.size(); i++) {
            PublishedMaze publishedMaze = played.get(i);
            String buttonText = publishedMaze.getId() + ", " + publishedMaze.getName() + ", " +
                    publishedMaze.getAuthor();
            buttonsPlayed[i] = new Button(buttonText);
            buttonsPlayed[i].setText(buttonText);
            buttonsPlayed[i].setOnAction(event -> {
                Button button = (Button) event.getSource();
                String[] buttonString = button.getText().split(",");
                String mazeId = buttonString[0].trim();
                MazeDisplayResponseModel respModel =
                        displayController.create(singleton.getUsername(), Integer.parseInt(mazeId));
                maze.setMaze(respModel.getMaze());

                ScreenManager.changeScreen("game");
            });
            playedHBox.getChildren().add(buttonsPlayed[i]);
        }

        // We decided to keep this warning as it aided with the readability of the code
        for (int i = 0; i < notPlayed.size(); i++) {
            PublishedMaze publishedMaze = notPlayed.get(i);
            String buttonText = publishedMaze.getId() + ", " + publishedMaze.getName() + ", " +
                    publishedMaze.getAuthor();
            buttonsNotPlayed[i] = new Button(buttonText);
            buttonsNotPlayed[i].setText(buttonText);
            buttonsNotPlayed[i].setOnAction(event -> {
                Button button = (Button) event.getSource();
                String[] buttonString = button.getText().split(",");
                String mazeId = buttonString[0].trim();
                System.out.println(mazeId);
                MazeDisplayResponseModel respModel =
                        displayController.create(singleton.getUsername(), Integer.parseInt(mazeId));
                maze.setMaze(respModel.getMaze());
                ScreenManager.changeScreen("game");

            });
            notPlayedHBox.getChildren().add(buttonsNotPlayed[i]);
        }


        GridPane root = new GridPane();

        root.setAlignment(Pos.CENTER);

        root.setVgap(10);

        root.addRow(0, logOutButton);

        root.addRow(1, playedHBox);

        root.addRow(2, notPlayedHBox);

        Scene scene = new Scene(root, 1234, 750);

        logOutButton.setOnAction(actionEvent -> ScreenManager.changeScreen("login"));

        primaryStage.setScene(scene);
        scene.getStylesheets().add(css);
        primaryStage.setMaximized(true);
        primaryStage.show();


    }
}
