package hints;

import entities.GameState;

public interface HintGeneratorInBoundary {
    public HintResponseModel generateHint(GameState maze);
}
