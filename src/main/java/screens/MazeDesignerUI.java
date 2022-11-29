package screens;

import design.MazeDesignerController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class MazeDesignerUI extends Application {
    String css = this.getClass().getResource("/stylesheet.css").toExternalForm();
    private MazeDesignerController mdc;

    public MazeDesignerUI(MazeDesignerController mdc) {
        this.mdc = mdc;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        int row = 11;
        int col = 17;
        Button buttonarray[][] = new Button[row][col];
        primaryStage.setTitle("Maze Designer");
        GridPane root = new GridPane();
        Button publish = new Button("Publish");
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
                        outerWallEdit(primaryStage);
                    }
                } else {
                    String handler = "";
                    if (builder == choices.getSelectedToggle()) {
                        handler = "build";
                    } else if (bulldozer == choices.getSelectedToggle()) {
                        handler = "remove";
                    } else if (starter == choices.getSelectedToggle()) {
                        handler = "start";
                    } else if (ender == choices.getSelectedToggle()) {
                        handler = "end";
                    }
                    mdc.handleBuild(handler, row, col);
                    updateMazeUI(mdc.updateMaze(), buttonarray);
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
                updateMazeUI(mdc.updateMaze(), buttonarray);
            }
        };

        resetter.setOnAction(extrabuttons);
        randomizer.setOnAction(extrabuttons);

        updateMazeUI(mdc.updateMaze(), buttonarray);
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
        root.addRow(2, publish);

        Scene scene = new Scene(root, 1234, 750);
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public void outerWallEdit(Stage primaryStage){
        Popup wallpopup = new Popup();
        Button close = new Button("Close");
        Label label = new Label("You cannot edit the outermost walls!");
        GridPane popuppane = new GridPane();
        popuppane.addRow(0, label);
        popuppane.addRow(1, close);
        wallpopup.getContent().add(popuppane);
        popuppane.setStyle(" -fx-background-color: #CF6679; \n -fx-border-color: black;");
        close.setStyle("-fx-background-color: #BB86FC;");

        popuppane.setMinHeight(100);
        popuppane.setMinWidth(234);
        popuppane.setAlignment(Pos.CENTER);

        label.setMinWidth(80);
        label.setMinHeight(50);

        EventHandler<ActionEvent> popuphandle = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent popuphandle){
                if (popuphandle.getSource()==close){
                    wallpopup.hide();
                }
            }
        };
        close.setOnAction(popuphandle);
        wallpopup.show(primaryStage);
    }

    public void updateMazeUI(String[][] stringarray, Button[][] buttonarray){
        for (int i = 0; i < buttonarray.length; i++) {
            for (int j = 0; j < buttonarray[0].length; j++) {
                if(buttonarray[i][j] == null){
                    buttonarray[i][j] = new Button();
                }
                if(stringarray[i][j].equals("#")){
                    buttonarray[i][j].setText("#");
                    buttonarray[i][j].setStyle(" -fx-background-color: #03DAC6;");
                } else if(stringarray[i][j].equals(".")){
                    buttonarray[i][j].setText(".");
                    buttonarray[i][j].setStyle(" -fx-background-color: #121212;");
                } else if(stringarray[i][j].equals("S")){
                    buttonarray[i][j].setText("S");
                    buttonarray[i][j].setStyle(" -fx-background-color: #CF6679;");
                } else {
                    buttonarray[i][j].setText("E");
                    buttonarray[i][j].setStyle(" -fx-background-color: #CF6679;");
                }
            }
        }
    }
}

