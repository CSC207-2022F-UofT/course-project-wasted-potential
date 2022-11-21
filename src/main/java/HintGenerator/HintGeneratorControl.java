package HintGenerator;

import entities.GameState;

public class HintGeneratorControl {
    private HintGeneratorInBoundary hintGeneratorInBoundary;

    public HintGeneratorControl(HintGeneratorInBoundary hintGeneratorInBoundary) {
        this.hintGeneratorInBoundary = hintGeneratorInBoundary;
    }

    public void generateHint(GameState maze) {
        hintGeneratorInBoundary.generateHint(maze);
    }

}
