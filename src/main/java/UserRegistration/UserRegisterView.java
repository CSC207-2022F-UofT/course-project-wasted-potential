package UserRegistration;

import javafx.stage.Stage;

public class UserRegisterView implements UserRegisterViewInterface{
    /**
     * The Stage.
     */
    Stage stage = new Stage();
    /**
     * The Designer ui.
     */
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
