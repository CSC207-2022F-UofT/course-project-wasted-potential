package hints;

import entities.GameState;

/**
 * The interface Hint generator in boundary.
 */
public interface HintGeneratorInBoundary {
    /**
     * Generate hint hint response model.
     *
     * @param maze the maze
     * @return the hint response model
     */
    HintResponseModel generateHint(GameState maze);
}
