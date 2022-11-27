package UserRegistration;

import javafx.stage.Stage;

public class UserRegisterView implements UserRegisterViewInterface{
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
