package hints;

import entities.MazeCell;

import java.util.List;

/**
 * The type Hint response model.
 */
public class HintResponseModel {
    private List<MazeCell> hint;

    /**
     * Instantiates a new Hint response model.
     *
     * @param hint the hint
     */
    public HintResponseModel(List<MazeCell> hint) {
        this.hint = hint;
    }

    /**
     * Gets hint.
     *
     * @return the hint
     */
    public List<MazeCell> getHint() {
        return hint;
    }
}
