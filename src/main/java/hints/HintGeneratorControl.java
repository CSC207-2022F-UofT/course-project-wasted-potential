package hints;

import entities.GameState;

public class HintGeneratorControl {
    private HintGeneratorInBoundary hintGeneratorInBoundary;

    public HintGeneratorControl(HintGeneratorInBoundary hintGeneratorInBoundary) {
        this.hintGeneratorInBoundary = hintGeneratorInBoundary;
    }

    public HintResponseModel generateHint(GameState maze) {
        return hintGeneratorInBoundary.generateHint(maze);
    }

}
