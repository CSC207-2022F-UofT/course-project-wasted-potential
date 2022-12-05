package display;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import retrieval.MazeRetrieverDsGateway;

public class MazeDisplayInteractorTest {

    MazeDisplayOutputBoundary outputBundary = new MazeDisplayOutputBoundary() {
        @Override
        public MazeDisplayResponseModel displayMaze(MazeDisplayResponseModel responseModel) {
            return responseModel;
        }
    };
    MazeDsGateway =
    PlayerDsGateway =

    MazeDisplayInputBoundary MazeDisplayInteractor = new MazeDisplayInputBoundary(playerDsGateway,
            mazeDsGateway, outputBundary);

}
