package screens;
import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;

public class ScreenManager {
    private static Map<String, Screen> Screens = new HashMap<String, Screen>();
    private static Stage gameStage;

    static void addScreen(String name, Screen screen) {
        Screens.put(name, screen);
    }

    static void changeScreen(String name) throws RuntimeException {
        if (!Screens.containsKey(name)) {
            throw new RuntimeException("Specified screen does not exist in ScreenManager");
        }
        else {
            Screen requestedScreen = Screens.get(name);
            requestedScreen.start(gameStage);
        }
    }

    static void setStage(Stage stage) {
        gameStage = stage;
    }

}