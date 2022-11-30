package screens;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import UserLogin.UserLoginController;


public class LoginUI extends Application{

    private UserLoginController controller;

    public LoginUI(UserLoginController controller){
        this.controller = controller;
    }
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage){

        Label userl = new Label("Username");
        Label pwdl = new Label("Password");

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
                    // store login response model and
                    // call functions in scene manager in if else depending on designer or player.
                    controller.loginUser(username, password);
                } else if (actionEvent.getSource() == regis){
                    // call function in scene manager class
                }
            }
        };

        primaryStage.setTitle("Log In");
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);


        root.setVgap(10);
        root.addRow(0, formgp);
        root.addRow(1, regis);
        root.addRow(2, login);

        GridPane maze = new GridPane();

        root.addRow(1, maze);

        Scene scene = new Scene(root, 432, 321);
        String css = this.getClass().getResource("/logres.css").toExternalForm();
        scene.getStylesheets().add(css);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
