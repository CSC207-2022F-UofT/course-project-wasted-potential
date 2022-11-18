package design;

import entities.DesignableMaze;
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
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.geometry.Pos;
//import resources.stylesheet.css;

import java.io.File;
import java.net.URL;


public class MazeDesignerWindow extends Application {
    Button button;
    Button buttonarr[][];
    String css = this.getClass().getResource("/stylesheet.css").toExternalForm();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Popup popup = new Popup();
        Button close = new Button("Close");
        DesignableMaze bruh = new DesignableMaze(23, 45);
        MazeDesigner md = new MazeDesigner();
        md.resetMaze(bruh);

        primaryStage.setTitle("Maze Designer");
        button = new Button();
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

        int row = bruh.getNumRow();
        int col = bruh.getNumCol();
        Button buttonarray[][] = new Button[row][col];

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event){
                int row=buttonarr.length;
                int col=buttonarr[0].length;

                for (int i = 0; i < buttonarr.length; i++) {
                    for (int j = 0; j < buttonarr[0].length; j++) {
                        if (event.getSource()==buttonarr[i][j]){
                            row = i;
                            col = j;
                        }
                    }
                }
                if (row == 0 || col == 0 || row == buttonarr.length-1 || col == buttonarr[0].length-1){
                    if(event.getSource()!=resetter && event.getSource()!=randomizer) {
                        Label label = new Label("You cannot edit the outermost walls!");
                        GridPane popuppane = new GridPane();
                        popuppane.addRow(0, label);
                        popuppane.addRow(1, close);
                        popup.getContent().add(popuppane);
                        popuppane.setStyle(" -fx-background-color: white; \n -fx-border-color: black;");

                        popuppane.setMinHeight(100);
                        popuppane.setMinWidth(234);
                        popuppane.setAlignment(Pos.CENTER);

                        label.setMinWidth(80);
                        label.setMinHeight(50);
                        popup.show(primaryStage);
                    }
                } else {
                    if (builder == (ToggleButton) choices.getSelectedToggle()) {
                        md.buildWall(bruh, row, col);
                        buttonarr[row][col].setText("#");
                        buttonarr[row][col].setStyle(" -fx-background-color: #03DAC6; \n -fx-border-color: none;");
                    } else if (bulldozer == (ToggleButton) choices.getSelectedToggle()) {
                        md.removeWall(bruh, row, col);
                        buttonarr[row][col].setText(".");
                        buttonarr[row][col].setStyle(" -fx-background-color: #121212; \n -fx-border-color: none;");
                    } else if (starter == (ToggleButton) choices.getSelectedToggle()) {
                        md.startPoint(bruh, row, col);
                        for (int i = 0; i < buttonarr.length; i++){
                            for (int j = 0; j < buttonarr[0].length; j++) {
                                if (buttonarr[i][j].getText().equals("S")){
                                    buttonarr[i][j].setText(".");
                                    buttonarr[i][j].setStyle(" -fx-background-color: #121212; \n -fx-border-color: none;");
                                    break;
                                }
                            }
                        }
                        buttonarr[row][col].setText("S");
                        buttonarr[row][col].setStyle(" -fx-background-color: #CF6679; \n -fx-border-color: none;");
                    } else if (ender == (ToggleButton) choices.getSelectedToggle()) {
                        md.startPoint(bruh, row, col);
                        for (int i = 0; i < buttonarr.length; i++){
                            for (int j = 0; j < buttonarr[0].length; j++) {
                                if (buttonarr[i][j].getText().equals("E")){
                                    buttonarr[i][j].setText(".");
                                    buttonarr[i][j].setStyle(" -fx-background-color: #121212; \n -fx-border-color: none;");
                                    break;
                                }
                            }
                        }
                        buttonarr[row][col].setText("E");
                        buttonarr[row][col].setStyle(" -fx-background-color: #CF6679; \n -fx-border-color: none;");
                    }
                }
            }
        };

        EventHandler<ActionEvent> extrabuttons = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent extrabuttons){

                if (extrabuttons.getSource()==resetter){
                    bruh.emptySetup();
                    for (int i = 0; i < bruh.getNumRow(); i++) {
                        for (int j = 0; j < bruh.getNumCol(); j++) {
                            buttonarray[i][j].setText(String.valueOf(bruh.getState(i, j)));
                            if(bruh.getState(i, j) == '#'){
                                buttonarr[i][j].setStyle(" -fx-background-color: #03DAC6; \n -fx-border-color: none;");
                            } else if (bruh.getState(i, j) == '.'){
                                buttonarr[i][j].setStyle(" -fx-background-color: #121212; \n -fx-border-color: none;");
                            } else {
                                buttonarr[i][j].setStyle(" -fx-background-color: #CF6679; \n -fx-border-color: none;");
                            }
                        }
                    }
                } else if (extrabuttons.getSource()==randomizer){
                    RandomizedPrim mg = new RandomizedPrim();
                    mg.generate(bruh);
                    md.startPoint(bruh,1,1);
                    md.endPoint(bruh, bruh.getNumRow()-2, bruh.getNumCol()-2);
                    buttonarr[1][1].setText(String.valueOf(bruh.getState(1, 1)));
                    buttonarr[bruh.getNumRow()-2][bruh.getNumRow()-2].setText(String.valueOf(bruh.getState(bruh.getNumRow()-2, bruh.getNumRow()-2)));
                    for (int i = 0; i < bruh.getNumRow(); i++) {
                        for (int j = 0; j < bruh.getNumCol(); j++) {
                            buttonarray[i][j].setText(String.valueOf(bruh.getState(i, j)));
                            if(bruh.getState(i, j) == '#'){
                                buttonarr[i][j].setStyle(" -fx-background-color: #03DAC6; \n -fx-border-color: none;");
                            } else if (bruh.getState(i, j) == '.'){
                                buttonarr[i][j].setStyle(" -fx-background-color: #121212; \n -fx-border-color: none;");
                            } else {
                                buttonarr[i][j].setStyle(" -fx-background-color: #CF6679; \n -fx-border-color: none;");
                            }
                        }
                    }
                }
            }
        };

        EventHandler<ActionEvent> popuphandle = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent popuphandle){
                if (popuphandle.getSource()==close){
                    popup.hide();
                }
            }
        };

        close.setOnAction(popuphandle);
        resetter.setOnAction(extrabuttons);
        randomizer.setOnAction(extrabuttons);

        System.out.println(bruh);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                buttonarray[i][j] = new Button(String.valueOf(bruh.getState(i, j)));
                if(bruh.getState(i, j) == '#'){
                    buttonarray[i][j].setStyle(" -fx-background-color: #03DAC6; \n -fx-border-color: none;");
                } else if (bruh.getState(i, j) == '.'){
                    buttonarray[i][j].setStyle(" -fx-background-color: #121212; \n -fx-border-color: none;");
                } else {
                    buttonarray[i][j].setStyle(" -fx-background-color: #CF6679; \n -fx-border-color: none;");
                }
                buttonarray[i][j].setOnAction(event);
            }
        }
        buttonarr = buttonarray;

        root.setVgap(10);
        root.addRow(0, funcs);

        GridPane maze = new GridPane();

        for (int i = 0; i < buttonarr.length; i++) {
            maze.addRow(i, buttonarr[i]);
        }
        root.addRow(1, maze);

        Scene scene = new Scene(root, 1234, 750);
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
