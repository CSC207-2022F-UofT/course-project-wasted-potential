package hints;

import entities.GameState;
import entities.MazeCell;

import java.util.List;

/**
 * The type Hint generator interactor.
 */
public class HintGeneratorInteractor implements HintGeneratorInBoundary {
    private final HintGeneratorOutBoundary hintGeneratorOutBoundary;

    /**
     * Instantiates a new Hint generator interactor.
     *
     * @param hintGeneratorOutBoundary the hint generator out boundary
     */
    public HintGeneratorInteractor(HintGeneratorOutBoundary hintGeneratorOutBoundary) {
        this.hintGeneratorOutBoundary = hintGeneratorOutBoundary;
    }

    public HintResponseModel generateHint(GameState maze) {
        List<MazeCell> hintPath = HintGenerator.generateHint(maze);
        HintResponseModel responseModel = new HintResponseModel(hintPath);
        return hintGeneratorOutBoundary.displayHint(responseModel);
    }
}
