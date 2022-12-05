//package navigation;
//
//import org.junit.Assert;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.Assertions;
//
//class MazeNavInteractorTest {
//
//    @Test
//    public void moveIconTest() {
//
//        MazeNavOutputBoundary outputBoundary = new MazeNavOutputBoundary() {
//            @Override
//            public MazeNavResponseModel moveIcon(MazeNavResponseModel responseModel) {
//                return responseModel;
//            }
//
//            @Override
//            public MazeNavResponseModel mazeComplete(String message) {
//                throw new MazeComplete("hey");
//            }
//
//            @Override
//            public MazeNavResponseModel prepareFailView(String error) {
//                throw new InvalidMove("hey");
//            }
//
//            MazeNavInputBoundary interactor = new MazeNavInteractor(outputBoundary);
//
//            MazeNavRequestModel inputData = new MazeNavRequestModel('s', new int{0, 0}, GameState maze);
//
//            interactor.create(inputData);
//
//        };
//
//
//    }
//
//    @Test
//    public void mazeCompleteTest() {
//
//        MazeNavOutputBoundary outputBoundary = new MazeNavOutputBoundary() {
//            @Override
//            public MazeNavResponseModel moveIcon(MazeNavResponseModel responseModel) {
//                return responseModel;
//            }
//
//            @Override
//            public MazeNavResponseModel mazeComplete(String message) {
//                throw new MazeComplete("hey");
//            }
//
//            @Override
//            public MazeNavResponseModel prepareFailView(String error) {
//                throw new InvalidMove("hey");
//            }
//
//            MazeNavInputBoundary interactor = new MazeNavInteractor(outputBoundary);
//
//            MazeNavRequestModel inputData = new MazeNavRequestModel('s', new int{0, 0}, GameState maze);
//
//            interactor.create(inputData);
//
//        };
//
//
//    }
//
//    @Test
//    public void invalidMoveTest() {
//
//        MazeNavOutputBoundary outputBoundary = new MazeNavOutputBoundary() {
//            @Override
//            public MazeNavResponseModel moveIcon(MazeNavResponseModel responseModel) {
//                return responseModel;
//            }
//
//            @Override
//            public MazeNavResponseModel mazeComplete(String message) {
//                throw new MazeComplete("hey");
//            }
//
//            @Override
//            public MazeNavResponseModel prepareFailView(String error) {
//                throw new InvalidMove("hey");
//            }
//
//            MazeNavInputBoundary interactor = new MazeNavInteractor(outputBoundary);
//
//            MazeNavRequestModel inputData = new MazeNavRequestModel('s', new int{0, 0}, GameState maze);
//
//            interactor.create(inputData);
//
//        };
//
//
//    }
//}
