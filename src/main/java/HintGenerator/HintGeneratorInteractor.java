package HintGenerator;

import entities.GameState;
import entities.MazeCell;

import java.util.List;

public class HintGeneratorInteractor implements HintGeneratorInBoundary {
    private HintGeneratorOutBoundary hintGeneratorOutBoundary;

    public HintGeneratorInteractor(HintGeneratorOutBoundary hintGeneratorOutBoundary) {
        this.hintGeneratorOutBoundary = hintGeneratorOutBoundary;
    }

    public void generateHint(GameState maze) {
        List<MazeCell> hint_path = HintGenerator.generateHint(maze);
        hintGeneratorOutBoundary.displayHint(hint_path);
    }
}
