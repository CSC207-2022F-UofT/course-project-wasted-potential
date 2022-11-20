package design;

import entities.DesignableMaze;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class MazeDesignerUI extends Application {
    String css = this.getClass().getResource("/stylesheet.css").toExternalForm();
    MazeDesignerPresenter mdp = new MazeDesignerPresenter();
    MazeDesignerController mdc = new MazeDesignerController();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        mdc.start();

        int row = mdc.getRows();
        int col = mdc.getCols();
        Button buttonarray[][] = new Button[row][col];
        primaryStage.setTitle("Maze Designer");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        ToggleButton builder = new ToggleButton("Build");
        ToggleButton bulldozer = new ToggleButton("Bulldoze");
        ToggleButton starter = new ToggleButton("Place Start");
        ToggleButton ender = new ToggleButton("Place End");
        Button resetter = new Button("Reset");
        resetter.setStyle(" -fx-background-color: #CF6679; \n -fx-text-fill: #121212;");
        Button randomizer = new Button("Random");
        randomizer.setStyle(" -fx-background-color:\n" +
                "            linear-gradient(from 0% 93% to 0% 100%, #3700D3 0%, #3700B3 100%),\n" +
                "            #3700A3,\n" +
                "            #372FF3,\n" +
                "            radial-gradient(center 50% 50%, radius 100%, #373FF3, #372AA3); \n -fx-text-fill: #FFFFFF;");
        HBox funcs = new HBox(builder, bulldozer, starter, ender, randomizer, resetter);
        ToggleGroup choices = new ToggleGroup();
        builder.setToggleGroup(choices);
        bulldozer.setToggleGroup(choices);
        starter.setToggleGroup(choices);
        ender.setToggleGroup(choices);

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event){
                int row=buttonarray.length;
                int col=buttonarray[0].length;

                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < col; j++) {
                        if (event.getSource()==buttonarray[i][j]){
                            row = i;
                            col = j;
                        }
                    }
                }
                if (row == 0 || col == 0 || row == buttonarray.length-1 || col == buttonarray[0].length-1){
                    if(event.getSource()!=resetter && event.getSource()!=randomizer) {
                        mdp.outerWallEdit(primaryStage);
                    }
                } else {
                    int handler = -1;
                    if (builder == (ToggleButton) choices.getSelectedToggle()) {
                        handler = 0;
                    } else if (bulldozer == (ToggleButton) choices.getSelectedToggle()) {
                        handler = 1;
                    } else if (starter == (ToggleButton) choices.getSelectedToggle()) {
                        handler = 2;
                    } else if (ender == (ToggleButton) choices.getSelectedToggle()) {
                        handler = 3;
                    }
                    mdc.handleBuild(handler, row, col);
                    mdp.updateMazeUI(mdc, buttonarray);
                }
            }
        };

        EventHandler<ActionEvent> extrabuttons = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent extrabuttons){
                if (extrabuttons.getSource()==resetter){
                    mdc.resetMaze();
                } else if (extrabuttons.getSource()==randomizer){
                    mdc.randoMaze();
                }
                mdp.updateMazeUI(mdc, buttonarray);
            }
        };

        resetter.setOnAction(extrabuttons);
        randomizer.setOnAction(extrabuttons);

        mdp.updateMazeUI(mdc, buttonarray);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                buttonarray[i][j].setOnAction(event);
            }
        }

        root.setVgap(10);
        root.addRow(0, funcs);
        GridPane maze = new GridPane();
        for (int i = 0; i < buttonarray.length; i++) {
            maze.addRow(i, buttonarray[i]);
        }
        root.addRow(1, maze);

        Scene scene = new Scene(root, 1234, 750);
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }
}
