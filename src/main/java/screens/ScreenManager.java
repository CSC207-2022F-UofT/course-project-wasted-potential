package screens;
import java.util.HashMap;
import java.util.Map;
import javafx.stage.Stage;

/**
 * Manages the screens which are displayed to the user.
 */
public class ScreenManager {
    private static Map<String, Screen> Screens = new HashMap<>();
    private static Stage gameStage;

    private ScreenManager() {}

    /**
     * Adds a screen to the list of screens
     *
     * @param name   the name of the screen as a string
     * @param screen the screen the UI class
     */
    public static void addScreen(String name, Screen screen) {
        Screens.put(name, screen);
    }

    /**
     * Changes screen.
     *
     * @param name the name of the screen to be changed to
     * @throws IllegalArgumentException the illegal argument exception
     */
    public static void changeScreen(String name) throws IllegalArgumentException {
        if (!Screens.containsKey(name)) {
            throw new IllegalArgumentException("Specified screen does not exist in ScreenManager");
        }
        else {
            Screen requestedScreen = Screens.get(name);
            requestedScreen.start(gameStage);
        }
    }

    /**
     * Sets stage.
     *
     * @param stage the stage
     */
    public static void setStage(Stage stage) {
        gameStage = stage;
    }

}