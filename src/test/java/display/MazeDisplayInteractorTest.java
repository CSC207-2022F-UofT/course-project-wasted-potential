package display;

import databases.MazeDatabase;
import databases.UserDatabase;

import entities.GameState;
import entities.PublishedMaze;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Arrays;

public class MazeDisplayInteractorTest {
    @Test
    public void createTest() throws IOException, ParseException {

        MazeDsGateway mazeGateway = new MazeDatabase("./mazes.csv") {
            @Override
            public PublishedMaze retrieveMaze(int mazeId) {
                Assertions.assertEquals(3, mazeId);

                char[][] fakeState =  {
                    {'#', '#', '#', '#'},
                    {'#', 'S', 'E', '#'},
                    {'#', '#', '#', '#'}
                };

                return new PublishedMaze("Anya", "coolMaze",
                        true, LocalDate.of(1, 2, 3), fakeState, new int[]{1, 1},
                        3, 4, 3);
            }
        };
        PlayerDsGateway playerGateway = new UserDatabase("./users.csv") {
            @Override
            public void addToPlayed(int mazeId, String username) {
                // ensure the correct maze is being added to the user database
                Assertions.assertEquals("Nezuko", username);
                Assertions.assertEquals(3, mazeId);
            }
        };
        MazeDisplayOutputBoundary presenter = new MazeDisplayPresenter() {
            @Override
            public MazeDisplayResponseModel displayMaze(MazeDisplayResponseModel responseModel) {
                GameState gameState = responseModel.getMaze();


                Assertions.assertEquals("Anya", gameState.getAuthor());
                Assertions.assertEquals("coolMaze", gameState.getName());

                char[][] fakeState =  {
                        {'#', '#', '#', '#'},
                        {'#', 'S', 'E', '#'},
                        {'#', '#', '#', '#'}
                };

                char[][] displayGameState = gameState.getState();

                for (int i = 0; i < displayGameState.length; i++) {
                    Assertions.assertArrayEquals(fakeState[i], displayGameState[i]);
                }

                Assertions.assertEquals(3, gameState.getNumRow());
                Assertions.assertEquals(4, gameState.getNumCol());
                Assertions.assertEquals(3, gameState.getId());

                return null;
            }
        };

        // create fake mazeDisaplyRequestModel
        MazeDisplayRequestModel requestModel = new MazeDisplayRequestModel("Nezuko", 3);

        MazeDisplayInteractor interactor = new MazeDisplayInteractor(playerGateway, mazeGateway, presenter);
        interactor.create(requestModel);

    }
}
