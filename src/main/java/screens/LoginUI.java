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
 * The Login User Interface
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

        Label userl = new Label("Username");
        Label pwdl = new Label("Password");
        Label error = new Label();

        Text title = new Text("Maze Gae");
        Text subtitle = new Text("Made by: Team Wasted Pot");
        title.getStyleClass().add("title-text");
        subtitle.getStyleClass().add("subtitle-text");

        TextField utf = new TextField();
        PasswordField pwf = new PasswordField();

        GridPane formgp = new GridPane();
        formgp.setAlignment(Pos.CENTER);
        formgp.setHgap(10);
        formgp.setVgap(10);
        formgp.setPadding(new Insets(25, 25, 25, 25));
        formgp.add(userl,0,0);
        formgp.add(utf,2,0);

        formgp.add(pwdl,0,1);
        formgp.add(pwf,2,1);

        Button login = new Button("Login");
        login.setAlignment(Pos.CENTER_RIGHT);
        Button regis = new Button("Don't have an account? Register!");

        EventHandler<ActionEvent> eventButtonClick = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (actionEvent.getSource() == login){
                    String username = utf.getText();
                    String password = pwf.getText();
                    // try {
                        UserLoginResponseModel responseModel = controller.loginUser(username, password);
                        UserSingleton singleton = UserSingleton.getInstance();
                        singleton.setUsername(responseModel.getUsername());

                        if (responseModel.getUserType().equals("Player")) {
                            ScreenManager.changeScreen("home");
                        } else if (responseModel.getUserType().equals("Designer")) {
                            ScreenManager.changeScreen("designer");
                        }

                    // } catch (RuntimeException e){
                        //error.setText(e.getMessage());
                    //}

                } else if (actionEvent.getSource() == regis){
                    ScreenManager.changeScreen("register");
                }
            }
        };

        login.setOnAction(eventButtonClick);
        regis.setOnAction(eventButtonClick);

        primaryStage.setTitle("Log In");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);


        root.setVgap(10);
        root.addRow(0, title);
        root.addRow(1, subtitle);
        root.addRow(2, formgp);
        root.addRow(3, error);
        root.addRow(4, regis);
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
