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

import java.net.URL;


public class MazeDesignerWindow extends Application {
    Button button;
    Button buttonarr[][];

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Popup popup = new Popup();
        Button close = new Button("Close");
        DesignableMaze bruh = new DesignableMaze(11, 12);
        MazeDesigner md = new MazeDesigner();
        md.resetMaze(bruh);

        primaryStage.setTitle("Maze Designer");
        button = new Button();
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);

        ToggleButton builder = new ToggleButton("Build Wall");
        ToggleButton bulldozer = new ToggleButton("Bulldoze Wall");
        ToggleButton starter = new ToggleButton("Place Start");
        ToggleButton ender = new ToggleButton("Place End");

        Button resetter = new Button("Reset");

        HBox funcs = new HBox(builder, bulldozer, starter, ender, resetter);
        ToggleGroup choices = new ToggleGroup();

        builder.setToggleGroup(choices);
        bulldozer.setToggleGroup(choices);
        starter.setToggleGroup(choices);
        ender.setToggleGroup(choices);

        int row = bruh.getNumRow()+2;
        int col = bruh.getNumCol()+2;
        Button buttonarray[][] = new Button[row][col];

        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event){
                int row=buttonarr.length;
                int col=buttonarr[0].length;

                for (int i = 0; i < buttonarr.length; i++) {
                    for (int j = 0; j < buttonarr[0].length; j++) {
                        if (event.getSource()==buttonarr[i][j]){
                            row = i-1;
                            col = j-1;
                            System.out.println(row +", " + col);
                        }
                    }
                }
                if (event.getSource()==resetter){
                    bruh.emptySetup();
                    for (int i = 0; i < bruh.getNumRow()+2; i++) {
                        for (int j = 0; j < bruh.getNumCol()+2; j++) {
                            buttonarray[i][j].setText("#");
                            if (i > 0 && i < row - 1 && j > 0 && j < col - 1) {
                                buttonarray[i][j].setText(String.valueOf(bruh.getState(i - 1, j - 1)));
                            }
                        }
                    }
                }
                if (row < 0 || col < 0 || row >= buttonarr.length-2 || col >= buttonarr[0].length-2){
                    if(event.getSource()!=resetter) {
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
                        buttonarr[row+1][col+1].setText("#");
                    } else if (bulldozer == (ToggleButton) choices.getSelectedToggle()) {
                        md.removeWall(bruh, row, col);
                        buttonarr[row+1][col+1].setText(".");
                    } else if (starter == (ToggleButton) choices.getSelectedToggle()) {
                        md.startPoint(bruh, row, col);
                        for (int i = 0; i< buttonarr.length; i++){
                            for (int j = 0; j < buttonarr[0].length; j++) {
                                if (buttonarr[i][j].getText().equals("S")){
                                    buttonarr[i][j].setText(".");
                                    break;
                                }
                            }
                        }
                        buttonarr[row+1][col+1].setText("S");
                    } else if (ender == (ToggleButton) choices.getSelectedToggle()) {
                        md.startPoint(bruh, row, col);
                        for (int i = 0; i< buttonarr.length; i++){
                            for (int j = 0; j < buttonarr[0].length; j++) {
                                if (buttonarr[i][j].getText().equals("E")){
                                    buttonarr[i][j].setText(".");
                                    break;
                                }
                            }
                        }
                        buttonarr[row+1][col+1].setText("E");
                    }
                }
                if (event.getSource()==close){
                    popup.hide();
                }
            }
        };

        close.setOnAction(event);
        resetter.setOnAction(event);


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                buttonarray[i][j] = new Button("#");
                buttonarray[i][j].setOnAction(event);
                if (i > 0 && i < row - 1 && j > 0 && j < col - 1) {
                    buttonarray[i][j].setText(String.valueOf(bruh.getState(i - 1, j - 1)));
                }
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

        Scene scene = new Scene(root, 750, 666);
        if (this.getClass().getResource("/mdwstylesheet.css") == null) {
            System.out.println("Resource not found. Aborting.");
        } else {
            String css = this.getClass().getResource("/mdwstylesheet.css").toExternalForm();
            scene.getStylesheets().add(css);
        }

        root.getStyleClass().add("fancy-button");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
