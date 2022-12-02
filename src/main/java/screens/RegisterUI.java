package screens;
import UserRegistration.Singleton;
import UserRegistration.UserRegisterController;
import UserRegistration.UserRegisterResponseModel;
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
        Button designer = new Button("Designer");
        Button player = new Button("Player");
        Button regis = new Button("Register");

        ToggleButton designerButton = new ToggleButton("Designer");
        ToggleButton playerButton = new ToggleButton("Player");
        ToggleGroup chooseUserType = new ToggleGroup();
        designerButton.setToggleGroup(chooseUserType);
        playerButton.setToggleGroup(chooseUserType);

        EventHandler<ActionEvent> registerButtonClick = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String username = utf.getText();
                String password = pwf.getText();
                String repeatPassword = pwf.getText();
                String userType = " ";

                if (playerButton == (ToggleButton) chooseUserType.getSelectedToggle()){
                    userType = "Player";
                    register(username, password, repeatPassword, userType);
                } else if (designerButton == (ToggleButton) chooseUserType.getSelectedToggle()) {
                    userType = "Designer";
                    register(username, password, repeatPassword, userType);
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
        buttons.addRow(1, regis);

        regis.setOnAction(registerButtonClick);

        primaryStage.setTitle("Register");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);


        root.setVgap(10);
        root.addRow(0, formgp);
        root.addRow(1, choose);
        root.addRow(2, buttons);

        Scene scene = new Scene(root, 432, 321);
        String css = this.getClass().getResource("/logres.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void register(String username, String password, String repeatPassword, String userType){
        UserRegisterResponseModel responseModel = controller.registerUser(username, password,
                repeatPassword, userType);
        Singleton.getInstance(responseModel.getUsername());

        System.out.println(responseModel.getUserType());
        if (responseModel.getUserType().equals("Player")){
            //ScreenManager.changeScreen("play");

        } else if (responseModel.getUserType().equals("Designer")){
            // ScreenManager.changeScreen("designer");

        } else {
            //throw an exception??
        }
    }

}
