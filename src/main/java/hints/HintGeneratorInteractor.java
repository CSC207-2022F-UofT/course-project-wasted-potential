package hints;

import entities.GameState;
import entities.MazeCell;

import java.util.List;

public class HintGeneratorInteractor implements HintGeneratorInBoundary {
    private HintGeneratorOutBoundary hintGeneratorOutBoundary;

    public HintGeneratorInteractor(HintGeneratorOutBoundary hintGeneratorOutBoundary) {
        this.hintGeneratorOutBoundary = hintGeneratorOutBoundary;
    }

    public HintResponseModel generateHint(GameState maze) {
        List<MazeCell> hintPath = HintGenerator.generateHint(maze);
        HintResponseModel responseModel = new HintResponseModel(hintPath);
        return hintGeneratorOutBoundary.displayHint(responseModel);
    }
}
