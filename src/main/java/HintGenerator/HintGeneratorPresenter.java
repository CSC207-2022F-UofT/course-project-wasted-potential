package HintGenerator;

import entities.MazeCell;

import java.util.List;

public class HintGeneratorPresenter implements HintGeneratorOutBoundary {
    public void displayHint(List<MazeCell> hint) {
        System.out.println(hint);
    }
}
