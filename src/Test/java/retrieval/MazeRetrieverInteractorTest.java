package retrieval;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MazeRetrieverInteractorTest {

    @Test
    //MazeRetrieverDsGateway dsGateway
    MazeRetrieverOutputBoundary outputBoundary = new MazeRetrieverOutputBoundary() {
        @Override
        public MazeRetrieverResponseModel displayMazes(MazeRetrieverResponseModel responseModel) {
            return responseModel;
        }
    };
    MazeRetrieverInteractor interactor = new MazeRetrieverInteractor(outputBoundary);


}
