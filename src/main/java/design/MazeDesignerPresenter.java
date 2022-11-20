package design;

import entities.DesignableMaze;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MazeDesignerPresenter implements MazeDesignerOutputBoundary{
    public void updateMazeUI(MazeDesignerController md, Button[][] buttonarray){
        for (int i = 0; i < md.getRows(); i++) {
            for (int j = 0; j < md.getCols(); j++) {
                if(buttonarray[i][j] == null){
                    buttonarray[i][j] = new Button();
                }
                if(md.cellChar(i, j) == '#'){
                    buttonarray[i][j].setText("#");
                    buttonarray[i][j].setStyle(" -fx-background-color: #03DAC6;");
                } else if (md.cellChar(i, j) == '.'){
                    buttonarray[i][j].setText(".");
                    buttonarray[i][j].setStyle(" -fx-background-color: #121212;");
                } else if (md.cellChar(i, j) == 'S'){
                    buttonarray[i][j].setText("S");
                    buttonarray[i][j].setStyle(" -fx-background-color: #CF6679;");
                } else {
                    buttonarray[i][j].setText("E");
                    buttonarray[i][j].setStyle(" -fx-background-color: #CF6679;");
                }
            }
        }
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
}
