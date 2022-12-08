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


/**
 * The user registration user interface.
 */
public class RegisterUI extends Application implements Screen{

    private UserRegisterController controller;

    /**
     * Instantiates a new Register UI.
     *
     * @param controller the controller
     */
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

        Label userLabel = new Label("Create Username");
        Label passwordLabel = new Label("Create Password");
        Label reconfirmPasswordLabel = new Label("Reconfirm Password");

        TextField userTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        PasswordField repeatedPasswordField = new PasswordField();

        GridPane formGridPane = new GridPane();
        formGridPane.setAlignment(Pos.CENTER);
        formGridPane.setHgap(10);
        formGridPane.setVgap(10);
        formGridPane.setPadding(new Insets(25, 25, 25, 25));
        formGridPane.add(userLabel,0,0);
        formGridPane.add(userTextField,2,0);

        formGridPane.add(passwordLabel,0,1);
        formGridPane.add(passwordField,2,1);

        formGridPane.add(reconfirmPasswordLabel,0,2);
        formGridPane.add(repeatedPasswordField,2,2);

        Label choose = new Label("Please choose a user type:");
        Label error = new Label();
        Button register = new Button("Register");

        Button goBackButton = new Button("Go back");
        goBackButton.getStyleClass().add("go-back-button");

        ToggleButton designerButton = new ToggleButton(designerText);
        ToggleButton playerButton = new ToggleButton(playerText);
        ToggleGroup chooseUserType = new ToggleGroup();
        designerButton.setToggleGroup(chooseUserType);
        playerButton.setToggleGroup(chooseUserType);

        EventHandler<ActionEvent> registerButtonClick = (ActionEvent actionEvent) -> {
            String username = userTextField.getText();
            String password = passwordField.getText();
            String repeatPassword = repeatedPasswordField.getText();
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
                Popup wallPopup = new Popup();
                Button close = new Button("Close");
                Label label = new Label("Please choose a user type.");
                GridPane popupPane = new GridPane();
                popupPane.addRow(0, label);
                popupPane.addRow(1, close);
                wallPopup.getContent().add(popupPane);
                popupPane.setStyle(" -fx-background-color: #CF6679; \n -fx-border-color: black;");
                close.setStyle("-fx-background-color: #BB86FC;");

                popupPane.setMinHeight(100);
                popupPane.setMinWidth(234);
                popupPane.setAlignment(Pos.CENTER);

                label.setMinWidth(80);
                label.setMinHeight(50);

                EventHandler<ActionEvent> popupHandler = (ActionEvent popupEvent) -> {
                    if (popupEvent.getSource()==close){
                        wallPopup.hide();
                    }

                };
                close.setOnAction(popupHandler);
                wallPopup.show(primaryStage);
            }
        };

        GridPane buttons = new GridPane();
        buttons.addRow(0,playerButton,designerButton);
        buttons.addRow(1, register, goBackButton);

        register.setOnAction(registerButtonClick);

        goBackButton.setOnAction(actionEvent ->
                ScreenManager.changeScreen("login")
        );

        primaryStage.setTitle("Register");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);


        root.setVgap(10);
        root.addRow(0, formGridPane);
        root.addRow(1, error);
        root.addRow(2, choose);
        root.addRow(3, buttons);

        Scene scene = new Scene(root, 1234, 750);
        String css = this.getClass().getResource("/logres.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Register.
     *
     * @param username       the username
     * @param password       the password
     * @param repeatPassword the repeat password
     * @param userType       the user type
     */
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
