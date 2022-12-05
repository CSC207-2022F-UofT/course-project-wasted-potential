package screens;
import java.util.ArrayList;

import display.MazeDisplayController;
import retrieval.MazeRetrieverController;
import retrieval.MazeRetrieverResponseModel;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import display.MazeDisplayResponseModel;


/**
 * The view for the maze retriever use case.
 *
 * @author Oscar Tuvey
 */
public class MazeRetrieverUI implements Screen {

    /**
     * The constructor for the MazeRetrieverView class.
     *
     * @param retrieverController the controller for the maze retriever use case.
     * @param displayController the controller for the maze display use case.
     */
    public MazeRetrieverUI(MazeRetrieverController retrieverController, MazeDisplayController displayController) {


        UserSingleton singleton = UserSingleton.getInstance();


        MazeRetrieverResponseModel retrieverRespModel = retrieverController.create(singleton.getUsername());
        ArrayList<Integer> played = (ArrayList<Integer>) retrieverRespModel.getPlayed();
        ArrayList<Integer> notPlayed = (ArrayList<Integer>) retrieverRespModel.getNotPlayed();

        HBox playedHBox = new HBox();
        HBox notPlayedHBox = new HBox();

        Button[] buttonsPlayed = new Button[played.size()];
        Button[] buttonsNotPlayed = new Button[notPlayed.size()];

        for (int i = 0; i < played.size(); i++) {
            buttonsPlayed[i] = new Button(played.get(i).toString());
            buttonsPlayed[i].setText(buttonsPlayed[i].toString());
            buttonsPlayed[i].setOnAction(event -> {
                Button button = (Button) event.getSource();
                MazeDisplayResponseModel respModel =
                        displayController.create(singleton.getUsername(), Integer.valueOf(button.getText()));
                MazeSingleton maze = MazeSingleton.getInstance();
                maze.setMaze(respModel.getMaze());

                ScreenManager.changeScreen("kill me"); // Need to send the maze to it too
            });
            playedHBox.getChildren().add(buttonsPlayed[i]);
        }

        for (int i = 0; i < notPlayed.size(); i++) {
            buttonsNotPlayed[i] = new Button(notPlayed.get(i).toString());
            buttonsNotPlayed[i].setText(buttonsNotPlayed[i].toString());
            buttonsNotPlayed[i].setOnAction(event -> {
                Button button = (Button) event.getSource();
                MazeDisplayResponseModel respModel =
                        displayController.create(singleton.getUsername(), Integer.valueOf(button.getText()));
                MazeSingleton maze = MazeSingleton.getInstance();
                maze.setMaze(respModel.getMaze());
                ScreenManager.changeScreen("kill me"); // Need to send the maze to it too

            });
            notPlayedHBox.getChildren().add(buttonsNotPlayed[i]);
        }


        GridPane root = new GridPane();

        root.setAlignment(Pos.CENTER);

        root.setVgap(10.0);

        root.addRow(0, playedHBox);

        root.addRow(1, notPlayedHBox);

        Scene scene = new Scene(root, 1234, 750);
    }
}
