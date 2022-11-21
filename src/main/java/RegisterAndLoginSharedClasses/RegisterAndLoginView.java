package RegisterAndLoginSharedClasses;

import javafx.stage.Stage;

/**
 * The type Register and login view.
 */
public class RegisterAndLoginView implements RegisterAndLoginViewInterface{
    /**
     * The Stage.
     */
    Stage stage = new Stage();
    /**
     * The Designer ui.
     */
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
