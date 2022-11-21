package RegisterAndLoginSharedClasses;

import javafx.stage.Stage;
import screens.MazeDesignerUI;

public class RegisterAndLoginView implements RegisterAndLoginViewInterface{
    Stage stage = new Stage();
    MazeDesignerUI designerUI;


    /* @Override
    public void updatePlayerView() {
        /* Update view */
    // }


    @Override
    public void updateDesignerView() {
        try {
            designerUI.start(stage);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
