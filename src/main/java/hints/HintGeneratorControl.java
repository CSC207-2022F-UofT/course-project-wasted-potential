package hints;

import entities.GameState;

/**
 * The type Hint generator control.
 */
public class HintGeneratorControl {
    private final HintGeneratorInBoundary hintGeneratorInBoundary;

    /**
     * Instantiates a new Hint generator control.
     *
     * @param hintGeneratorInBoundary the hint generator in boundary
     */
    public HintGeneratorControl(HintGeneratorInBoundary hintGeneratorInBoundary) {
        this.hintGeneratorInBoundary = hintGeneratorInBoundary;
    }

    /**
     * Generate hint response model.
     *
     * @param maze the maze
     * @return the hint response model
     */
    public HintResponseModel generateHint(GameState maze) {
        return hintGeneratorInBoundary.generateHint(maze);
    }

}
