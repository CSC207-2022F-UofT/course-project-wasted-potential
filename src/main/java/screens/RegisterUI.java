package screens;
import user_registration.UserRegisterController;
import user_registration.UserRegisterResponseModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Popup;

import javax.swing.*;


public class RegisterUI extends Application implements Screen{

    private UserRegisterController controller;

    public RegisterUI(UserRegisterController controller){
        this.controller = controller;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        String designerText = "Designer";
        String playerText = "Player";

        Label userl = new Label("Create Username");
        Label pwdl = new Label("Create Password");
        Label rpwdl = new Label("Reconfirm Password");

        TextField utf = new TextField();
        PasswordField pwf = new PasswordField();
        PasswordField rpwf = new PasswordField();

        GridPane formgp = new GridPane();
        formgp.setAlignment(Pos.CENTER);
        formgp.setHgap(10);
        formgp.setVgap(10);
        formgp.setPadding(new Insets(25, 25, 25, 25));
        formgp.add(userl,0,0);
        formgp.add(utf,2,0);

        formgp.add(pwdl,0,1);
        formgp.add(pwf,2,1);

        formgp.add(rpwdl,0,2);
        formgp.add(rpwf,2,2);

        Label choose = new Label("Please choose a user type:");
        Label error = new Label();
        Button regis = new Button("Register");

        Button goBackButton = new Button("Go back");
        goBackButton.getStyleClass().add("go-back-button");

        ToggleButton designerButton = new ToggleButton(designerText);
        ToggleButton playerButton = new ToggleButton(playerText);
        ToggleGroup chooseUserType = new ToggleGroup();
        designerButton.setToggleGroup(chooseUserType);
        playerButton.setToggleGroup(chooseUserType);

        EventHandler<ActionEvent> registerButtonClick = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = utf.getText();
                String password = pwf.getText();
                String repeatPassword = rpwf.getText();
                String userType;

                if (playerButton == (ToggleButton) chooseUserType.getSelectedToggle()){
                    userType = playerText;

                    // Repeated code needed to set the error message onto the label. Otherwise, the
                    // method has to be repeated and that's more code being repeated.
                    try {
                        register(username, password, repeatPassword, userType);
                    } catch (RuntimeException e){
                        error.setText(e.getMessage());
                    }
                } else if (designerButton == (ToggleButton) chooseUserType.getSelectedToggle()) {
                    userType = designerText;
                    try {
                        register(username, password, repeatPassword, userType);
                    } catch (RuntimeException e){
                        error.setText(e.getMessage());
                    }
                } else {
                    Popup wallpopup = new Popup();
                    Button close = new Button("Close");
                    Label label = new Label("Please choose a user type.");
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
        };

        GridPane buttons = new GridPane();
        buttons.addRow(0,playerButton,designerButton);
        buttons.addRow(1, regis, goBackButton);

        regis.setOnAction(registerButtonClick);

        goBackButton.setOnAction(actionEvent ->
                ScreenManager.changeScreen("login")
        );

        primaryStage.setTitle("Register");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);


        root.setVgap(10);
        root.addRow(0, formgp);
        root.addRow(1, error);
        root.addRow(2, choose);
        root.addRow(3, buttons);

        Scene scene = new Scene(root, 1234, 750);
        String css = this.getClass().getResource("/logres.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void register(String username, String password, String repeatPassword, String userType) {

        UserRegisterResponseModel responseModel = controller.registerUser(username, password,
                repeatPassword, userType);
        UserSingleton singleton = UserSingleton.getInstance();
        singleton.setUsername(responseModel.getUsername());

        if (responseModel.getUserType().equals("Player")) {
            ScreenManager.changeScreen("home");

        } else if (responseModel.getUserType().equals("Designer")) {
            ScreenManager.changeScreen("designer");
        }
    }
}
