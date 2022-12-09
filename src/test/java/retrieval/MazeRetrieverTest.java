package retrieval;

import databases.MazeDatabase;
import databases.UserDatabase;
import display.MazeDsGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import register_and_login_shared_classes.UserRegisterAndLoginDsGateway;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.zip.DataFormatException;

public class MazeRetrieverTest {
    @Test
    public void createTest() throws FileNotFoundException, DataFormatException {
        UserRegisterAndLoginDsGateway gateway;
        try{
            gateway = new UserDatabase("./users.csv");
        } catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        }
        MazeDatabase md;
        try {
            md = new MazeDatabase("./mazes.csv");
        }
        catch (IOException e) {
            throw new FileNotFoundException("Could not create file.");
        } catch (ParseException e) {
            throw new DataFormatException("Creation date is incorrect.");
        }
        MazeDsGateway mazeDsGateway = md;
        MazeRetrieverOutputBoundary mazeRetrieverPresenter = new MazeRetrieverPresenter();
        MazeRetrieverDsGateway mazeRetrieverDsGateway = (MazeRetrieverDsGateway) gateway;
        MazeRetrieverInputBoundary mazeRetrieverInteractor = new MazeRetrieverInteractor(mazeRetrieverDsGateway, mazeRetrieverPresenter, mazeDsGateway);
        MazeRetrieverFacade mazeRetrieverFacade = new MazeRetrieverFacade(mazeRetrieverDsGateway, mazeDsGateway);
        MazeRetrieverResponseModel mazeRetrieverResponseModel = mazeRetrieverInteractor.create(new MazeRetrieverRequestModel("oscar"));

        Assertions.assertEquals(mazeRetrieverFacade.retrieveMazesPlayed("oscar"), mazeRetrieverResponseModel.getPlayed());
        Assertions.assertEquals(mazeRetrieverFacade.retrieveMazesNotPlayed("oscar"), mazeRetrieverResponseModel.getNotPlayed());
    }
}
