package screens;
import javafx.scene.text.Text;
import user_login.UserLoginResponseModel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import user_login.UserLoginController;


/**
 * The user login user interface
 */
public class LoginUI extends Application implements Screen{

    private UserLoginController controller;

    /**
     * The constructor that instantiates the Login UI.
     *
     * @param controller the controller.
     */
    public LoginUI(UserLoginController controller){
        this.controller = controller;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage){

        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");
        Label error = new Label();

        Text title = new Text("Maze Game");
        Text subtitle = new Text("Made by: Team Wasted Potential");
        title.getStyleClass().add("title-text");
        subtitle.getStyleClass().add("subtitle-text");

        TextField userTextField = new TextField();
        PasswordField passwordField = new PasswordField();

        GridPane formGridPane = new GridPane();
        formGridPane.setAlignment(Pos.CENTER);
        formGridPane.setHgap(10);
        formGridPane.setVgap(10);
        formGridPane.setPadding(new Insets(25, 25, 25, 25));
        formGridPane.add(usernameLabel,0,0);
        formGridPane.add(userTextField,2,0);

        formGridPane.add(passwordLabel,0,1);
        formGridPane.add(passwordField,2,1);

        Button login = new Button("Login");
        login.setAlignment(Pos.CENTER_RIGHT);
        Button register = new Button("Don't have an account? Register!");

        EventHandler<ActionEvent> eventButtonClick = (ActionEvent actionEvent) -> {
            if (actionEvent.getSource() == login){
                String username = userTextField.getText();
                String password = passwordField.getText();
                try {
                    UserLoginResponseModel responseModel = controller.loginUser(username, password);
                    UserSingleton singleton = UserSingleton.getInstance();
                    singleton.setUsername(responseModel.getUsername());

                    if (responseModel.getUserType().equals("Player")) {
                        ScreenManager.changeScreen("home");
                    } else if (responseModel.getUserType().equals("Designer")) {
                        ScreenManager.changeScreen("designer");
                    }

                } catch (RuntimeException e){
                    error.setText(e.getMessage());
                }

            } else if (actionEvent.getSource() == register){
                ScreenManager.changeScreen("register");
            }
        };

        login.setOnAction(eventButtonClick);
        register.setOnAction(eventButtonClick);

        primaryStage.setTitle("Log In");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);


        root.setVgap(10);
        root.addRow(0, title);
        root.addRow(1, subtitle);
        root.addRow(2, formGridPane);
        root.addRow(3, error);
        root.addRow(4, register);
        root.addRow(5, login);

        GridPane maze = new GridPane();

        root.addRow(1, maze);

        Scene scene = new Scene(root, 1234, 750);
        String css = this.getClass().getResource("/logres.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
