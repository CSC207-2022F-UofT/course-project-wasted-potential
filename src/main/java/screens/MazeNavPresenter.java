package screens;

import maze_nav_use_case.*;

/**
 * The Presenter for the Maze Navigation Use Case.
 *
 * @author Oscar Tuvey
 */
public class MazeNavPresenter implements MazeNavOutputBoundary {

    final MazeNavViewInterface viewInterface;

    /**
     * The constructor for the MazeNavPresenter class.
     *
     * @param viewInterface the interface which passes information to the view
     */
    public MazeNavPresenter(MazeNavViewInterface viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Override
    public MazeNavResponseModel moveIcon(MazeNavResponseModel responseModel) {
        viewInterface.moveIcon(responseModel.getRequestedPosition());

        return responseModel;
    }

    @Override
    public MazeNavResponseModel mazeComplete(MazeNavResponseModel responseModel) {
        viewInterface.mazeComplete("Congratulations! You've completed the maze.");

        return responseModel;
    }

    @Override
    public MazeNavResponseModel prepareFailView(MazeNavResponseModel responseModel) {
        viewInterface.prepareFailView("Invalid move. Please try again");

        throw new InvalidMove("Invalid move. Please try again"); // Necessary?
    }
}
