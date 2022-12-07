package display;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import screens.MazeDatabase;

public class MazeDisplayInteractorTest {
//    @Test
//    public void createTest() {

//        MazeDsGateway mazeGateway = new MazeDatabase("./mazes.csv"); // doesn't implement mazeDSGateway fsr
//        PlayerDsGateway playerGateway = new UserDatabase(); // not on main branch yet exist yet
//        MazeDisplayOutputBoundary presenter = new MazeDisplayPresenter();
//        MazeDisplayInteractor interactor = new MazeDisplayInteractor(playerGateway, mazeGateway, presenter);
//
//        // make fake request
//        MazeDisplayRequestModel request = new MazeDisplayRequestModel("bob", 123);
//
//        MazeDisplayResponseModel response = interactor.create(request);

        // test if response is correct
        /*
            1. check if the gameState in the response actually corresponds to the id 123
            2. check if the maze was added to their played list
         */


        /*
        1. create MazeDisplayInteractor
            - requires
                - playerDSGateway (nothing implements this)
                - mazeDSGateway (nothing implements this)
                - mazeDisplayOutputBoundary (implemented by MazeDisplayPresenter)
        2. create fake requestModel
            - requires:
                - player username
                - mazeID
         it seems like create does this
            . add the mazeID to a players "played list" in the player database
            - gets the published maze associated with mazeID from maze database
            - creates a response model containing the published maze
            - returns the response model

         */

//    }
}
