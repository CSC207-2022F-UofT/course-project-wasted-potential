package UserLogin;

import javafx.stage.Stage;
import screens.MazeDesignerUI;

public class UserLoginView implements UserLoginViewInterface{
    Stage stage = new Stage();
    MazeDesignerUI designerUI;


    @Override
    public void updatePlayerView() {
        /* Update view */
    }


    @Override
    public void updateDesignerView() {
        try {
            designerUI.start(stage);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
