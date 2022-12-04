package hints;

import entities.GameState;

public interface HintGeneratorInBoundary {
    HintResponseModel generateHint(GameState maze);
}
